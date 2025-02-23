package com.qsp.Banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_management_system.dto.Employee;
import com.qsp.Banking_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	public Employee fetchEmployeeById(int employeeId) {
		Optional<Employee> employee= employeeRepo.findById(employeeId);
		if(employee.isEmpty()) {
			return null;
		}else {
			return employee.get();
		}
	}
	public List<Employee> fetchAll(){
		return employeeRepo.findAll();
	}
	public Employee deleteEmployeeById(int employeeId) {
		Employee employee=employeeRepo.findById(employeeId).get();
		employeeRepo.delete(employee);
		return employee;
	}
	public Employee updateEmployeeById(int oldEmployeeId,Employee newEmployee) {
		newEmployee.setEmployeeId(oldEmployeeId);
		return employeeRepo.save(newEmployee);
	}
}
