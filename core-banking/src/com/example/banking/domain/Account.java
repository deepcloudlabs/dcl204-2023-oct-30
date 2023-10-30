package com.example.banking.domain;

public class Account {
	// Members
	// 1. attribute/state/data/property
	private String iban;
	private double balance;

	// 2. Methods
	// I) Constructor -> object
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	// II) Getter Methods
	public String getIban() {
		return this.iban;
	}

	public double getBalance() {
		return this.balance;
	}

	// II) Business Methods
	public boolean deposit(double amount) {
		return true;
	}

	public boolean withdraw(double amount) {
		return true;
	}

}