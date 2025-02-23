package com.qsp.Banking_management_system.exception;

public class CardIdNotFound extends RuntimeException{

	private String message="Card Id Not Found";

	public String getMessage() {
		return message;
	}
	
}
