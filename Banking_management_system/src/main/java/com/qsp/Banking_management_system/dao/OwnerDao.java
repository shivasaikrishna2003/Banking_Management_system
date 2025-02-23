package com.qsp.Banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_management_system.dto.Bank;
import com.qsp.Banking_management_system.dto.Owner;
import com.qsp.Banking_management_system.repo.BankRepo;
import com.qsp.Banking_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;
	@Autowired
	BankDao bankDao;
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner= ownerRepo.findById(ownerId);
		if(owner.isPresent()) {
			return owner.get();
		}else {
			return null;
		}
	}
	public List<Owner> fetchAll() {
		return ownerRepo.findAll();
	}
	public Owner deleteById(int ownerId) {
	Owner owner=ownerRepo.findById(ownerId).get();
	ownerRepo.delete(owner);
	return owner;
	}
	public Owner updateOwnerById(int oldOwnerId,Owner newOwner) {
		newOwner.setOwnerId(oldOwnerId);
		return ownerRepo.save(newOwner);
	}
	public Owner addExistingBankToExistingOwner(int bankId,int ownerId) {
		Owner owner=fetchOwnerById(ownerId);
		Bank bank=bankDao.fetchBankById(bankId);
		owner.setBank(bank);
		return saveOwner(owner);
    }
	
}
