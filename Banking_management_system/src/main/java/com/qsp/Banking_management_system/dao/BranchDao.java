package com.qsp.Banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_management_system.dto.Address;
import com.qsp.Banking_management_system.dto.Branch;
import com.qsp.Banking_management_system.dto.Customer;
import com.qsp.Banking_management_system.dto.Employee;
import com.qsp.Banking_management_system.dto.Manager;
import com.qsp.Banking_management_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	CustomerDao customerDao;
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	public Branch fetchBranchById(int branchId) {
		Optional<Branch> branch= branchRepo.findById(branchId);
		if(branch.isEmpty()) {
			return null;
		}else {
			return branch.get();
		}
	}
	public List<Branch> fetchAll() {
		return branchRepo.findAll();
	}
	public Branch deleteBranchById(int branchId) {
		Branch branch=branchRepo.findById(branchId).get();
		 branchRepo.delete(branch);
		 return branch;
	}
	public Branch updateBranchById(int oldBranchId,Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return branchRepo.save(newBranch);
	}
	public Branch addExistingManagerToExistingBranch(int branchId,int managerId) {
		
		Branch branch=fetchBranchById(branchId);
		Manager manager=managerDao.fetchManagerById(managerId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
   public Branch addExistingAddressToExistingBranch(int branchId,int addressId) {
		
		Branch branch=fetchBranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
   public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId) {
	   Branch branch=fetchBranchById(branchId);
	   Employee employee=employeeDao.fetchEmployeeById(employeeId);
	   List<Employee> list=branch.getEmployees();
	   list.add(employee);
	   branch.setEmployees(list);
	   return saveBranch(branch);
   }
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee newEmployee) {
		Branch branch=fetchBranchById(branchId);
		List<Employee> list=branch.getEmployees();
		list.add(newEmployee);
		branch.setEmployees(list);
		return saveBranch(branch);
	}
	public Branch addExistingCustomerToExistingBranch(int branchId,int customerId) {
		Branch branch=fetchBranchById(branchId);
		Customer customer=customerDao.fetchCustomerById(customerId);
		List<Customer> list=branch.getCustomers();
		list.add(customer);
		branch.setCustomers(list);
		return saveBranch(branch);
	}
	public Branch addNewCustomerToExistingBranch(int branchId,Customer newCustomer) {
		Branch branch=fetchBranchById(branchId);
		List<Customer> list=branch.getCustomers();
		list.add(newCustomer);
		branch.setCustomers(list);
		return saveBranch(branch);
	}
}
