package com.productdemo.purchasetransactionapi.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class PurchaseTransactionDTO {

	@NotBlank(message = "Description cannot be blank")
	@Size(max = 50, message = "Description must not exceed 50 characters")
	@Schema(description = "description", example = "Transaction 1")
	private String description;
	
	@NotNull(message = "Date cannot be null")
	@Temporal(TemporalType.TIMESTAMP)
	@Schema(description = "date", example = "Transaction 1")
    private LocalDateTime date;
	
	@NotNull(message = "Amount cannot be null")
	@Positive(message = "Amount must be positive")
	@Schema(description = "amount", example = "258.69")
	private BigDecimal amount;

	public PurchaseTransactionDTO() {
		super();
	}

	public PurchaseTransactionDTO(
			@NotBlank(message = "Description cannot be blank") @Size(max = 50, message = "Description must not exceed 50 characters") String description,
			@NotBlank(message = "Date cannot be null") LocalDateTime date,
			@NotNull @Positive(message = "Amount must be positive") BigDecimal amount) {
		super();
		this.description = description;
		this.date = date;
		this.amount = amount;
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
	
	
	
		
}
