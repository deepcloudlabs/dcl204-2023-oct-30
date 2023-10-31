package com.example.banking.domain;

// Account: super/base class
// CheckingAccount: sub-class/drived-class
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public boolean withdraw(double amount) {
		// Validation Rule
		if (amount <= 0) return false;
		// Business Rule
		if (amount > (this.balance + this.overdraftAmount)) return false;
		this.balance -= amount;
		return true;
	}



}
