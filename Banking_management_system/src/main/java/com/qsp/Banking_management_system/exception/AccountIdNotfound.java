package com.qsp.Banking_management_system.exception;

public class AccountIdNotfound extends RuntimeException{

	private String message="Accocunt Id not Found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}
