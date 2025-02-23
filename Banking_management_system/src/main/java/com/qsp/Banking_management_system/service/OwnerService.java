package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.OwnerDao;
import com.qsp.Banking_management_system.dto.Owner;
import com.qsp.Banking_management_system.exception.OwnerIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;
	@Autowired
	Responsestructure<Owner> responsestructure;
	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	public Responsestructure<Owner> saveOwner(Owner owner) {
		responsestructure.setMessage("Susccesfully bank inserted into DB");
		 responsestructure.setStatusCode(HttpStatus.CREATED.value());
		 responsestructure.setData(ownerDao.saveOwner(owner));
		return responsestructure;
	}
	public Responsestructure<Owner> fetchOwnerById(int ownerId) {
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null) {
		responsestructure.setMessage("Susccesfully bank fetched from DB");
		 responsestructure.setStatusCode(HttpStatus.FOUND.value());
		 responsestructure.setData(ownerDao.fetchOwnerById(ownerId));
		return responsestructure;
	}else {
		throw new OwnerIdNotFound();
	}
		}
	public Responsestructure<Owner> fetchAll(){
		responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		 responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		 responseStructureList.setData(ownerDao.fetchAll());
		return responsestructure;
	}
	public Responsestructure<Owner> deleteById(int ownerId) {
		responsestructure.setMessage("Susccesfully bank deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData( ownerDao.deleteById(ownerId));
		return responsestructure;
	}
	public Responsestructure<Owner> updateOwnerById(int oldOwnerId,Owner newOwner) {
		responsestructure.setMessage("Susccesfully bank updated in DB");
		 responsestructure.setStatusCode(HttpStatus.OK.value());
		 responsestructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
		return responsestructure;
	}
	public Owner addExistingBankToExistingOwner(int bankId,int ownerId) {
		return ownerDao.addExistingBankToExistingOwner(bankId, ownerId);
	}
}
