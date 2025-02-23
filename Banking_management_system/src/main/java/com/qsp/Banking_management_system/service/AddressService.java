package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.AddressDao;
import com.qsp.Banking_management_system.dto.Address;
import com.qsp.Banking_management_system.exception.AddressIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	@Autowired
	Responsestructure<Address> responsestructure;
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	public Responsestructure<Address> saveAddress(Address address) {
		responsestructure.setMessage("Susccesfully address inserted into DB");
		responsestructure.setStatusCode(HttpStatus.CREATED.value());
		responsestructure.setData(addressDao.saveAddress(address));
		return responsestructure;
	}
	public Responsestructure<Address> fetchAddressById(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null) {
		responsestructure.setMessage("Susccesfully address fetched from DB");
		responsestructure.setStatusCode(HttpStatus.FOUND.value());
		responsestructure.setData(addressDao.fetchAddressById(addressId));
		return responsestructure;
	}
		else {
			throw new AddressIdNotFound();
		}
	}
	public ResponseStructureList<Address> fetchAll() {
		responseStructureList.setMessage("Succesfully All addresses are fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(addressDao.fetchAll());
		return responseStructureList;
	}
	public Responsestructure<Address> deleteAddressById(int addressId) {
		responsestructure.setMessage("Susccesfully address deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(addressDao.deleteAddressById(addressId));
		return responsestructure;
	}
	public Responsestructure<Address> updateAddressById(int oldAddressId,Address newAddress) {
		responsestructure.setMessage("Susccesfully address updated in DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		return responsestructure;
	}
}
