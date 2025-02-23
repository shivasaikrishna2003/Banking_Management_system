package com.qsp.Banking_management_system.exception;

public class FdIdNotFound extends RuntimeException{

	private String message="Fd id not found";

	public String getMessage() {
		return message;
	}
	
}
