package com.cognizant.mc.bankappws.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.mc.bankappws.accessor.Accessor;
import com.cognizant.mc.bankappws.dto.UserDto;
import com.cognizant.mc.bankappws.io.entity.UserEntity;
import com.cognizant.mc.bankappws.io.repository.UserRepository;
import com.cognizant.mc.bankappws.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	Accessor accessor;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		if(userRepository.findByEmail(userDto.getEmail()) != null){
			throw new RuntimeException("User Already Exist");
		}
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		
		
		userEntity.setPublicUserId(accessor.generateRandomString(10));
		//userEntity.setPublicUserId("TestID");
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		
		UserEntity registeredUser = userRepository.save(userEntity);
		
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(userEntity, dto);			
		
		return dto;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}

	
	@Override
	public UserDto getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(userEntity, dto);			
		
		return dto;
	}

}
