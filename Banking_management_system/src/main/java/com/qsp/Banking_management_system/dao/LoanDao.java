package com.qsp.Banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_management_system.dto.Loan;
import com.qsp.Banking_management_system.repo.LoanRepo;

@Repository
public class LoanDao {

	@Autowired
	LoanRepo loanRepo;
	public Loan saveLoan(Loan loan) {
		return loanRepo.save(loan);
	}
	public Loan fetchLoanById(int loanId) {
		Optional<Loan> loan= loanRepo.findById(loanId);
		if(loan.isEmpty()) {
			return null;
		}else {
			return loan.get();
		}
	}
	public List<Loan> fetchAll() {
		return loanRepo.findAll();
	}
	public Loan deleteLoanById(int loanId) {
		Loan loan=loanRepo.findById(loanId).get();
		loanRepo.delete(loan);
		return loan;
	}
	public Loan updateLoanById(int oldLoanId,Loan newLoan) {
		newLoan.setLoanId(oldLoanId);
		return loanRepo.save(newLoan);
	}
}
