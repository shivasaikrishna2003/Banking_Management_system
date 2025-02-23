package com.qsp.Banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.Banking_management_system.dao.CardDao;
import com.qsp.Banking_management_system.dto.Card;
import com.qsp.Banking_management_system.exception.CardIdNotFound;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

@Service
public class CardService {

	@Autowired
	CardDao cardDao;
	@Autowired
	Responsestructure<Card>  responsestructure;
	@Autowired
	ResponseStructureList<Card> responseStructureList;
	public Responsestructure<Card> saveCard(Card card) {
		responsestructure.setMessage("Susccesfully bank inserted into DB");
		responsestructure.setStatusCode(HttpStatus.CREATED.value());
		responsestructure.setData(cardDao.saveCard(card));
	 return	responsestructure;
	}
	public Responsestructure<Card> fetchCardById(int cardId) {
		Card card=cardDao.fetchCardById(cardId);
		if(card!=null) {
		responsestructure.setMessage("Susccesfully bank fetched from DB");
		responsestructure.setStatusCode(HttpStatus.FOUND.value());
		responsestructure.setData(cardDao.fetchCardById(cardId));
		return responsestructure;
	}else {
		throw new CardIdNotFound();
	}
	}
	public ResponseStructureList<Card> fetchAll(){
		responseStructureList.setMessage("Succesfully All banks are fetched from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(cardDao.fetchAll());
		return responseStructureList;
	}
	public Responsestructure<Card> deleteCardById(int cardId) {
		responsestructure.setMessage("Susccesfully bank deleted from DB");
		responsestructure.setStatusCode(HttpStatus.OK.value());
		responsestructure.setData(cardDao.deleteCardById(cardId));
		return responsestructure;
	}
	 public Responsestructure<Card> updateCardById(int oldCardId,Card newCard) {
		 responsestructure.setMessage("Susccesfully bank updated in DB");
		 responsestructure.setStatusCode(HttpStatus.OK.value());
		 responsestructure.setData(cardDao.updateCardById(oldCardId, newCard));
		 return responsestructure;
	 }
}
