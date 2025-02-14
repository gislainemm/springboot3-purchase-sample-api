package com.productdemo.purchasetransactionapi.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionDTO;
import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionFiltersDTO;
import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionRetrieveDTO;
import com.productdemo.purchasetransactionapi.domain.entities.PurchaseTransaction;
import com.productdemo.purchasetransactionapi.domain.exceptions.FiscalDataExchangeRateException;
import com.productdemo.purchasetransactionapi.domain.exceptions.FiscalDataExchangeRateNotFoundException;
import com.productdemo.purchasetransactionapi.domain.repositories.PurchaseTransactionRepository;
import com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.FiscalDataService;
import com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.requests.FiscalDataFiltersDTO;
import com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.responses.FiscalDataDTO;
import com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.responses.FiscalDataItemDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "PURCHASE_TRANSACTION_SERVICE_IMPL")
@Service
public class PurchaseTransactionServiceImpl implements PurchaseTransactionService {
	
	@Autowired
	private PurchaseTransactionRepository purchaseTransactionRepository;
	
	@Autowired
	private FiscalDataService fiscalDataService;

	@Override
	public PurchaseTransaction save(PurchaseTransactionDTO transactionDTO) {
		PurchaseTransaction purchaseTransaction = new PurchaseTransaction();
		BeanUtils.copyProperties(transactionDTO, purchaseTransaction);
		return purchaseTransactionRepository.save(purchaseTransaction);
	}

	@Override
	public PurchaseTransactionRetrieveDTO getConvertedPurchase(@NotNull PurchaseTransactionFiltersDTO filters) {
		PurchaseTransaction purchaseTransaction = purchaseTransactionRepository.getReferenceById(filters.getId());
		
		FiscalDataDTO data = getFiscalData(purchaseTransaction, filters);
		
		FiscalDataItemDTO lastItemFound = data.getData().get(1);
		
		BigDecimal exchangeRate = new BigDecimal(lastItemFound.getExchangeRate());
		BigDecimal convertedAmount = purchaseTransaction.getAmount()
				.multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP);
		
		PurchaseTransactionRetrieveDTO retrieveDTO = new PurchaseTransactionRetrieveDTO();
		
		BeanUtils.copyProperties(purchaseTransaction, retrieveDTO);
		retrieveDTO.setConvertedAmount(convertedAmount);
		retrieveDTO.setExchangeRate(exchangeRate.doubleValue());
		
		return retrieveDTO;
	}
	
	private FiscalDataFiltersDTO getFiscalDataFilters(@NotNull LocalDateTime purchaseDate, @NotBlank String currency) {
		LocalDate dateFrom = purchaseDate.minusMonths(6).toLocalDate();
				
		FiscalDataFiltersDTO filters = new FiscalDataFiltersDTO();
		filters.setCurrencyTo(currency);
		filters.setDateFrom(dateFrom.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		
		return filters;
	}
	
	private FiscalDataDTO getFiscalData(PurchaseTransaction purchaseTransaction, PurchaseTransactionFiltersDTO filters) {
		FiscalDataDTO data = null;
		
		try {
			data = fiscalDataService.getExchangeRates(getFiscalDataFilters(purchaseTransaction.getDate(), filters.getCurrencyTo()));	
		} catch(Exception ex) {
			throw new FiscalDataExchangeRateException(filters.getCurrencyTo(), ex.getMessage());
		}
		
		if (data != null && data.getData().isEmpty()) {
			throw new FiscalDataExchangeRateNotFoundException(filters.getCurrencyTo());
		}
		
		return data;
	}

}
