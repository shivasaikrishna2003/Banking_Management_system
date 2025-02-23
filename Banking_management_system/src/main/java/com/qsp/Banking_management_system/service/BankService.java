package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.BankDao;
import com.qsp.Banking_management_system.dto.Bank;
import com.qsp.Banking_management_system.dto.Branch;
import com.qsp.Banking_management_system.exception.AccountIdNotfound;
import com.qsp.Banking_management_system.exception.BankIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class BankService {

	@Autowired
	BankDao bankDao;
	@Autowired
	Responsestructure<Bank> responseStructure;
	@Autowired
	ResponseStructureList<Bank> responseStructureList;
	public Responsestructure<Bank> saveBank(Bank bank) {
		responseStructure.setMessage("Susccesfully bank inserted into DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
		return responseStructure;
	}
	public Responsestructure<Bank> fetchBankById(int bankId) {
	  Bank bank=bankDao.fetchBankById(bankId);
	  if(bank != null) {
		responseStructure.setMessage("Susccesfully bank fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(bankDao.fetchBankById(bankId));
		return responseStructure;
	}else {
		throw new BankIdNotFound();
	}
}
	public ResponseStructureList<Bank> fetchAll(){
		responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(bankDao.fetchAll());
		return responseStructureList;
	}
	public Responsestructure<Bank> deleteBankById(int bankId) {
		Bank bank=bankDao.fetchBankById(bankId);
		responseStructure.setMessage("Susccesfully bank deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.deleteBankById(bankId));
		return responseStructure;
		
		
	}
	public Responsestructure<Bank> updateBankById(int oldBankId,Bank newBank) {
		responseStructure.setMessage("Susccesfully bank updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.updateBankById(oldBankId, newBank));
		return responseStructure;
	}
    public Bank addExistingBranchToAddExistingBank(int bankId,int branchId) {
        return bankDao.addExistingBranchToAddExistingBank(bankId, branchId);
    }
    public Bank addNewBranchToExistingBank(int bankId,Branch newBranch) {
          return bankDao.addNewBranchToExistingBank(bankId, newBranch);
    	
    }
}
