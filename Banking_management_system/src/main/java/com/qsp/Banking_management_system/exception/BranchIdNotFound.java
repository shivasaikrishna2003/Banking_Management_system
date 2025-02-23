package com.qsp.Banking_management_system.exception;

public class BranchIdNotFound extends RuntimeException {

	private String message="Branch Id not Found";

	public String getMessage() {
		return message;
	}
	
}
