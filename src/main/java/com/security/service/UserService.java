package com.security.service;

import com.security.entity.User;

public interface UserService {
	
	
	public String addUser(User userDetails);
	public User updateUserDetails(User userDetails , int userId);

}
