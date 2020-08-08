package com.cognizant.mc.bankappws.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.mc.bankappws.dto.LoanDto;
import com.cognizant.mc.bankappws.dto.UserDto;
import com.cognizant.mc.bankappws.io.entity.LoanEntity;
import com.cognizant.mc.bankappws.service.UserService;
import com.cognizant.mc.bankappws.ui.model.LoanDetailsModel;
import com.cognizant.mc.bankappws.ui.model.UserDetailsModel;
import com.cognizant.mc.bankappws.ui.modelresp.LoanResponseModel;
import com.cognizant.mc.bankappws.ui.modelresp.UserResponse;

@RestController
@RequestMapping("users") 
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/{id}")
	public UserResponse getUser(@PathVariable String id) {
		UserResponse response = new UserResponse();
		
		UserDto dto = userService.getUserById(id);
		BeanUtils.copyProperties(dto, response);
		
		return response;
	}
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserDetailsModel userDetail) throws Exception {
		UserResponse userResponse = new UserResponse();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetail, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, userResponse);
		
		return userResponse;
	}
	
	@PutMapping(path = "/{id}")
	public UserResponse updateUser(@PathVariable String id, @RequestBody UserDetailsModel userDetail) {
		UserResponse userResponse = new UserResponse();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetail, userDto);
		
		UserDto updatedUser = userService.updateUser(id, userDto);
		BeanUtils.copyProperties(updatedUser, userResponse);
		
		return userResponse;
		
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return "User Deleted";		
	}
	
	@PostMapping(path = "/{id}/loans")
	public LoanResponseModel applyLoan(@PathVariable String id, @RequestBody LoanDetailsModel loanDetailsModel) throws Exception {
		LoanResponseModel loanResponseModel = new LoanResponseModel();
		
		LoanDto dto = new LoanDto();
		BeanUtils.copyProperties(loanDetailsModel, dto);
		
		LoanDto appliedLoan = userService.applyLoan(dto,id);
		BeanUtils.copyProperties(appliedLoan, loanResponseModel);
				
		return loanResponseModel;
	}
	
	@GetMapping(path = "/{id}/loans")
	public List<LoanResponseModel> updateLoan(@PathVariable String id) {
		List<LoanResponseModel> response =  new ArrayList<LoanResponseModel>();
		
		List<LoanDto> dto = userService.getLoanById(id);
		
		BeanUtils.copyProperties(dto, response);

		for (LoanDto loanDto1 : dto) {
			LoanResponseModel loanResponse = new LoanResponseModel();
			BeanUtils.copyProperties(loanDto1, loanResponse);
			response.add(loanResponse);
		}
		return response;
	}
	
}
