package com.qsp.Banking_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_management_system.dto.Account;
import com.qsp.Banking_management_system.service.AccountService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	@Operation(summary = "Save Acccount", description = "API is used to save the account")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveAccount")
	public Responsestructure<Account> saveAccount(@RequestBody Account account) {
		return accountService.saveAnswer(account);
	}
	@Operation(summary = "Fetch Account by id", description = "API is used to Fetch the Acccount by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Account Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "Account Not found For the given id")})
	@GetMapping("/fetchAccount by Id")
	public Responsestructure<Account> fetchAccountById(@RequestParam int accountId) {
		return accountService.fetchAccountById(accountId);
	}
	@Operation(summary = "Fetch all Accounts", description = "API is used to Fetch All the Accounts")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Accounts Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Account is presented")})
	@GetMapping("/fetchAllAccount")
	public ResponseStructureList<Account> fetchAll() {
		return accountService.fetchAll();
	}
	@Operation(summary = "Delete Account by id", description = "API is used to delete the Account")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Account Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Account Not found For the given id")})
	@DeleteMapping("/deleteAccount")
	public Responsestructure<Account> deleteAccountById(@RequestParam int accountId) {
		return accountService.deleteAccountById(accountId);
	}
	@Operation(summary = "Update Account by id", description = "API is used to update the Account")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Account Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Account not found For the given id")})
	@PutMapping("/updateAccount")
	public Responsestructure<Account> updateAccountById(@RequestParam int oldAccountId,@RequestBody Account newAccount) {
		return accountService.updateAccountById(oldAccountId, newAccount);
	}
}
