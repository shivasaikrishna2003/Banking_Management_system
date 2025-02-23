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

import com.qsp.Banking_management_system.dto.Manager;
import com.qsp.Banking_management_system.service.managerService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ManagerController {

	@Autowired
	managerService managerService;
	@Operation(summary = "Save Manager", description = "API is used to save the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveManager")
	public Responsestructure<Manager> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
	@Operation(summary = "Fetch Manager by id", description = "API is used to Fetch the Manager by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Manager Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "Manager Not found For the given id")})
	@GetMapping("/fetchManager")
	public Responsestructure<Manager> fetchManagerById(@RequestParam int managerId) {
		return managerService.fetchManagerById(managerId);
	}
	@Operation(summary = "Fetch all Managers", description = "API is used to Fetch All the Managers")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Managers Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Manager is presented")})
	@GetMapping("/fetchAllManager")
	public ResponseStructureList<Manager> fetchAll(){
		return managerService.fetchAll();
	}
	@Operation(summary = "Delete Manager by id", description = "API is used to delete the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Manager Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Manager Not found For the given id")})
	@DeleteMapping("/deleteManager")
	public Responsestructure<Manager> deleteManagerById(@RequestParam int managerId) {
		return managerService.deleteManagerById(managerId);
	}
	@Operation(summary = "Update Manager by id", description = "API is used to update the Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Manager Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Manager not found For the given id")})
	@PutMapping("/updateManager")
	public Responsestructure<Manager> updateManagerById(@RequestParam int oldManagerId,@RequestBody Manager newManager) {
		return managerService.updateManagerById(oldManagerId, newManager);
	}
}
