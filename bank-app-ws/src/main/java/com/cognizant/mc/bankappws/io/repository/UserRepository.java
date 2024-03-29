package com.cognizant.mc.bankappws.io.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.mc.bankappws.io.entity.LoanEntity;
import com.cognizant.mc.bankappws.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email);

	UserEntity findByPublicUserId(String id);

	

}
