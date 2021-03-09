package com.memomas.springboot.backend.apirest.models.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.memomas.springboot.backend.apirest.models.entity.Transaction;
import com.memomas.springboot.backend.apirest.models.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	public ResponseEntity<?> findTransactionByTransactionId(String transactionId, Long userId) {
		Transaction transaction = null;
		Map<String, Object> response = new HashMap<>();
		try {
			transaction = transactionRepository.findTransactionByTransactionIdAndUser_UserId(transactionId, userId);
		}catch(DataAccessException e){
			response.put("message", "Error establishing a database connection");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(transaction == null) {
			response.put("message", "Transaction not found");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	public ResponseEntity<?> findAllTransactions(Long userId){
		List<Transaction> transactions = transactionRepository.findAllTransactionsByUser_UserId(userId);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
}
