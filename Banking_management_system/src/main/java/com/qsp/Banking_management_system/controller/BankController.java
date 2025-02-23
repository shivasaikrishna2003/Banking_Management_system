package com.qsp.Banking_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_management_system.dto.Bank;
import com.qsp.Banking_management_system.dto.Branch;
import com.qsp.Banking_management_system.service.BankService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BankController {

	@Autowired
	BankService bankService;
	
	@Operation(summary = "Save Bank", description = "API is used to save the bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveBank")
	public Responsestructure<Bank> saveBank(@RequestBody  Bank bank) {
		return bankService.saveBank(bank);
	}
	@Operation(summary = "Fetch Bank by id", description = "API is used to Fetch the bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Bank Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "Bank Not found For the given id")})
	@GetMapping("/Fetch bank By Id")
	public Responsestructure<Bank> fetchBankById(@RequestParam int bankId) {
		return bankService.fetchBankById(bankId);
	}
	@Operation(summary = "Fetch all Banks", description = "API is used to Fetch All the bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Banks Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Bank is presented")})
	@GetMapping("/fetchAllBank")
	public ResponseStructureList<Bank> fetchAll(){
		return bankService.fetchAll();
	}
	@Operation(summary = "Delete Bank by id", description = "API is used to delete the bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Bank Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Bank Not found For the given id")})
	@DeleteMapping("/deleteBank")
	public Responsestructure<Bank> deleteBankById(@RequestParam int bankId) {
		return bankService.deleteBankById(bankId);
	}
	@Operation(summary = "Update Bank by id", description = "API is used to update the bank")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Bank Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Bank not found For the given id")})
	@PutMapping("/updateBank")
	public Responsestructure<Bank> updateBankById(@RequestParam int oldBankId,@RequestBody Bank newbBank) {
		return bankService.updateBankById(oldBankId, newbBank);
	}
	@Operation(summary = "add Existing branch to Existing bank", description = "API is used to update the bank add existing branch to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Branch  Succesfully addded to Existing Bank "),
			@ApiResponse(responseCode ="404",description = "Bank not found For the given id")})
	@PutMapping("/addExistingBranchToAddExistingBank")
    public Bank addExistingBranchToAddExistingBank(int bankId,int branchId) {
         return bankService.addExistingBranchToAddExistingBank(bankId, branchId);
    }
	@Operation(summary = "add new branch to Existing bank", description = "API is used to update the bank add new branch to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Branch  Succesfully addded to Existing Bank "),
			@ApiResponse(responseCode ="404",description = "Bank not found For the given id")})
	@PutMapping("/addNewBranchToExistingBank")
    public Bank addNewBranchToExistingBank(@RequestParam int bankId,@RequestBody Branch newBranch) {
    	return bankService.addNewBranchToExistingBank(bankId, newBranch);
    }
}
