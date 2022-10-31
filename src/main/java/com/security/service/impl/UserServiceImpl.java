package com.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repositoryes.UserRepository;
import com.security.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDetailsRepository ;
	@Override
	public String addUser(User userDetails) {
		this.userDetailsRepository.save(userDetails);
		return "User details add successfully..!!";
	}

	@Override
	public User updateUserDetails(User userDetails, int userId) {
		userDetails.setUserId(userId);
		User userDetail = this.userDetailsRepository.save(userDetails);
		return userDetail;
	}

}
