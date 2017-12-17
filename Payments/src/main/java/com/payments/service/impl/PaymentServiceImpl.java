package com.payments.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.payments.model.Payment;
import com.payments.service.PaymentService;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	public List<Payment> getListOfPayments (List<Payment> payments, String sortType) {
		payments.sort(Comparator.comparing(Payment::getId));
		
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
	
	public List<Payment> paymentsList() {
		List<Payment> payments = new ArrayList<>();
		Payment p1 = new Payment();
		Payment p2 = new Payment();
		Payment p3 = new Payment();
		Payment p4 = new Payment();
		Payment p5 = new Payment();
		p1.setAmount(25);
		p1.setCurrency("£");
		p1.setSrcAccountNumber(12345678);
		p1.setDestAccountNumber(23456789);
		p1.setPaymentDate(new Date());
		p2.setAmount(25);
		p2.setCurrency("£");
		p2.setSrcAccountNumber(12345678);
		p2.setDestAccountNumber(23456789);
		p2.setPaymentDate(new Date());
		p3.setAmount(25);
		p3.setCurrency("£");
		p3.setSrcAccountNumber(12345678);
		p3.setDestAccountNumber(23456789);
		p3.setPaymentDate(new Date());
		p4.setAmount(25);
		p4.setCurrency("£");
		p4.setSrcAccountNumber(12345678);
		p4.setDestAccountNumber(23456789);
		p4.setPaymentDate(new Date());
		p5.setAmount(25);
		p5.setCurrency("£");
		p5.setSrcAccountNumber(12345678);
		p5.setDestAccountNumber(23456789);
		p5.setPaymentDate(new Date());
		payments.add(p1);
		payments.add(p2);
		payments.add(p3);
		payments.add(p4);
		payments.add(p5);
		return payments;
	}
}
