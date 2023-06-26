package com.fakecoders.foundation.extrnal.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fakecoders.foundation.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface IRatingService {
	
	@GetMapping("rating/user/{userid}")
	List<Rating> getRating(@PathVariable String userid);

}
