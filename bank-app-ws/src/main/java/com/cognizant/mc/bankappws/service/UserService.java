package com.cognizant.mc.bankappws.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cognizant.mc.bankappws.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto userDto);
	UserDto getUser(String email);

}
