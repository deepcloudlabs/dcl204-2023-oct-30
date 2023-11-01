package com.example.banking.application;

import static com.example.banking.domain.Account.getNumberOfAccounts;

import com.example.banking.domain.Account;
import com.example.banking.domain.AccountStatus;

public class BankApp {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		System.out.println("Number of accounts: %d".formatted(getNumberOfAccounts()));
		// -ea -XX:-UseCompressedOops
		Account acc = new Account("tr1", 100_000);
		acc.deposit(10_000);
		acc.withdraw(50_000);
		// Error: System.out.println(acc.iban);
		// Error: acc.balance = acc.balance - 10_000_000;
		acc.withdraw(10_000_000);
		System.out.println(acc.toString());
		System.out.println("Number of accounts: %d".formatted(getNumberOfAccounts()));
		new Account("tr2");
		new Account("tr3");
		new Account("tr4");
		new Account("tr5");
		new Account("tr6");
		System.out.println("Number of accounts: %d".formatted(getNumberOfAccounts()));
		System.out.println("Number of accounts: %d".formatted(((Account)null).getNumberOfAccounts()));
        for (var accountStatus : AccountStatus.values()) {
        	System.out.println("%s: \t%d,%d".formatted(accountStatus.name(),accountStatus.ordinal(),accountStatus.getBddkCode()));
        }
	}

}
