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

import com.qsp.Banking_management_system.dto.Address;
import com.qsp.Banking_management_system.service.AddressService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	@Operation(summary = "Save Address", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveAddress")
	public Responsestructure<Address> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	@Operation(summary = "Fetch Address by id", description = "API is used to Fetch the Address by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Addresss Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "Address Not found For the given id")})
	@GetMapping("/fetchAddress By Id")
	public Responsestructure<Address> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}
	@Operation(summary = "Fetch all Addresses", description = "API is used to Fetch All the Addresses")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Addresses Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Address is presented")})
	@GetMapping("/fetchAllAddress")
	public ResponseStructureList<Address> fetchAll(){
		return addressService.fetchAll();
	}
	@Operation(summary = "Delete Address by id", description = "API is used to delete the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Address Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Address Not found For the given id")})
	@DeleteMapping("/deleteAddress")
	public Responsestructure<Address> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}
	@Operation(summary = "Update Address by id", description = "API is used to update the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Address Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Address not found For the given id")})
	@PutMapping("/updateAddress")
	public Responsestructure<Address> updateAddressById(@RequestParam int oldAddressId,@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
}
