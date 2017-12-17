package com.payments.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.payments.model.Payment;
import com.payments.model.PaymentForm;
import com.payments.service.PaymentService;
import com.payments.validation.PaymentValidator;

@Controller
@SessionAttributes("paymentForm")
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
	public String listPayments(PaymentForm paymentForm,Model model) {
		model.addAttribute("paymentForm", paymentForm);
		return "add-payments";
	}
		
	@RequestMapping(method = RequestMethod.POST, value ="/list-payments")
	public ModelAndView addedPayments(@Validated @ModelAttribute PaymentForm paymentForm, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:payments");
		logger.info("Payments List: " + paymentForm.getPayments());
		paymentForm.setPayments(paymentService.getListOfPayments(paymentForm.getPayments(), "default"));
		if (result.hasErrors()) {
			return new ModelAndView("add-payments");
		}
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/payments")
	public String viewPayments(@ModelAttribute PaymentForm paymentForm) {
		paymentForm.setPayments(paymentService.getListOfPayments(paymentForm.getPayments(), "default"));
		return "payments";
	}
}
