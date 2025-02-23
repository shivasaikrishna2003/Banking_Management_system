package com.qsp.Banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.Banking_management_system.dto.Fd;
import com.qsp.Banking_management_system.repo.FdRepo;

@Repository
public class FdDao {

	@Autowired
	FdRepo fdRepo;
	public Fd saveFd(Fd fd) {
		return fdRepo.save(fd);
	}
	public Fd fetchFdById(int fdId) {
		Optional<Fd> fd= fdRepo.findById(fdId);
		if(fd.isPresent()) {
			return fd.get();
		}else {
			return null;
		}
	}
	public List<Fd> fetchAll(){
		return fdRepo.findAll();
	}
	public Fd deleteFdById(int fdId) {
		Fd fd=fdRepo.findById(fdId).get();
		fdRepo.delete(fd);
		return fd;
		}
	public Fd updateFdById(int oldFdId,Fd newFd) {
		newFd.setFdId(oldFdId);
		return fdRepo.save(newFd);
	}
}
