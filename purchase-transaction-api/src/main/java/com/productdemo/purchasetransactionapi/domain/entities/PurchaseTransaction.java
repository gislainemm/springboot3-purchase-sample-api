package com.productdemo.purchasetransactionapi.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_transactions")
public class PurchaseTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "date", nullable = false)
    private LocalDateTime date;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	public PurchaseTransaction() {
		super();
	}

	public PurchaseTransaction(UUID id, String description, LocalDateTime date, BigDecimal amount) {
		super();
		this.id = id;
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

	public UUID getId() {
		return id;
	}
	
	
}
