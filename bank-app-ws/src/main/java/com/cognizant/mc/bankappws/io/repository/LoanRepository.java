package com.cognizant.mc.bankappws.io.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.mc.bankappws.io.entity.LoanEntity;
import com.cognizant.mc.bankappws.io.entity.UserEntity;

@Repository
public interface LoanRepository extends CrudRepository<LoanEntity, Long> {

	LoanEntity findByLoanType(String loanId);

	List<LoanEntity> findAllByLoanIdentity(String loanId);
	
	

}
