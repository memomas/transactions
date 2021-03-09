package com.memomas.springboot.backend.apirest.models.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.memomas.springboot.backend.apirest.models.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	Transaction findTransactionByTransactionIdAndUser_UserId(String Transaction, Long userId);
	List<Transaction> findAllTransactionsByUser_UserId(Long userId);
}
