package com.payments.webservice;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payments.model.Payment;
import com.payments.service.PaymentService;

@RestController
public class PaymentWS {

	@Autowired
	PaymentService paymentService;
	
	private static Logger logger = LogManager.getLogger(PaymentWS.class.getName());

	@RequestMapping(value="/sortpayments?sortType=",method= RequestMethod.GET)
	public List<Payment> viewPayments(List<Payment> payments,@RequestParam(value="sortType") String type) {
		List<Payment> listOfpayments = paymentService.getListOfPayments(payments,type);
		return listOfpayments;
	}
	
}
