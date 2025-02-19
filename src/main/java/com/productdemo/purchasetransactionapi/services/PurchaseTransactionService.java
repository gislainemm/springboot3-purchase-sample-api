package com.productdemo.purchasetransactionapi.services;

import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionDTO;
import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionFiltersDTO;
import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionRetrieveDTO;
import com.productdemo.purchasetransactionapi.domain.entities.PurchaseTransaction;

public interface PurchaseTransactionService {
	
	PurchaseTransaction save(PurchaseTransactionDTO transactionDTO);
	
	PurchaseTransactionRetrieveDTO getConvertedPurchase(PurchaseTransactionFiltersDTO filters);

}
