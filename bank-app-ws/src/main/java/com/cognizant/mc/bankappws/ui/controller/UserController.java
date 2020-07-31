package com.cognizant.mc.bankappws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mc.bankappws.dto.UserDto;
import com.cognizant.mc.bankappws.service.UserService;
import com.cognizant.mc.bankappws.ui.model.UserDetailsModel;
import com.cognizant.mc.bankappws.ui.modelresp.UserResponse;

@RestController
@RequestMapping("users") 
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "User retrieved";
	}
	@PostMapping
	public UserResponse createUser(@RequestBody UserDetailsModel userDetail) {
		UserResponse userResponse = new UserResponse();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetail, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, userResponse);
		
		return userResponse;
	}
	@PutMapping
	public String updateUser() {
		return "User Updated";
	}
	@DeleteMapping
	public String deleteUser() {
		return "User Deleted";		
	}
}
