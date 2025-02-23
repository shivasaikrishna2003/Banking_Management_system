package com.qsp.Banking_management_system.exception;

public class ManagerIdNotFound extends RuntimeException{
	private String message="manager Id Not Found";

	public String getMessage() {
		return message;
	}
	

}
