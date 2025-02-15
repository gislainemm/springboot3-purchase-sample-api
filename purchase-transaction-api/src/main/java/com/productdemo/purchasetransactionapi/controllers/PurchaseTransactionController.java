package com.productdemo.purchasetransactionapi.controllers;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionDTO;
import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionFiltersDTO;
import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionRetrieveDTO;
import com.productdemo.purchasetransactionapi.domain.entities.PurchaseTransaction;
import com.productdemo.purchasetransactionapi.services.PurchaseTransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@Tag(name = "purchase")
@RequestMapping(value = "/purchase/transactions")	
@Slf4j(topic = "PURCHASE_TRANSACTION_CONTROLLER")
public class PurchaseTransactionController {
	
	@Autowired
	private PurchaseTransactionService purchaseTransactionService;
	
	@PostMapping()
	@Operation(description = "Stores a purchase transaction")
	public ResponseEntity<PurchaseTransaction> save(@RequestBody @Valid PurchaseTransactionDTO purchaseTransactionDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(purchaseTransactionService.save(purchaseTransactionDTO));
	}
	
	@GetMapping()
	@Operation(description = "Get a purchase transaction by id and currency")
	public ResponseEntity<PurchaseTransactionRetrieveDTO> getByIdAndCurrency(@RequestParam("id") @NotNull UUID id, 
			@RequestParam("currencyTo") @NotBlank String currencyTo) {
		PurchaseTransactionFiltersDTO filtersDTO = new PurchaseTransactionFiltersDTO();
		filtersDTO.setId(id);
		filtersDTO.setCurrencyTo(currencyTo);
		
		PurchaseTransactionRetrieveDTO retrieveDTO = null;
		try {
			retrieveDTO = purchaseTransactionService.getConvertedPurchase(filtersDTO);
	    } catch (EntityNotFoundException enfe) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
		
		return ResponseEntity.status(HttpStatus.OK).body(retrieveDTO);
	}
	
}
