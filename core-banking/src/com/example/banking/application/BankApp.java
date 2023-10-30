package com.example.banking.application;

import com.example.banking.domain.Account;

public class BankApp {

	public static void main(String[] args) {
		Account acc = new Account("tr1", 100_000);
		acc.deposit(10_000);
		acc.withdraw(50_000);
		// Error: System.out.println(acc.iban);
		// Error: acc.balance = acc.balance - 10_000_000;
		acc.withdraw(10_000_000);
		
		System.out.println(acc.getBalance());
	}

}
