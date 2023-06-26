package com.fakecoders.foundation.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fakecoders.foundation.entities.Hotel;
import com.fakecoders.foundation.entities.Rating;
import com.fakecoders.foundation.entities.User;
import com.fakecoders.foundation.service.IHotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private IHotelService iHotelService;
	
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hot = iHotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hot);
	}
	
	@GetMapping("/{hotelid}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelid){
		return ResponseEntity.ok(iHotelService.getHotel(hotelid));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		return ResponseEntity.ok(iHotelService.getAllHotel());
	}
	
	/*@GetMapping("/{hotelid}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelid){
		Hotel hotel = iHotelService.getHotel(hotelid);
		if(hotel!=null) {
			ResponseEntity<Rating[]> response = restTemplate.getForEntity("http://RATINGSERVICE/rating/hotel/"+hotel.getHotelid(), Rating[].class);
			List<Rating> ratingList=Arrays.stream(response.getBody()).toList();
			for(Rating rating : ratingList) {
				ResponseEntity<User> userRes = restTemplate.getForEntity("http://USERSERVICE/user/"+rating.getUserid(), User.class);
				rating.setUser(userRes.getBody());
			}
		}
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotelList = iHotelService.getAllHotel();
		for(Hotel hotel :hotelList ) {
			if(hotel!=null) {
				ResponseEntity<Rating[]> response = restTemplate.getForEntity("http://RATINGSERVICE/rating/hotel/"+hotel.getHotelid(), Rating[].class);
				List<Rating> ratingList=Arrays.stream(response.getBody()).toList();
				for(Rating rating : ratingList) {
					ResponseEntity<User> userRes = restTemplate.getForEntity("http://USERSERVICE/user/"+rating.getUserid(), User.class);
					rating.setUser(userRes.getBody());
				}
			}
		}
		return ResponseEntity.ok(hotelList);
	}
*/
}
