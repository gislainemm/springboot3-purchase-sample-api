package com.productdemo.purchasetransactionapi.domain.exceptions;

public class FiscalDataExchangeRateNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FiscalDataExchangeRateNotFoundException(String currency) {
		 super("Exchange rate for target currency not found: " + currency);
	}

}
