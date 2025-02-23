package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.EmployeeDao;
import com.qsp.Banking_management_system.dto.Employee;
import com.qsp.Banking_management_system.exception.EmployeeIdNotFound;
import com.qsp.Banking_management_system.repo.EmployeeRepo;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class EmployeeService {
 
	 @Autowired
	 EmployeeDao employeeDao;
	 @Autowired
	 Responsestructure<Employee> responsestructure;
	 @Autowired
	 ResponseStructureList<Employee> responseStructureList;
	 public Responsestructure<Employee> saveEmployee(Employee employee) {
		 responsestructure.setMessage("Susccesfully bank inserted into DB");
			responsestructure.setStatusCode(HttpStatus.CREATED.value());
			responsestructure.setData(employeeDao.saveEmployee(employee));
		 return responsestructure;
	 }
	 public Responsestructure<Employee> fetchEmployeeById(int employeeId) {
		 Employee employee=employeeDao.fetchEmployeeById(employeeId);
		 if(employee !=null) {
		 responsestructure.setMessage("Susccesfully bank fetched from DB");
		 responsestructure.setStatusCode(HttpStatus.FOUND.value());
		 responsestructure.setData(employeeDao.fetchEmployeeById(employeeId));
		 return responsestructure;
	 }else {
		 throw new EmployeeIdNotFound();
	 }
		 }
	 public ResponseStructureList<Employee> fetchAll(){
		 responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		 responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		 responseStructureList.setData(employeeDao.fetchAll());
		 return responseStructureList;
	 }
	 public Responsestructure<Employee> deleteEmployeeById(int employeeId) {
		responsestructure.setMessage("Susccesfully bank deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(employeeDao.deleteEmployeeById(employeeId));
		 return responsestructure;
	 }
	 public Responsestructure<Employee> updateEmployeeById(int oldEmployeeId,Employee newEmployee) {
		 responsestructure.setMessage("Susccesfully bank updated in DB");
		 responsestructure.setStatusCode(HttpStatus.OK.value());
		 responsestructure.setData(employeeDao.updateEmployeeById(oldEmployeeId, newEmployee));
		 return responsestructure;
	 }
}
