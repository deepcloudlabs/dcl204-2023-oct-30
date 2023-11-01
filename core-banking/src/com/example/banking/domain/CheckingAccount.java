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
	public boolean withdraw(final double amount) {
		// Validation Rule
		if (amount <= 0) return false;
		// Business Rule
		final var totalBalance = this.balance + this.overdraftAmount;
		if (amount > totalBalance) return false;
		this.balance -= amount;
		return true;
	}



}
