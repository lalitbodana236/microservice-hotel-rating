package com.fakecoders.foundation.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fakecoders.foundation.entities.Hotel;
import com.fakecoders.foundation.exception.ResourceNotFoundException;
import com.fakecoders.foundation.repository.IHotelRepository;
import com.fakecoders.foundation.service.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelRepository iHotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		hotel.setHotelid(UUID.randomUUID().toString());
		return iHotelRepo.save(hotel);
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return iHotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Resource not found for id "+hotelId));
	}

	@Override
	public List<Hotel> getAllHotel() {
		return iHotelRepo.findAll();
	}

}
