package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.FdDao;
import com.qsp.Banking_management_system.dto.Fd;
import com.qsp.Banking_management_system.exception.FdIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class FdService {

	@Autowired
	FdDao fdDao;
	@Autowired
	Responsestructure<Fd> responsestructure;
	@Autowired
	ResponseStructureList<Fd> responseStructureList;
	public Responsestructure<Fd> savefd(Fd fd) {
		 responsestructure.setMessage("Susccesfully bank inserted into DB");
		 responsestructure.setStatusCode(HttpStatus.CREATED.value());
		 responsestructure.setData(fdDao.saveFd(fd));
		return responsestructure;
	}
	public Responsestructure<Fd> fetchFdById(int fdId) {
		Fd fd=fdDao.fetchFdById(fdId);
		if(fd!=null) {
		responsestructure.setMessage("Susccesfully bank fetched from DB");
		 responsestructure.setStatusCode(HttpStatus.FOUND.value());
		 responsestructure.setData(fdDao.fetchFdById(fdId));
		return responsestructure;
	}else {
		throw new FdIdNotFound();
	}
		}
	public ResponseStructureList<Fd> fetchAll(){
		responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		 responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		 responseStructureList.setData(fdDao.fetchAll());
		return responseStructureList;
	}
	public Responsestructure<Fd> deleteFdById(int fdId) {
		responsestructure.setMessage("Susccesfully bank deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(fdDao.deleteFdById(fdId));
		return responsestructure;
	}
	public Responsestructure<Fd> updateFdById(int oldFdId,Fd newFd) {
		responsestructure.setMessage("Susccesfully bank updated in DB");
		 responsestructure.setStatusCode(HttpStatus.OK.value());
		 responsestructure.setData(fdDao.updateFdById(oldFdId, newFd));
		return responsestructure;
	}
}
