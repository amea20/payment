package com.payments.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.payments.dao.PaymentDAO;
import com.payments.model.Payment;

@Repository("paymentDAO")
public class PaymentDAOImpl implements PaymentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Payment> getListOfPayments(List<Payment> payments, String sortType) {
		
		return null;
	}
}
