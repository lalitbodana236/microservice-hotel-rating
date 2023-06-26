package com.fakecoders.foundation.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating implements Serializable{
	
	
	

private String ratingid;
	
	private String feedback;
	
	private String userid;
	
	private String hotelid;
	
	private Integer rate;
	
	private Hotel hotel;

}
