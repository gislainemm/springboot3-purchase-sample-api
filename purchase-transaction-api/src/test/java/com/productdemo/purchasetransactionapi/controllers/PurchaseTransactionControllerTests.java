package com.productdemo.purchasetransactionapi.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.productdemo.purchasetransactionapi.domain.dtos.PurchaseTransactionDTO;
import com.productdemo.purchasetransactionapi.domain.entities.PurchaseTransaction;
import com.productdemo.purchasetransactionapi.services.PurchaseTransactionServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PurchaseTransactionControllerTests {

	@InjectMocks
	PurchaseTransactionController purchaseTransactionController;
	
	@Mock
	PurchaseTransactionServiceImpl purchaseTransactionService;
	
	
	@Test
	public void givenValidInput_whenSave_thenReturnsHttpStatusCreated() throws Exception {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        //given
        final PurchaseTransactionDTO purchaseTransactionDTO = new PurchaseTransactionDTO("Transaction 1", LocalDateTime.now(), new BigDecimal(50));
        final PurchaseTransaction purchaseTransaction = new PurchaseTransaction(UUID.fromString("f000aa01-0451-4000-b000-000000012345"),"Transaction 1", LocalDateTime.now(), new BigDecimal(50));
        
        //when
        Mockito.lenient().when(purchaseTransactionService.save(purchaseTransactionDTO)).thenReturn(purchaseTransaction);
		
        //then
        ResponseEntity<PurchaseTransaction> responseEntity = purchaseTransactionController.save(purchaseTransactionDTO);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	

}
