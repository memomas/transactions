package com.memomas.springboot.backend.apirest.models.entity;

public class TransactionDTO {
	private Double amount;
	private String Description;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
