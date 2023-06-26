package com.fakecoders.foundation.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
	
	private String ratingid;
	
	private String feedback;
	
	private Integer rate;
	
	private String userid;
	
	private User user;
}
