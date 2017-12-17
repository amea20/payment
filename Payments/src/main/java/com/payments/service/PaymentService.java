package com.payments.service;

import java.util.List;

import com.payments.model.Payment;

public interface PaymentService {

	public List<Payment> getListOfPayments(List<Payment> payments, String sortType);
	
	public List<Payment> paymentsList();
}
