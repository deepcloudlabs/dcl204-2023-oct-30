package com.example.banking.domain;

public class Account extends Object { // encapsulation: [data + methods]
	// Members
	// 1. attribute/state/data/property
	// Information Hiding Principle
	private String iban;
	private double balance;

	// 2. Methods
	// I) Constructor -> object
	// Constructor Overloading
//	public Account(String iban) { // Signature: (String)
//		this.iban = iban;
//		this.balance = 100.0;
//	}
	public Account(String iban) { // Signature: (String)
		this(iban, 100.0); // delegation
	}

	public Account(String iban, double balance) {// Signature: (String,double)
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
		// validation rule
		if (amount <= 0)
			return false;
		// business logic
		this.balance = this.balance + amount;
		assert this.balance >= 0;
		return true;
	}

	public boolean withdraw(double amount) {
		// validation rule
		if (amount <= 0)
			return false;
		// business rule
		if (amount > this.balance)
			return false;
		// business logic
		this.balance = this.balance - amount;		
		assert this.balance >= 0;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}