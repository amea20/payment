package com.payments.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payments.model.Payment;
import com.payments.service.PaymentService;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	public List<Payment> getListOfPayments (List<Payment> payments, String sortType) {
		payments.sort(Comparator.naturalOrder());
		
		if (sortType.equalsIgnoreCase("date")) {
			Collections.sort(payments,new Comparator<Payment>() {
				public int compare(Payment p1, Payment p2) {
					return p1.getPaymentDate().compareTo(p2.getPaymentDate());
				}
			});
			return payments;
		}
		
		else if (sortType.equalsIgnoreCase("amount")) {
			Collections.sort(payments,new Comparator<Payment>() {
				public int compare(Payment p1, Payment p2) {
					return (int) (p1.getAmount() - p2.getAmount());
				}
			});
		}
		return payments;
	};
	
}
