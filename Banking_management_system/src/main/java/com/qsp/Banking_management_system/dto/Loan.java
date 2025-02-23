package com.qsp.Banking_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int loanId;
	private String loanType;
	private double loanAmount;
	private int loantenure;
	private double loanInterest;
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getLoantenure() {
		return loantenure;
	}
	public void setLoantenure(int loantenure) {
		this.loantenure = loantenure;
	}
	public double getLoanInterest() {
		return loanInterest;
	}
	public void setLoanInterest(double loanInterest) {
		this.loanInterest = loanInterest;
	}
	
}

