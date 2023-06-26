package com.fakecoders.foundation.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fakecoders.foundation.entities.Rating;
import com.fakecoders.foundation.exception.ResourceNotFoundException;
import com.fakecoders.foundation.repositories.IRatingRepository;
import com.fakecoders.foundation.service.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService {
	
	@Autowired
	private IRatingRepository iRatingRepo;

	@Override
	public Rating createRating(Rating rating) {
		rating.setRatingid(UUID.randomUUID().toString());
		return iRatingRepo.save(rating);
	}

	@Override
	public Rating getRating(String ratingId) {
		return iRatingRepo.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("Resource not found for id "+ratingId));
	}

	@Override
	public List<Rating> getAllRating() {
		return iRatingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userid) {
		return iRatingRepo.findByUserid(userid);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelid) {
		return iRatingRepo.findByHotelid(hotelid);
	}

}
