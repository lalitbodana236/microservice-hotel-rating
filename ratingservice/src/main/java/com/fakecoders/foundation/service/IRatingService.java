package com.fakecoders.foundation.service;

import java.util.List;

import com.fakecoders.foundation.entities.Rating;

public interface IRatingService {
		
	Rating createRating(Rating rating);
	
	Rating getRating(String ratingId);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingByUserId(String userid);
	
	List<Rating> getRatingByHotelId(String hotelid);
}
