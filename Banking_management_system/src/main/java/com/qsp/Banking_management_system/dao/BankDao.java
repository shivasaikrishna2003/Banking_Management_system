package com.qsp.Banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_management_system.dto.Bank;
import com.qsp.Banking_management_system.dto.Branch;
import com.qsp.Banking_management_system.repo.BankRepo;

@Repository
public class BankDao {
	@Autowired
	BankRepo bankRepo;
	@Autowired
	BranchDao branchDao;
	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}
    public Bank fetchBankById(int bankId) {
    	
    	Optional<Bank> bank= bankRepo.findById(bankId);
    	if(bank.isEmpty()) {
    		return null;
    	}
    	else {
    		return bank.get();
    	}
    }
    public List<Bank> fetchAll() {
    	return bankRepo.findAll();
    }
    public Bank deleteBankById(int bankId) {
       Bank bank=bankRepo.findById(bankId).get();
    	bankRepo.delete(bank);
    	return bank;
    }
    public Bank updateBankById(int oldBankId,Bank newBank) {
    	newBank.setBankId(oldBankId);
    	return bankRepo.save(newBank);
    }
    public Bank addExistingBranchToAddExistingBank(int bankId,int branchId) {
       Bank bank=fetchBankById(bankId);
       Branch branch=branchDao.fetchBranchById(branchId);
       List<Branch> list=bank.getBranchs();
       list.add(branch);
       bank.setBranchs(list);
       return saveBank(bank);
    }
    public Bank addNewBranchToExistingBank(int bankId,Branch newBranch) {
    	Bank bank=fetchBankById(bankId);
    	List<Branch> list=bank.getBranchs();
    	list.add(newBranch);
    	bank.setBranchs(list);
    	return saveBank(bank);
    	
    }
}
