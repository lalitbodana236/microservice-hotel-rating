package com.fakecoders.foundation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakecoders.foundation.entities.Rating;
import com.fakecoders.foundation.service.IRatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private IRatingService iRatingService;
	
	@PostMapping("/")
	public ResponseEntity<Rating> createUser(@RequestBody Rating rating){
		Rating createdUser = iRatingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	@GetMapping("/{ratingid}")
	public ResponseEntity<Rating> getUser(@PathVariable String ratingid){
		return ResponseEntity.ok(iRatingService.getRating(ratingid));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllUser(){
		return ResponseEntity.ok(iRatingService.getAllRating());
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userid){
		System.out.println("userid "+userid);
		return ResponseEntity.ok(iRatingService.getRatingByUserId(userid));
	}
	
	@GetMapping("/hotel/{hotelid}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelid){
		return ResponseEntity.ok(iRatingService.getRatingByHotelId(hotelid));
	}

}
