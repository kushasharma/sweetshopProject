package com.capg.validation;

import org.springframework.stereotype.Component;

import com.capg.model.Customer;

@Component
public class UserValidation {

	public boolean validateUserFields(Customer customer) {
		if(!validatePhone(customer.getcPhone())) {
			throw new RuntimeException("Phone Number is invalid !");
		}
		
		if(!validatePassword(customer.getcPassword())) {
			throw new RuntimeException("Password should be more than 5 characters !");
		}
		return true;
	}

	private boolean validatePassword(String getcPassword) {
		return getcPassword.length()>=5;
	}

	private boolean validatePhone(String getcPhone) {	
		return getcPhone.length()==10;
	}
} 