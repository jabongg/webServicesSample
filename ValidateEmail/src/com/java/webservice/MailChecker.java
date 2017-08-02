package com.java.webservice;

import net.webservicex.ValidateEmail;
import net.webservicex.ValidateEmailSoap;

public class MailChecker {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("you need to pass at least one email");
		} else {
			String email = args[0];
			ValidateEmail valiEmail = new ValidateEmail();
			ValidateEmailSoap validEmailSoap = valiEmail.getValidateEmailSoap();
			boolean isValidEmail = validEmailSoap.isValidEmail(email);
			System.out.println(isValidEmail);
		}
	}

}
