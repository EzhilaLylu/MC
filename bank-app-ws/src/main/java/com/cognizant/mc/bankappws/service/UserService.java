package com.cognizant.mc.bankappws.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cognizant.mc.bankappws.dto.LoanDto;
import com.cognizant.mc.bankappws.dto.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto userDto) throws Exception;
	UserDto getUser(String email);
	UserDto getUserById(String id);
	UserDto updateUser(String id, UserDto userDto);
	void deleteUser(String id);
	LoanDto applyLoan(LoanDto dto, String id) throws Exception;
	List<LoanDto> getLoanById(String loanId);

}
