package com.cognizant.mc.bankappws.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class LoanDto {
	
	private String loanRefId;
	private long loanId;
	private String loanType;
	private float loanAmount;
	private String date;
	private String rateOfInterest;
	private String durationOfLoan;
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
