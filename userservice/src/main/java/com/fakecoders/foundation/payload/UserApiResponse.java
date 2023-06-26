package com.fakecoders.foundation.payload;

import java.util.ArrayList;
import java.util.List;

import com.fakecoders.foundation.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {
	
	private List<User> userList =new ArrayList<>();
	
	private User user;
	
private String message;
	
	private Boolean success;
	
	private String status;

}
