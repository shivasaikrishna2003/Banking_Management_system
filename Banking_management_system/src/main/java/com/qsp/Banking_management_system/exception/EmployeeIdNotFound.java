package com.qsp.Banking_management_system.exception;

public class EmployeeIdNotFound extends RuntimeException{

	private String message="employee Id Not Found";

	public String getMessage() {
		return message;
	}
	
}
