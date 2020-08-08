package com.cognizant.mc.bankappws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.mc.bankappws.accessor.Accessor;
import com.cognizant.mc.bankappws.dto.LoanDto;
import com.cognizant.mc.bankappws.dto.UserDto;
import com.cognizant.mc.bankappws.exceptions.UserServiceException;
import com.cognizant.mc.bankappws.io.entity.LoanEntity;
import com.cognizant.mc.bankappws.io.entity.UserEntity;
import com.cognizant.mc.bankappws.io.repository.LoanRepository;
import com.cognizant.mc.bankappws.io.repository.UserRepository;
import com.cognizant.mc.bankappws.service.UserService;
import com.cognizant.mc.bankappws.ui.modelresp.ErrorMessages;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LoanRepository loanRepository;

	@Autowired
	Accessor accessor;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto userDto) throws Exception {
		
		if(userRepository.findByEmail(userDto.getEmail()) != null){
			throw new UserServiceException(ErrorMessages.RECORD_ALREADY_EXISTS.getErrorMessage());
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

	@Override
	public UserDto getUserById(String id) {
		UserDto dto = new UserDto();
		UserEntity entity = userRepository.findByPublicUserId(id);
		if(entity == null) throw new UsernameNotFoundException("User "+id+" Not Found");
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public UserDto updateUser(String id, UserDto userDto) {
		UserDto dto = new UserDto();
		
		UserEntity entity = userRepository.findByPublicUserId(id);
		if(entity == null) throw new UsernameNotFoundException("User "+id+" Not Found");
		
		entity.setAccountType(userDto.getAccountType());
		entity.setAddress(userDto.getAddress());
		entity.setUserName(userDto.getUserName());
		entity.setContactNo(userDto.getContactNo());
		entity.setCountry(userDto.getCountry());
		entity.setDob(userDto.getDob());
		entity.setName(userDto.getName());
		entity.setPan(userDto.getPan());
		entity.setState(userDto.getState());
		
		UserEntity userEntity = userRepository.save(entity);
		BeanUtils.copyProperties(userEntity, dto);
		return dto;
	}

	@Override
	public void deleteUser(String userId) {
		UserEntity userEntity = userRepository.findByPublicUserId(userId);

		if (userEntity == null)
			throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		userRepository.delete(userEntity);

	}

	@Override
	public LoanDto applyLoan(LoanDto dto, String id) throws Exception {
		
		
		if(userRepository.findByPublicUserId(id) == null) {
			throw new UserServiceException(ErrorMessages.INVALID_USER_TO_APPLY_LOAN.getErrorMessage());
		}
		
//		if((loanRepository.findByLoanType(dto.getLoanType()) != null) && (dto.getLoanIdentity() != id)){
//			throw new UserServiceException(ErrorMessages.LOAN_ALREADY_EXISTS.getErrorMessage());
//		}
		
		LoanEntity loanEntity = new LoanEntity();
		BeanUtils.copyProperties(dto, loanEntity);
		
		
		loanEntity.setLoanRefId(accessor.generateRandomString(10));
		loanEntity.setLoanIdentity(id);
		//userEntity.setPublicUserId("TestID");
		
		LoanEntity appliedLoan = loanRepository.save(loanEntity);
		
		LoanDto dto1 = new LoanDto();
		BeanUtils.copyProperties(loanEntity, dto1);			
		
		return dto1;
	}

	@Override
	public List<LoanDto> getLoanById(String userId) {
		List<LoanDto> dto =  new ArrayList<LoanDto>();
		
		List<LoanEntity> entity = loanRepository.findAllByLoanIdentity(userId);
	
		if(entity == null) throw new UserServiceException("User "+userId+" doesn't have any loans Found");
		
		for (LoanEntity loanEntity : entity) {
			LoanDto loanDto = new LoanDto();
			BeanUtils.copyProperties(loanEntity, loanDto);
			dto.add(loanDto);
		}
		//dto.add(entity);
		return dto;
	}
	
		

}
