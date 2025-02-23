package com.qsp.Banking_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_management_system.dto.Fd;
import com.qsp.Banking_management_system.service.FdService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FdController {

	@Autowired
	FdService fdService;
	@Operation(summary = "Save Fd", description = "API is used to save the fd")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created") })
	@PostMapping("/saveFd")
	public Responsestructure<Fd> savefd(@RequestBody Fd fd) {
		return fdService.savefd(fd);
	}
	@Operation(summary = "Fetch Fd by id", description = "API is used to Fetch the Fd by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Fd Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "fd Not found For the given id")})
	@GetMapping("/fetchFd")
	public Responsestructure<Fd> fetchFdById(@RequestParam int fdId) {
		return fdService.fetchFdById(fdId);
	}
	@Operation(summary = "Fetch all Fds", description = "API is used to Fetch All the Fds")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Fds Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Fd is presented")})
	@GetMapping("/fetchAllFd")
	public ResponseStructureList<Fd> fetchAll(){
		return fdService.fetchAll();
	}
	@Operation(summary = "Delete Fd by id", description = "API is used to delete the Fd")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fd Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Fd Not found For the given id")})
	@DeleteMapping("/deleteFd")
	public Responsestructure<Fd> deleteFdById(@RequestParam int fdId) {
		return fdService.deleteFdById(fdId);
	}
	@Operation(summary = "Update Fd by id", description = "API is used to update the Fd")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Fd Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Fd not found For the given id")})
	@PutMapping("/updateFd")
	public Responsestructure<Fd> updateFdById(@RequestParam int oldFdId,@RequestBody Fd newFd) {
		return fdService.updateFdById(oldFdId, newFd);
	}
}
