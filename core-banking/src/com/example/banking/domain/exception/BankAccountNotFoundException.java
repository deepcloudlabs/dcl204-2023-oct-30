package com.example.banking.domain.exception;

@SuppressWarnings("serial")
public class BankAccountNotFoundException extends RuntimeException {

	private final String iban;

	public BankAccountNotFoundException(String message, String iban) {
		super(message);
		this.iban = iban;
	}

	public String getIban() {
		return iban;
	}

}
