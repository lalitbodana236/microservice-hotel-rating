package com.fakecoders.foundation.service;

import java.util.List;

import com.fakecoders.foundation.entities.Hotel;

public interface IHotelService {
	
	Hotel createHotel(Hotel hotel);
	
	Hotel getHotel(String name);
	
	List<Hotel> getAllHotel();
}
