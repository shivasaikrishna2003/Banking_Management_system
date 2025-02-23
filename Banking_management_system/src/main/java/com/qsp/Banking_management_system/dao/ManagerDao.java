package com.qsp.Banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_management_system.dto.Manager;
import com.qsp.Banking_management_system.repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	ManagerRepo managerRepo;
	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}
	public Manager fetchManagerById(int managerId) {
	  Optional<Manager>  manager= managerRepo.findById(managerId);
	  if(manager.isPresent()) {
		  return manager.get();
	  }else {
		  return null;
	  }
	}
	public List<Manager> fetchAll(){
		return managerRepo.findAll();
	}
	public Manager deleteManagerById(int managerId) {
		Manager manager=managerRepo.findById(managerId).get();
		managerRepo.delete(manager);
		return manager;
	}
	public Manager updateManagerById(int oldManagerId,Manager newManager ) {
		newManager.setManagerId(oldManagerId);
		return managerRepo.save(newManager);
	}
}
