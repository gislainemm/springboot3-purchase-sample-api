package com.productdemo.purchasetransactionapi.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PurchaseTransactionFiltersDTO {

	@NotNull(message="Id cannot be null")
	private UUID id;
	
	@NotBlank(message="Currency To must not be blank")
	private String currencyTo;

	public PurchaseTransactionFiltersDTO() {
		super();
	}


	public PurchaseTransactionFiltersDTO(@NotNull(message = "Id cannot be null") UUID id,
			@NotBlank(message = "Currency To must not be blank") String currencyTo) {
		super();
		this.id = id;
		this.currencyTo = currencyTo;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	
	
}
