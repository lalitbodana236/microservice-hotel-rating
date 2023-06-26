package com.fakecoders.foundation.service;

import java.util.List;

import com.fakecoders.foundation.entities.User;

public interface IUserService {
	
	User createUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userid);
}
