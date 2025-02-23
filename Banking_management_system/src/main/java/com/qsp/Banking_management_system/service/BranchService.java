package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.BranchDao;
import com.qsp.Banking_management_system.dto.Branch;
import com.qsp.Banking_management_system.dto.Customer;
import com.qsp.Banking_management_system.dto.Employee;
import com.qsp.Banking_management_system.exception.BranchIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	Responsestructure<Branch> responsestructure;
	@Autowired
	ResponseStructureList< Branch> responseStructureList;
	public Responsestructure<Branch> saveBranch(Branch branch) {
		responsestructure.setMessage("Susccesfully bank inserted into DB");
		responsestructure.setStatusCode(HttpStatus.CREATED.value());
		responsestructure.setData(branchDao.saveBranch(branch));
		return responsestructure;
	}
	public Responsestructure<Branch> fetchBranchById(int branchId) {
		Branch branch=branchDao.fetchBranchById(branchId);
		if(branch != null) {
		responsestructure.setMessage("Susccesfully bank fetched from DB");
		responsestructure.setStatusCode(HttpStatus.FOUND.value());
		responsestructure.setData(branchDao.fetchBranchById(branchId));
		return responsestructure;
	}
		else {
			throw new BranchIdNotFound();
		}
	}
    public ResponseStructureList<Branch> fetchAll(){
    	responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(branchDao.fetchAll());
    	return responseStructureList;
    }
    public Responsestructure<Branch> deleteBranchById(int branchId) {
    	responsestructure.setMessage("Susccesfully bank deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(branchDao.deleteBranchById(branchId));
    	return responsestructure;
    }
    public Responsestructure<Branch> updateBranchById(int oldBranchId,Branch newBranch) {
    	responsestructure.setMessage("Susccesfully bank updated in DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
    	return responsestructure;
    }
	public Branch addExistingManagerToExistingBranch(int branchId,int managerId) {
		return branchDao.addExistingManagerToExistingBranch(branchId, managerId);
	}
	public Branch addExistingAddressToExistingBranch(int branchId,int addressId) {
		return branchDao.addExistingAddressToExistingBranch(branchId, addressId);
	}
	public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
		return branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) {
            return branchDao.addNewEmployeeToExistingBranch(branchId, newEmployee);
	}
	public Branch addExistingCustomerToExistingBranch(int branchId,int customerId) {
        return branchDao.addExistingCustomerToExistingBranch(branchId, customerId);
	}
	public Branch addNewCustomerToExistingBranch(int branchId,Customer newCustomer) {
        return branchDao.addNewCustomerToExistingBranch(branchId, newCustomer);
	}
}
