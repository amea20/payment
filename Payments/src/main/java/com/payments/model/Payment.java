package com.payments.model;

import java.util.Date;

public class Payment {

	private int id;
	private double amount;
	private String currency;
	private Date paymentDate;
	private int srcAccountNumber;
	private int destAccountNumber;
	
	public Payment() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getSrcAccountNumber() {
		return srcAccountNumber;
	}
	public void setSrcAccountNumber(int srcAccountNumber) {
		this.srcAccountNumber = srcAccountNumber;
	}
	public int getDestAccountNumber() {
		return destAccountNumber;
	}
	public void setDestAccountNumber(int destAccountNumber) {
		this.destAccountNumber = destAccountNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + destAccountNumber;
		result = prime * result + id;
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + srcAccountNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (destAccountNumber != other.destAccountNumber)
			return false;
		if (id != other.id)
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (srcAccountNumber != other.srcAccountNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", currency=" + currency + ", paymentDate=" + paymentDate
				+ ", srcAccountNumber=" + srcAccountNumber + ", destAccountNumber=" + destAccountNumber + "]";
	}

	
}
