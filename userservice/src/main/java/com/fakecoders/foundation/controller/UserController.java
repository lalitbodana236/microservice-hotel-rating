package com.fakecoders.foundation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fakecoders.foundation.entities.Hotel;
import com.fakecoders.foundation.entities.Rating;
import com.fakecoders.foundation.entities.User;
import com.fakecoders.foundation.extrnal.services.IHotelService;
import com.fakecoders.foundation.extrnal.services.IRatingService;
import com.fakecoders.foundation.service.IUserService;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IRatingService ratingService;

	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User createdUser = iUserService.createUser(user);
		Rating r = new Rating();
		r.setFeedback("wonder full hotel");
		r.setUserid(createdUser.getUserId());
		r.setRate(2);

		HttpEntity<Rating> request = new HttpEntity(r);
		Rating r2=	restTemplate.postForObject("http://ratingservice/rating/", request,Rating.class);
		System.out.println(r2);
		createdUser.getRating().add(r2);
		createdUser.setRating(createdUser.getRating());
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	int retryCount=1;

	@GetMapping("/{userid}")
	//@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "rateHotelLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String userid){
		retryCount++;
		return ResponseEntity.ok(iUserService.getUser(userid));
	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(iUserService.getAllUser());
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userid,Exception ex){
		System.out.println(ex+" "+retryCount);
		
		return new ResponseEntity<>(new User(),HttpStatus.OK);
	}


}
