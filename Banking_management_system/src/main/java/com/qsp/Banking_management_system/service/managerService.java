package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.ManagerDao;
import com.qsp.Banking_management_system.dto.Manager;
import com.qsp.Banking_management_system.exception.ManagerIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class managerService {

	@Autowired
	ManagerDao managerDao;
	@Autowired
	Responsestructure<Manager> responsestructure;
	@Autowired
	ResponseStructureList<Manager> responseStructureList;
	public Responsestructure<Manager> saveManager(Manager manager) {
		responsestructure.setMessage("Susccesfully bank inserted into DB");
		 responsestructure.setStatusCode(HttpStatus.CREATED.value());
		 responsestructure.setData(managerDao.saveManager(manager));
		return responsestructure;
	}
	public Responsestructure<Manager> fetchManagerById(int managerId) {
		Manager manager=managerDao.fetchManagerById(managerId);
		if(manager!=null) {
		responsestructure.setMessage("Susccesfully bank fetched from DB");
		 responsestructure.setStatusCode(HttpStatus.FOUND.value());
		 responsestructure.setData(managerDao.fetchManagerById(managerId));
		return responsestructure;
	}else{
		throw new ManagerIdNotFound();
		}
	}
	public ResponseStructureList<Manager> fetchAll(){
		responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		 responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		 responseStructureList.setData(managerDao.fetchAll());
		return responseStructureList;
	}
	public Responsestructure<Manager> deleteManagerById(int managerId) {
		responsestructure.setMessage("Susccesfully bank deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(managerDao.deleteManagerById(managerId));
		return responsestructure;			
	}
	public Responsestructure<Manager> updateManagerById(int oldManagerId,Manager newManager) {
		responsestructure.setMessage("Susccesfully bank updated in DB");
		 responsestructure.setStatusCode(HttpStatus.OK.value());
		 responsestructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
		return responsestructure;
	}
}
