package com.productdemo.purchasetransactionapi.domain.exceptions;

public class FiscalDataExchangeRateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FiscalDataExchangeRateException(String currency, String trace) {
		 super("An error occurred when trying to get exchange rate for the target currency: " + currency + 
				 ". Detailss: " + trace);
	}

}
