package com.qsp.Banking_management_system.exception;

public class CustomerIdNotFound extends RuntimeException{

	private String message="Customer Id Not Found";

	public String getMessage() {
		return message;
	}
	
}
