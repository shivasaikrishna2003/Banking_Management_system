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

import com.qsp.Banking_management_system.dto.Branch;
import com.qsp.Banking_management_system.dto.Customer;
import com.qsp.Banking_management_system.dto.Employee;
import com.qsp.Banking_management_system.service.BranchService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	@Operation(summary = "Save Branch", description = "API is used to save the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveBranch")
	public Responsestructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);		
	}
	@Operation(summary = "Fetch Branch by id", description = "API is used to Fetch the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Branch Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "Branch Not found For the given id")})
	@GetMapping("/fetchBranch")
	public Responsestructure<Branch> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}
	@Operation(summary = "Fetch all Branch's", description = "API is used to Fetch All the branch's")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Branch's Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Branch is presented")})
	@GetMapping("/fetchAllBranch")
	public ResponseStructureList<Branch> fetchAll(){
		return branchService.fetchAll();
	}
	@Operation(summary = "Delete Branch by id", description = "API is used to delete the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Branch Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Branch Not found For the given id")})
	@DeleteMapping("/deleteBranch")
	public Responsestructure<Branch> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}
	@Operation(summary = "Update Branch by id", description = "API is used to update the branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Branch Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Branch not found For the given id")})
	@PutMapping("/updateBranch")
	public Responsestructure<Branch> updateBranchById(@RequestParam int oldBranchId,@RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}
	@Operation(summary = "add Existing manager to Existing branch", description = "API is used to update the branch add existing manager to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "manager  Succesfully addded to Existing Branch "),
			@ApiResponse(responseCode ="404",description = "branch not found For the given id")})
	@PutMapping("/addExistingManagerToExistingBranch")
	public Branch addExistingManagerToExistingBranch(@RequestParam int branchId,@RequestParam int managerId) {
		return branchService.addExistingManagerToExistingBranch(branchId, managerId);
	}
	@Operation(summary = "add Existing address to Existing branch", description = "API is used to update the branch add existing address to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "addresss  Succesfully addded to Existing Branch "),
			@ApiResponse(responseCode ="404",description = "branch not found For the given id")})
	@PutMapping("/addExistingAddressToExistingBranch")
	public Branch addExistingAddressToExistingBranch(@RequestParam int branchId,@RequestParam int addressId) {
		return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}
	@Operation(summary = "add Existing employee to Existing branch", description = "API is used to update the branch add existing employee to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "employee  Succesfully addded to Existing Branch "),
			@ApiResponse(responseCode ="404",description = "branch not found For the given id")})
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
		return branchService.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	@Operation(summary = "add new employee to Existing branch", description = "API is used to update the branch add new employee to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "employee  Succesfully addded to Existing Branch "),
			@ApiResponse(responseCode ="404",description = "branch not found For the given id")})
	@PutMapping("/addNewEmployeeToExistingBranch")
	public Branch addNewEmployeeToExistingBranch(@RequestParam int branchId,@RequestBody Employee newEmployee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}
	@Operation(summary = "add Existing customer to Existing branch", description = "API is used to update the branch add existing customer to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "customer  Succesfully addded to Existing Branch "),
			@ApiResponse(responseCode ="404",description = "branch not found For the given id")})
	@PutMapping("/addExistingCustomerToExistingBranch")
	public Branch addExistingCustomerToExistingBranch(@RequestParam int branchId,@RequestParam int customerId) {
		return branchService.addExistingCustomerToExistingBranch(branchId, customerId);
	}
	@Operation(summary = "add new customer to Existing branch", description = "API is used to update the branch add new customer to existing branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "customer Succesfully addded to Existing Branch "),
			@ApiResponse(responseCode ="404",description = "branch not found For the given id")})
	@PutMapping("/addNewCustomerToExistingBranch")
	public Branch addNewCustomerToExistingBranch(@RequestParam int branchId,@RequestBody Customer newCustomer) {
		return branchService.addNewCustomerToExistingBranch(branchId, newCustomer);
	}
	
	
}
