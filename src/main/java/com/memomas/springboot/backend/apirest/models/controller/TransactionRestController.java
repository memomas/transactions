package com.memomas.springboot.backend.apirest.models.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.memomas.springboot.backend.apirest.models.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionRestController {
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transactions/{transactionId}/user/{userId}")
	public ResponseEntity<?> findTransactionById(@PathVariable String transactionId, @PathVariable Long userId) {
		return transactionService.findTransactionByTransactionId(transactionId, userId);
	}
}
