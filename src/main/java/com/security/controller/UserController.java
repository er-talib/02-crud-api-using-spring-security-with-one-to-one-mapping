package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userDetailsService ;
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder ;
	
	@PostMapping("/details")
	public ResponseEntity<?> addUser(@RequestBody User userDetails){
		userDetails.setPassword(this.bCryptPasswordEncoder.encode(userDetails.getPassword()));
		String user = this.userDetailsService.addUser(userDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@PutMapping("/details/update/{userId}")
	public ResponseEntity<?> addUser(@RequestBody User userDetails , @PathVariable int userId){
		userDetails.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		User userDetail = this.userDetailsService.updateUserDetails(userDetails,userId);
		return ResponseEntity.ok(userDetail);
	}
}
