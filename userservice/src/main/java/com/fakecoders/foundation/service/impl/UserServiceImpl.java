package com.fakecoders.foundation.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fakecoders.foundation.entities.Hotel;
import com.fakecoders.foundation.entities.Rating;
import com.fakecoders.foundation.entities.User;
import com.fakecoders.foundation.exception.ResourceNotFoundException;
import com.fakecoders.foundation.extrnal.services.IHotelService;
import com.fakecoders.foundation.extrnal.services.IRatingService;
import com.fakecoders.foundation.repository.IUserRepository;
import com.fakecoders.foundation.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IRatingService ratingService;

	@Override
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		 List<User> userList = userRepo.findAll();
			for(User user : userList) {
				List<Rating> ratingList = ratingService.getRating(user.getUserId());
				//List<Rating> ratingList=Arrays.stream(response.getBody()).toList();
				//System.out.println(ratingList +" "+response.getStatusCode());
				user.setRating(ratingList);
				for(Rating rate : ratingList) {
					Hotel hotelRes = hotelService.getHotel(rate.getHotelid());
					rate.setHotel(hotelRes);
				}
			}
			return userList;
	}

	@Override
	public User getUser(String userid) 
	{
		User user = userRepo.findById(userid).orElseThrow(()-> new ResourceNotFoundException("Resource not found for "+userid));
		if(user!=null) {
			System.out.println("user "+user.getUserId());
		//	ResponseEntity<Rating[]> response = restTemplate.getForEntity("http://RATINGSERVICE/rating/user/"+user.getUserId(), Rating[].class);
		//	List<Rating> ratingList=Arrays.stream(response.getBody()).toList();
		//	System.out.println(ratingList +" "+response.getStatusCode());
			List<Rating> ratingList = ratingService.getRating(user.getUserId());
			user.setRating(ratingList);
			for(Rating rate : ratingList) {
				//ResponseEntity<Hotel> hotelRes = restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+rate.getHotelid(), Hotel.class);
				Hotel hotelRes = hotelService.getHotel(rate.getHotelid());
				rate.setHotel(hotelRes);
			}
		}
		return user;
	}

}
