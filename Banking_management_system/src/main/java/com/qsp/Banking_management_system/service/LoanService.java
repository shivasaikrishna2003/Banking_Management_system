package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.LoanDao;
import com.qsp.Banking_management_system.dto.Loan;
import com.qsp.Banking_management_system.exception.LoanIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class LoanService {

	@Autowired
	LoanDao loanDao;
	@Autowired
	Responsestructure<Loan > responsestructure;
	@Autowired
	ResponseStructureList<Loan> responseStructureList;
	public Responsestructure<Loan> saveLoan(Loan loan) {
		 responsestructure.setMessage("Susccesfully bank inserted into DB");
		 responsestructure.setStatusCode(HttpStatus.CREATED.value());
		 responsestructure.setData(loanDao.saveLoan(loan));
		return responsestructure;
	}
	public Responsestructure<Loan> fetchLoanById(int loanId) {
		Loan loan=loanDao.fetchLoanById(loanId);
		if(loan!=null) {
		responsestructure.setMessage("Susccesfully bank fetched from DB");
		 responsestructure.setStatusCode(HttpStatus.FOUND.value());
		 responsestructure.setData(loanDao.fetchLoanById(loanId));
		return responsestructure;
	}else {
		throw new LoanIdNotFound();
	}
		}
	public ResponseStructureList<Loan> fetchAll() {
		responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		 responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		 responseStructureList.setData(loanDao.fetchAll());
		return responseStructureList;
	}
	public Responsestructure<Loan> deleteLoanById(int loanId) {
		responsestructure.setMessage("Susccesfully bank deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(loanDao.deleteLoanById(loanId));
		return responsestructure;
	}
	public Responsestructure<Loan> updateLoanById(int oldLoanId,Loan newLoan) {
		responsestructure.setMessage("Susccesfully bank updated in DB");
		 responsestructure.setStatusCode(HttpStatus.OK.value());
		 responsestructure.setData(loanDao.updateLoanById(oldLoanId, newLoan));
		return responsestructure;
	}
}
