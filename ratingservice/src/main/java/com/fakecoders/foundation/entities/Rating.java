package com.fakecoders.foundation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating implements Serializable{
	
	@Id
	private String ratingid;
	
	private String feedback;
	
	private String userid;
	
	private String hotelid;
	
	private Integer rate;

}
