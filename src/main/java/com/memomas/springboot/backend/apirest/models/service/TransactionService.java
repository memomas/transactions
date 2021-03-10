package com.memomas.springboot.backend.apirest.models.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.memomas.springboot.backend.apirest.models.entity.SumTransactionDTO;
import com.memomas.springboot.backend.apirest.models.entity.Transaction;
import com.memomas.springboot.backend.apirest.models.entity.TransactionDTO;
import com.memomas.springboot.backend.apirest.models.entity.User;
import com.memomas.springboot.backend.apirest.models.repository.TransactionRepository;
import com.memomas.springboot.backend.apirest.models.repository.UserRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
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
	
	public ResponseEntity<?> findRandomTransaction(){
		Map<String, Object> response = new HashMap<>();
		Transaction transaction = null;
		try {
			transaction = transactionRepository.findRandomTransaction();
		}catch(DataAccessException e){
			response.put("message", "Error establishing a database connection");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}
	
	public ResponseEntity<?> sumAllTransactions(Long userId){
		Map<String, Object> response = new HashMap<>();
		SumTransactionDTO transactionDTO = null;
		User user = userRepository.findUserByUserId(userId);
		Double sum;
		if(user == null) {
			response.put("message", "User does not exist");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			sum = transactionRepository.sumTransactions(userId);
			transactionDTO = new SumTransactionDTO();
			transactionDTO.setSum(sum);
			transactionDTO.setUserId(userId);
		}catch(DataAccessException e){
			response.put("message", "Error establishing a database connection");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SumTransactionDTO>(transactionDTO, HttpStatus.OK);
	}
	
	public ResponseEntity<?> findAllTransactions(Long userId){
		List<Transaction> transactions = null;
		Map<String, Object> response = new HashMap<>();
		try {
			transactions = transactionRepository.findAllTransactionsByUser_UserId(userId);
		}catch(DataAccessException e){
			response.put("message", "Error establishing a database connection");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(transactions.isEmpty()) {
			response.put("message", "User does not exist");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	
	public ResponseEntity<?> saveTransaction(TransactionDTO transactionDTO, Long userId){
		Map<String, Object> response = new HashMap<>();
		User user = null;
		Transaction transaction = null;
		try {
			user = userRepository.findUserByUserId(userId);
			transaction = new Transaction();
			transaction.setUser(user);
			transaction.setAmount(transactionDTO.getAmount());
			transaction.setDescription(transactionDTO.getDescription());
			transactionRepository.save(transaction);
		}catch(DataAccessException e){
			response.put("message", "Error establishing a database connection");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
	}
}
