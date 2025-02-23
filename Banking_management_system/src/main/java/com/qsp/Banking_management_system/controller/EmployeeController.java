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

import com.qsp.Banking_management_system.dto.Employee;
import com.qsp.Banking_management_system.service.EmployeeService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@Operation(summary = "Save Employee", description = "API is used to save the employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved") })
	@PostMapping("/saveEmployee")
	public Responsestructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	@Operation(summary = "Fetch Employee by id", description = "API is used to Fetch the employee by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "employee Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "employee Not found For the given id")})
	@GetMapping("/fetchEmployee")
	public Responsestructure<Employee> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}
	@Operation(summary = "Fetch all Employees", description = "API is used to Fetch All the Employees")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Employees Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Employee is presented")})
	@GetMapping("/fetchAllEmployee")
	public ResponseStructureList<Employee> fetchAll(){
		return employeeService.fetchAll();
	}
	@Operation(summary = "Delete Employee by id", description = "API is used to delete the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employee Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Employee Not found For the given id")})
	@DeleteMapping("/deleteEmployee")
	public Responsestructure<Employee> deleteEmployeeById(@RequestParam int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}
	@Operation(summary = "Update Employee by id", description = "API is used to update the Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employee Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Employee not found For the given id")})
	@PutMapping("/updateEmployee")
	public Responsestructure<Employee> updateEmployeeById(@RequestParam int oldEmployeeId,@RequestBody Employee newEmployee) {
		return employeeService.updateEmployeeById(oldEmployeeId, newEmployee);
	}
}
