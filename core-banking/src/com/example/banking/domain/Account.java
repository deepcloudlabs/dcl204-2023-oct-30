package com.example.banking.domain;

public class Account extends Object { // encapsulation: [data + methods]
	// Members
	// 1. attribute/state/data/property
	// Information Hiding Principle
	private final String iban; // read-only
	protected double balance;
	private static int numberOfAccounts; // default permission -> package private
	protected AccountStatus accountStatus; // 0: CLOSED, 1: ACTIVE, 2: BLOCKED
	// 2. Methods
	// I) Constructor -> object
	// Constructor Overloading
//	public Account(String iban) { // Signature: (String)
//		this.iban = iban;
//		this.balance = 100.0;
//	}

	public Account(final String iban) { // Signature: (String)
		this(iban, 100.0); // delegation
	}

	public Account(final String iban, final double balance) {// Signature: (String,double)
		this(iban, balance,AccountStatus.ACTIVE);
	}
	
	public Account(final String iban, final double balance, AccountStatus accountStatus) {// Signature: (String,double)
		this.iban = iban;
		this.balance = balance;
		this.accountStatus = accountStatus;
		numberOfAccounts++;
	}

	// II) Getter Methods

	public String getIban() {
		return this.iban;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
			this.accountStatus = accountStatus;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public double getBalance() {
		return this.balance;
	}

	// II) Business Methods
	public boolean deposit(final double amount) {
		// validation rule
		if (amount <= 0)
			return false;
		// business logic
		this.balance = this.balance + amount;
//		assert this.balance >= 0;
		return true;
	}

	public boolean withdraw(final double amount) {
		// validation rule
		if (amount <= 0)
			return false;
		// business rule
		if (amount > this.balance)
			return false;
		// business logic
		this.balance = this.balance - amount;
//		assert this.balance >= 0;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + ", accountStatus=" + accountStatus + "]";
	}



}