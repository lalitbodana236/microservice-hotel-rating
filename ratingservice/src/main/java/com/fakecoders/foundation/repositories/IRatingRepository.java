package com.fakecoders.foundation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fakecoders.foundation.entities.Rating;

public interface IRatingRepository extends JpaRepository<Rating, String> {
	
	List<Rating> findByUserid(String userid);
	
	List<Rating> findByHotelid(String hotelid);
}
