package com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.requests;

public class FiscalDataFiltersDTO {
	
	private String currencyTo;
	private String dateFrom;
	
	public FiscalDataFiltersDTO() {
		super();
	}
	public FiscalDataFiltersDTO(String currencyTo, String dateFrom) {
		super();
		this.currencyTo = currencyTo;
		this.dateFrom = dateFrom;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	
}
