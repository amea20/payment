package com.payments.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.payments.model.Payment;

public class PaymentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Payment.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "payment.amount.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currency", "payment.currency.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "paymentDate", "payment.date.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "srcAccountNumber", "payment.src.accountnumber.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destAccountNumber", "payment.dest.accountnumber.required");
	
		Payment payment = (Payment) target;
		
		if (payment.getAmount() < 0) {
			errors.rejectValue("amount", "payment.amount.negative");
		}
	}
	
}
