package com.qsp.Banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_management_system.dto.Account;
import com.qsp.Banking_management_system.dto.Bank;
import com.qsp.Banking_management_system.repo.AccountRepo;

@Repository
public class AccountDao {

	@Autowired 
	AccountRepo accountRepo;
	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}
	public Account fetchAccountById(int accountId) {
		Optional<Account> account=accountRepo.findById(accountId);
		if(account.isPresent()) {
			return account.get();
		}
		else {
			return null;
		}
		
	}
	public List<Account> fetchAll() {
		return accountRepo.findAll();
	}
	public Account deleteAccountById(int accountId) {
		Account account=accountRepo.findById(accountId).get();
		accountRepo.delete(account);
		return account;
	}
	public Account updateAccountById(int oldAccountId,Account newAccount) {
		newAccount.setAccountId(oldAccountId);
		return accountRepo.save(newAccount);
	}
}

