package com.cognizant.mc.bankappws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="loans")
public class LoanEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
	private String loanRefId;
	
	@Id
	@GeneratedValue
	private long loanId;
	
	@Column(nullable=false)
	private String loanType;
	
	@Column(nullable=false)
	private float loanAmount;
	
	@Column(nullable=false)
	private String date;
	
	@Column(nullable=false)
	private String rateOfInterest;
	
	@Column(nullable=false)
	private String durationOfLoan;
	
	@Column(nullable=false)
	private String loanIdentity;

	public String getLoanIdentity() {
		return loanIdentity;
	}

	public void setLoanIdentity(String loanIdentity) {
		this.loanIdentity = loanIdentity;
	}

	public String getLoanRefId() {
		return loanRefId;
	}

	public void setLoanRefId(String loanRefId) {
		this.loanRefId = loanRefId;
	}

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public float getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getDurationOfLoan() {
		return durationOfLoan;
	}

	public void setDurationOfLoan(String durationOfLoan) {
		this.durationOfLoan = durationOfLoan;
	}
	
	

}
