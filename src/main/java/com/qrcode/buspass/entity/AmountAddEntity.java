package com.qrcode.buspass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="amount_add",schema="public")
public class AmountAddEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="amount_id")
		private Integer amountId;
	
	@Column(name="custmer_id")
	private Integer custmerId;
	
	@Column(name="amount")
	private Double amount;

	public Integer getAmountId() {
		return amountId;
	}

	public void setAmountId(Integer amountId) {
		this.amountId = amountId;
	}

	public Integer getCustmerId() {
		return custmerId;
	}

	public void setCustmerId(Integer custmerId) {
		this.custmerId = custmerId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
