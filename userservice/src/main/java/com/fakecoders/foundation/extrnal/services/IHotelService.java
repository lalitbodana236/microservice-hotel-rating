package com.fakecoders.foundation.extrnal.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fakecoders.foundation.entities.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface IHotelService {
	
	@GetMapping("hotel/{hotelid}")
	Hotel getHotel(@PathVariable String hotelid);
}
