package com.memomas.springboot.backend.apirest.models.entity;

public class SumTransactionDTO {
	
	private Long userId;
	private Double sum;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
}
