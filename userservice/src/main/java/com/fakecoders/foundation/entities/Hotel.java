package com.fakecoders.foundation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel implements Serializable{
	
	private String hotelid;
	
	private String name;
	
	private String loction;
	
	private String about;

}
