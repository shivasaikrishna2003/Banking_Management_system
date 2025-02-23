package com.qsp.Banking_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking_management_system.dto.Card;
import com.qsp.Banking_management_system.service.CardService;
import com.qsp.Banking_management_system.util.ResponseStructureList;
import com.qsp.Banking_management_system.util.Responsestructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CardController {

	@Autowired
	CardService cardService;
	@Operation(summary = "Save Card", description = "API is used to save the card")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully saved") })
	@PostMapping("/saveCard")
	public Responsestructure<Card> saveCard(@RequestBody  Card card) {
		return cardService.saveCard(card);
	}
	@Operation(summary = "Fetch Card by id", description = "API is used to Fetch the card by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "card Fetched Succesfully"),
		@ApiResponse(responseCode ="404",description = "card Not found For the given id")})
	@GetMapping("/fetchCard")
	public Responsestructure<Card> fetchCardById(@RequestParam int cardId) {
		return cardService.fetchCardById(cardId);
	}
	@Operation(summary = "Fetch all Cards", description = "API is used to Fetch All the Cards")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = " all Cards Fetched Succesfully"),
			@ApiResponse(responseCode ="404",description = "No Card is presented")})
	@GetMapping("/fetchAllCard")
	public ResponseStructureList<Card> fetchAll(){
		return cardService.fetchAll();
	}
	@Operation(summary = "Delete Card by id", description = "API is used to delete the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Card Deleted Succesfully"),
			@ApiResponse(responseCode ="404",description = "Card Not found For the given id")})
	@DeleteMapping("/deleteCard")
	public Responsestructure<Card> deleteCardById(@RequestParam int cardId) {
		return cardService.deleteCardById(cardId);
	}
	@Operation(summary = "Update Card by id", description = "API is used to update the Card")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Card Updated Succesfully"),
			@ApiResponse(responseCode ="404",description = "Card not found For the given id")})
	@PutMapping("/updateCard")
	 public Responsestructure<Card> updateCardById(@RequestParam int oldCardId,@RequestBody Card newCard) {
		 return cardService.updateCardById(oldCardId, newCard);
	 }
}
