package com.ncr.dbk.niis.model;

public class TransactionAmount {

	private Amount amount;
	private TransactionAmountType type;

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public TransactionAmountType getType() {
		return type;
	}

	public void setType(TransactionAmountType type) {
		this.type = type;
	}
	
}
