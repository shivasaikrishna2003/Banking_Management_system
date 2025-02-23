package com.qsp.Banking_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Banking_management_system.dto.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer>{

}
