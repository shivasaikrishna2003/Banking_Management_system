package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.AccountDao;
import com.qsp.Banking_management_system.dto.Account;
import com.qsp.Banking_management_system.exception.AccountIdNotfound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	Responsestructure<Account> responseStructure;
	@Autowired
	ResponseStructureList<Account> responseStructureList;
	public Responsestructure<Account> saveAnswer(Account account) {
		responseStructure.setMessage("Susccesfully account inserted into DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(accountDao.saveAccount(account));
		return responseStructure ;
	}
	public Responsestructure<Account> fetchAccountById(int accountId) {
		Account account=accountDao.fetchAccountById(accountId);
		if(account!=null) {
		responseStructure.setMessage("Susccesfully account fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(accountDao.fetchAccountById(accountId));
		return responseStructure;
	}else {
		throw new AccountIdNotfound();
	}
	}
	public ResponseStructureList<Account> fetchAll() {
		responseStructureList.setMessage("Succesfully All accounts are fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(accountDao.fetchAll());
		return responseStructureList;
	}
	public Responsestructure<Account> deleteAccountById(int accountId) {
		responseStructure.setMessage("Susccesfully account deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(accountDao.deleteAccountById(accountId));
		return responseStructure;
	}
	public Responsestructure<Account> updateAccountById(int oldAccountId,Account newAccount) {
		responseStructure.setMessage("Susccesfully account updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(accountDao.updateAccountById(oldAccountId, newAccount));
		return responseStructure;
	}
}
