package com.productdemo.purchasetransactionapi.services.webclients.fiscaldata.responses;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiscalDataItemDTO {
	
	@JsonProperty("record_date")
	private Date recordDate;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("country_currency_desc")
	private String countryCurrencyDesc;
	
	@JsonProperty("exchange_rate")
	private Double exchangeRate;
	
	@JsonProperty("effective_date")
	private Date effectiveDate;
	
	@JsonProperty("src_line_nbr")
	private int srcLineNbr;
	
	@JsonProperty("record_fiscalyear")
	private int recordFiscalyear;
	
	@JsonProperty("record_fiscal_quarter")
	private int recordFiscalQuarter;
	
	@JsonProperty("record_calendar_year")
	private int recordCalendarYear;
	
	@JsonProperty("record_calendar_quarter")
	private int recordCalendarQuarter;
	
	@JsonProperty("record_calendar_month")
	private int recordCalendarMonth;
	
	@JsonProperty("record_calendar_day")
	private int recordCalendarDay;

	public FiscalDataItemDTO(Date recordDate, String country, String currency, String countryCurrencyDesc,
			Double exchangeRate, Date effectiveDate, int srcLineNbr, int recordFiscalyear, int recordFiscalQuarter,
			int recordCalendarYear, int recordCalendarQuarter, int recordCalendarMonth, int recordCalendarDay) {
		super();
		this.recordDate = recordDate;
		this.country = country;
		this.currency = currency;
		this.countryCurrencyDesc = countryCurrencyDesc;
		this.exchangeRate = exchangeRate;
		this.effectiveDate = effectiveDate;
		this.srcLineNbr = srcLineNbr;
		this.recordFiscalyear = recordFiscalyear;
		this.recordFiscalQuarter = recordFiscalQuarter;
		this.recordCalendarYear = recordCalendarYear;
		this.recordCalendarQuarter = recordCalendarQuarter;
		this.recordCalendarMonth = recordCalendarMonth;
		this.recordCalendarDay = recordCalendarDay;
	}

	public FiscalDataItemDTO() {
		super();
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCountryCurrencyDesc() {
		return countryCurrencyDesc;
	}

	public void setCountryCurrencyDesc(String countryCurrencyDesc) {
		this.countryCurrencyDesc = countryCurrencyDesc;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public int getSrcLineNbr() {
		return srcLineNbr;
	}

	public void setSrcLineNbr(int srcLineNbr) {
		this.srcLineNbr = srcLineNbr;
	}

	public int getRecordFiscalyear() {
		return recordFiscalyear;
	}

	public void setRecordFiscalyear(int recordFiscalyear) {
		this.recordFiscalyear = recordFiscalyear;
	}

	public int getRecordFiscalQuarter() {
		return recordFiscalQuarter;
	}

	public void setRecordFiscalQuarter(int recordFiscalQuarter) {
		this.recordFiscalQuarter = recordFiscalQuarter;
	}

	public int getRecordCalendarYear() {
		return recordCalendarYear;
	}

	public void setRecordCalendarYear(int recordCalendarYear) {
		this.recordCalendarYear = recordCalendarYear;
	}

	public int getRecordCalendarQuarter() {
		return recordCalendarQuarter;
	}

	public void setRecordCalendarQuarter(int recordCalendarQuarter) {
		this.recordCalendarQuarter = recordCalendarQuarter;
	}

	public int getRecordCalendarMonth() {
		return recordCalendarMonth;
	}

	public void setRecordCalendarMonth(int recordCalendarMonth) {
		this.recordCalendarMonth = recordCalendarMonth;
	}

	public int getRecordCalendarDay() {
		return recordCalendarDay;
	}

	public void setRecordCalendarDay(int recordCalendarDay) {
		this.recordCalendarDay = recordCalendarDay;
	}
	
	

}
