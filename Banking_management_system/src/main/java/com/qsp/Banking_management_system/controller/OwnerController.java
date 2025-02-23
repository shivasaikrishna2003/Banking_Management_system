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

import com.qsp.Banking_management_system.dto.Owner;
import com.qsp.Banking_management_system.service.OwnerService;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveOwner")
	public Responsestructure<Owner> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	@Operation(summary = "Fetch Owner by id", description = "API is used to Fetch the Owner by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Owner Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "Owner Not found For the given id")})
	@GetMapping("/fetchOwner")
	public Responsestructure<Owner> fetchOwnerById(@RequestParam  int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}
	@Operation(summary = "Fetch all Owners", description = "API is used to Fetch All the Owners")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Owners Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Owner is presented")})
	@GetMapping("/fetchAllOwner")
	public Responsestructure<Owner> fetchAll(){
		return ownerService.fetchAll();
	}
	@Operation(summary = "Delete Owner by id", description = "API is used to delete the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Owner Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Owner Not found For the given id")})
	@DeleteMapping("/deleteOwner")
	public Responsestructure<Owner> deleteById(@RequestParam int ownerId) {
		return ownerService.deleteById(ownerId);
	}
	@Operation(summary = "Update Owner by id", description = "API is used to update the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Owner Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Owner not found For the given id")})
	@PutMapping("/updateOwner")
	public Responsestructure<Owner> updateOwnerById(@RequestParam int oldOwnerId,@RequestBody Owner newOwner) {
		return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}
	@Operation(summary = "add Existing bank to Existing Owner", description = "API is used to update the owner add Existing bank to existing owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "bank  Succesfully added to Existing owner "),
			@ApiResponse(responseCode ="404",description = "owner not found For the given id")})
	@PutMapping("/addExistingBankToExistingOwner")
	public Owner addExistingBankToExistingOwner(@RequestParam int bankId,@RequestParam  int ownerId) {
		return ownerService.addExistingBankToExistingOwner(bankId, ownerId);
	}
}
