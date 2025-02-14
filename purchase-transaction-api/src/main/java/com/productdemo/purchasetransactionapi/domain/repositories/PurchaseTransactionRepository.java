package com.productdemo.purchasetransactionapi.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productdemo.purchasetransactionapi.domain.entities.PurchaseTransaction;

@Repository
public interface PurchaseTransactionRepository extends JpaRepository<PurchaseTransaction, UUID>{

}
