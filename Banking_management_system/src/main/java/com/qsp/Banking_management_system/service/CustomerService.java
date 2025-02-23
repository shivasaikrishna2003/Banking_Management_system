package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.CustomerDao;
import com.qsp.Banking_management_system.dto.Account;
import com.qsp.Banking_management_system.dto.Card;
import com.qsp.Banking_management_system.dto.Customer;
import com.qsp.Banking_management_system.dto.Fd;
import com.qsp.Banking_management_system.dto.Loan;
import com.qsp.Banking_management_system.exception.CustomerIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class CustomerService {
	@Autowired 
	CustomerDao customerDao;
	@Autowired
	Responsestructure< Customer> responsestructure;
	@Autowired
	ResponseStructureList<Customer> responseStructureList;
	public Responsestructure<Customer> saveCustomer(Customer customer) {
		responsestructure.setMessage("Susccesfully bank inserted into DB");
		responsestructure.setStatusCode(HttpStatus.CREATED.value());
		responsestructure.setData(customerDao.saveCustomer(customer));
		return responsestructure;
	}

	public Responsestructure<Customer> fetchCustomerById(int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer !=null) {
		responsestructure.setMessage("Susccesfully bank fetched from DB");
		responsestructure.setStatusCode(HttpStatus.FOUND.value());
		responsestructure.setData(customerDao.fetchCustomerById(customerId));
		return responsestructure;
	}else {
		throw new CustomerIdNotFound();
	}
		}
	public ResponseStructureList<Customer> fecthAll(){
		responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(customerDao.fetchAll());
		return responseStructureList;
	}
	public Responsestructure<Customer> deleteCustomerById(int customerId) {
		responsestructure.setMessage("Susccesfully bank deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(customerDao.deleteCustomerById(customerId));
		return responsestructure;
	}
	public Responsestructure<Customer> updateCustomerById(int oldCustomerId,Customer newCustomer) {
		responsestructure.setMessage("Susccesfully bank updated in DB");
		 responsestructure.setStatusCode(HttpStatus.OK.value());
		 responsestructure.setData(customerDao.updateCustomerById(oldCustomerId, newCustomer));
		return responsestructure;
	}
	public Customer addExistingAccountToExistingCustomer(int customerId,int accountId) {
        return customerDao.addExistingAccountToExistingCustomer(customerId, accountId);
	}
	public Customer addNewAccountToExistingCustomer(int customerId,Account newAccount) {
		return customerDao.addNewAccountToExistingCustomer(customerId, newAccount);
	}
	public Customer addExistingCardToExistingCustomer(int cardId,int customerId) {
		return customerDao.addExistingCardToExistingCustomer(cardId, customerId);
	}
	public Customer addNewCardToExistingCustomer(int customerId,Card newCard) {
		return customerDao.addNewCardToExistingCustomer(customerId, newCard);
	}
	public Customer addExistingLoanToExistingCustomer(int customerId,int loanId) {
		return customerDao.addExistingLoanToExistingCustomer(customerId, loanId);
	}
	public Customer addNewLoanToExistingCustomer(int customerId,Loan newLoan) {
		return customerDao.addNewLoanToExistingCustomer(customerId, newLoan);
	}
	public Customer addExistingFdToExistingCustomer(int customerId,int fdId) {
		return customerDao.addExistingFdToExistingCustomer(customerId, fdId);
	}
	public Customer addNewFdToExistingCustomer(int customerId,Fd newFd) {
		return customerDao.addNewFdToExistingCustomer(customerId, newFd);

	}
}
