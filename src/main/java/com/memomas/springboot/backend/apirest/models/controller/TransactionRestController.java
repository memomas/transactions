package com.memomas.springboot.backend.apirest.models.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.memomas.springboot.backend.apirest.models.entity.Transaction;
import com.memomas.springboot.backend.apirest.models.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionRestController {
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transactions/{transactionId}/user/{userId}")
	public ResponseEntity<Transaction> findTransactionById(@PathVariable String transactionId, @PathVariable Long userId) {
		Transaction transaction = transactionService.findTransactionByTransactionId(transactionId, userId);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
}
