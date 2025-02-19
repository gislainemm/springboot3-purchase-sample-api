package com.productdemo.purchasetransactionapi.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PurchaseTransactionRetrieveDTO {

	private UUID id;
	
	private String description;
	
    private LocalDateTime date;

	private BigDecimal amount;
	
	private Double exchangeRate;
	
	private BigDecimal convertedAmount;

	public PurchaseTransactionRetrieveDTO() {
		super();
	}

	public PurchaseTransactionRetrieveDTO(UUID id, String description, LocalDateTime date, BigDecimal amount,
			Double exchangeRate, BigDecimal convertedAmount) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.amount = amount;
		this.exchangeRate = exchangeRate;
		this.convertedAmount = convertedAmount;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public BigDecimal getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(BigDecimal convertedAmount) {
		this.convertedAmount = convertedAmount;
	}	
	
	
}
