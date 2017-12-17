package com.payments.model;

import java.util.ArrayList;
import java.util.List;

public class PaymentForm {

	private List<Payment> payments = new ArrayList<>();

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
}
