package com.payments.dao;

import java.util.List;

import com.payments.model.Payment;

public interface PaymentDAO {

	public List<Payment> getListOfPayments(List<Payment> payments, String sortType);
}
