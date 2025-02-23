package com.qsp.Banking_management_system.exception;

public class LoanIdNotFound extends RuntimeException{
 
	private String message="Loan Id not Found";

	public String getMessage() {
		return message;
	}
	
}
