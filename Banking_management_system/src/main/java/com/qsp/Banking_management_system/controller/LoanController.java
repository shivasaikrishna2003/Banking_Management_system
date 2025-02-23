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

import com.qsp.Banking_management_system.dto.Loan;
import com.qsp.Banking_management_system.service.LoanService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class LoanController {

	@Autowired
	LoanService loanService;
	@Operation(summary = "Save Loan", description = "API is used to save the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveLoan")
	public Responsestructure<Loan> saveLoan(@RequestBody Loan loan) {
		return loanService.saveLoan(loan);
	}
	@Operation(summary = "Fetch Loan by id", description = "API is used to Fetch the Loan by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Loan Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "Loan Not found For the given id")})
	@GetMapping("/fetchLoan")
	public Responsestructure<Loan> fetchLoanById(@RequestParam int loanId) {
		return loanService.fetchLoanById(loanId);
	}
	@Operation(summary = "Fetch all Loans", description = "API is used to Fetch All the Loans")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Loans Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Loan is presented")})
	@GetMapping("/fetchAllLoan")
	public ResponseStructureList<Loan> fetchAll() {
		return loanService.fetchAll();
	}
	@Operation(summary = "Delete Loan by id", description = "API is used to delete the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Loan Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Loan Not found For the given id")})
	@DeleteMapping("/deleteLoan")
	public Responsestructure<Loan> deleteLoanById(int loanId) {
		return loanService.deleteLoanById(loanId);
	}
	@Operation(summary = "Update Loan by id", description = "API is used to update the Loan")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Loan Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Loan not found For the given id")})
	@PutMapping("/updateLoan")
	public Responsestructure<Loan> updateLoanById(@RequestParam int oldLoanId,@RequestBody Loan newLoan) {
		return loanService.updateLoanById(oldLoanId, newLoan);
	}
}
