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
import com.qsp.Banking_management_system.dto.Card;
import com.qsp.Banking_management_system.dto.Customer;
import com.qsp.Banking_management_system.dto.Fd;
import com.qsp.Banking_management_system.dto.Loan;
import com.qsp.Banking_management_system.service.CustomerService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Operation(summary = "Save Customer", description = "API is used to save the customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveCustomer")
	public Responsestructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@Operation(summary = "Fetch Customer by id", description = "API is used to Fetch the customer by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "customer Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "customer Not found For the given id")})
	@GetMapping("/fetchCustomer")
	public Responsestructure<Customer> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}
	@Operation(summary = "Fetch all Cutomers", description = "API is used to Fetch All the Customers")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Customers Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Customer is presented")})
	@GetMapping("/fetchAllCustomer")
	public ResponseStructureList<Customer> fecthAll(){
		return customerService.fecthAll();
	}
	@Operation(summary = "Delete Customer by id", description = "API is used to delete the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Customer Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Customer Not found For the given id")})
	@DeleteMapping("/deleteCustomer")
	public Responsestructure<Customer> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}
	@Operation(summary = "Update Customer by id", description = "API is used to update the Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Customer Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Customer not found For the given id")})
	@PutMapping("/updateCustomer")
	public Responsestructure<Customer> updateCustomerById(@RequestParam int oldCustomerId,@RequestBody Customer newCustomer) {
		return customerService.updateCustomerById(oldCustomerId, newCustomer);
	}
	@Operation(summary = "add Existing account to Existing customer", description = "API is used to update the customer add existing account to existing customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "account  Succesfully added to Existing customer "),
			@ApiResponse(responseCode ="404",description = "customer not found For the given id")})
	@PutMapping("/addExistingAccountToExistingCustomer")
	public Customer addExistingAccountToExistingCustomer( int customerId,int accountId) {
		return customerService.addExistingAccountToExistingCustomer(customerId, accountId);
	}
	@Operation(summary = "add new account to Existing customer", description = "API is used to update the customer add new account to existing customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "account  Succesfully added to Existing customer "),
			@ApiResponse(responseCode ="404",description = "customer not found For the given id")})
	@PutMapping("/addNewAccountToExistingCustomer")
	public Customer addNewAccountToExistingCustomer(@RequestParam int customerId,@RequestBody Account newAccount) {
		return customerService.addNewAccountToExistingCustomer(customerId, newAccount);
	}
	@Operation(summary = "add Existing card to Existing customer", description = "API is used to update the customer add existing card to existing customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "card  Succesfully added to Existing customer "),
			@ApiResponse(responseCode ="404",description = "customer not found For the given id")})
	@PutMapping("/addExistingCardToExistingCustomer")
	public Customer addExistingCardToExistingCustomer(int cardId,int customerId) {
		return customerService.addExistingCardToExistingCustomer(cardId, customerId);
	}
	@Operation(summary = "add new card to Existing customer", description = "API is used to update the customer add new card to existing customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "card Succesfully added to Existing customer "),
			@ApiResponse(responseCode ="404",description = "customer not found For the given id")})
	@PutMapping("/addNewCardToExistingCustomer")
	public Customer addNewCardToExistingCustomer(@RequestParam int customerId,@RequestBody Card newCard) {
		return customerService.addNewCardToExistingCustomer(customerId, newCard);
	}
	@Operation(summary = "add Existing loan to Existing customer", description = "API is used to update the customer add existing loan to existing customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "loan Succesfully added to Existing customer "),
			@ApiResponse(responseCode ="404",description = "customer not found For the given id")})
	@PutMapping("/addExistingLoanToExistingCustomer")
	public Customer addExistingLoanToExistingCustomer(int customerId,int loanId) {
		return customerService.addExistingLoanToExistingCustomer(customerId, loanId);
	}
	@Operation(summary = "add new loan to Existing customer", description = "API is used to update the customer add new loan to existing customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "loan  Succesfully added to Existing customer "),
			@ApiResponse(responseCode ="404",description = "customer not found For the given id")})
	@PutMapping("/addNewLoanToExistingCustomer")
	public Customer addNewLoanToExistingCustomer(@RequestParam int customerId,@RequestBody Loan newLoan) {
		return customerService.addNewLoanToExistingCustomer(customerId, newLoan);
	}
	@Operation(summary = "add Existing Fd to Existing customer", description = "API is used to update the customer add existing Fd to existing customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fd Succesfully added to Existing customer "),
			@ApiResponse(responseCode ="404",description = "customer not found For the given id")})
	@PutMapping("/addExistingFdToExistingCustomer")
	public Customer addExistingFdToExistingCustomer(int customerId,int fdId) {
		return customerService.addExistingFdToExistingCustomer(customerId, fdId);
	}
	@Operation(summary = "add new Fd to Existing customer", description = "API is used to update the customer add new Fd to existing customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fd  Succesfully added to Existing customer "),
			@ApiResponse(responseCode ="404",description = "customer not found For the given id")})
	@PutMapping("/addNewFdToExistingCustomer")
	public Customer addNewFdToExistingCustomer(@RequestParam int customerId,@RequestBody Fd newFd) {
		return customerService.addNewFdToExistingCustomer(customerId, newFd);
	}
}
