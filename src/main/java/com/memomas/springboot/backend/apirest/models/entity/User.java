package com.memomas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long userId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, name="last_name")
	private String lastName;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Transaction> transactions;
	
	public User() {
		transactions = new ArrayList<Transaction>();
	}

	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	private static final long serialVersionUID = 1L;
}
