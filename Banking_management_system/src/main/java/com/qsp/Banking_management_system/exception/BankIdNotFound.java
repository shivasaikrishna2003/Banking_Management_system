package com.qsp.Banking_management_system.exception;

public class BankIdNotFound extends RuntimeException{

	private String message="Bank Id Not Found in the DB";

	public String getMessage() {
		return message;
	}
	
}
