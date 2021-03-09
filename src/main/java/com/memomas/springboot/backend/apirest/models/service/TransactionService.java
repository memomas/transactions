package com.memomas.springboot.backend.apirest.models.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memomas.springboot.backend.apirest.models.entity.Transaction;
import com.memomas.springboot.backend.apirest.models.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction findTransactionByTransactionId(String transactionId, Long userId) {
		Transaction transaction = transactionRepository.findTransactionByTransactionIdAndUser_UserId(transactionId, userId);
		return transaction;
	}
}
