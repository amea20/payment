package com.payments.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.payments.model.Payment;
import com.payments.service.PaymentService;
import com.payments.validation.PaymentValidator;

@Controller
public class PaymentController {

	private static Logger logger = LogManager.getLogger(PaymentController.class.getName());
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	private PaymentValidator paymentValidator;
	
	@InitBinder("payment")
	   protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.setValidator(paymentValidator);
	   }
	
	@RequestMapping(method = RequestMethod.GET, value ="/list-payments")
	public String ListPayments(List<Payment> payments, Payment payment, Model model) {
		model.addAttribute("payment",payment);
		model.addAttribute("payments",payments);
		return "/add-payments";
	}
		
	@RequestMapping(method = RequestMethod.POST, value ="/list-payments")
	public ModelAndView addedProject(@Validated @ModelAttribute List<Payment> payments, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/payments");
		paymentService.getListOfPayments(payments, "");
		if (result.hasErrors()) {
			return new ModelAndView("/add-payments");
		}
		return mv;
		
	}
}
