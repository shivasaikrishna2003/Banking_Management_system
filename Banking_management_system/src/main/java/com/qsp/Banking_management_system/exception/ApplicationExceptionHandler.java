package com.qsp.Banking_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.Banking_management_system.util.Responsestructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	Responsestructure<String> responsestructure;
	@ExceptionHandler(BankIdNotFound.class)
	public Responsestructure<String> BankIdNotFound(BankIdNotFound bankIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not found");
		responsestructure.setData(bankIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(AccountIdNotfound.class)
	public Responsestructure<String> AccoundIdNotFound(AccountIdNotfound  accountIdNotfound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(accountIdNotfound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(AddressIdNotFound.class)
	public Responsestructure<String> AddressIdNotFound(AddressIdNotFound addressIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(addressIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public Responsestructure<String> BranchIdNotFound(BranchIdNotFound branchIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(branchIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(CardIdNotFound.class)
	public Responsestructure<String> CardIdNotFound(CardIdNotFound cardIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(cardIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(CustomerIdNotFound.class)
	public Responsestructure<String> CustomerIdNotFound(CustomerIdNotFound customerIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(customerIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(EmployeeIdNotFound.class)
	public Responsestructure<String> EmployeeIdNotFound(EmployeeIdNotFound employeeIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(employeeIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(FdIdNotFound.class)
	public Responsestructure<String> FdIdNotFound(FdIdNotFound fdIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(fdIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(LoanIdNotFound.class)
	public Responsestructure<String> LoanIdNotFound(LoanIdNotFound loanIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(loanIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(ManagerIdNotFound.class)
	public Responsestructure<String> ManagerIdNotFound(ManagerIdNotFound managerIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(managerIdNotFound.getMessage());
		return responsestructure;
	}
	@ExceptionHandler(OwnerIdNotFound.class)
	public Responsestructure<String> OwnerIdNotFound(OwnerIdNotFound ownerIdNotFound){
		responsestructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responsestructure.setMessage("Id not Found");
		responsestructure.setData(ownerIdNotFound.getMessage());
		return responsestructure;
	}
}
