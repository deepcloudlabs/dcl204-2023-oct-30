package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private final String identityNo;
	private String fullName;
	private List<Account> accounts = new ArrayList<>();
	
	// Constructor -> identityNo (getter), fullName(getter/setter)
	public void addAccount(Account account) {
		String iban = account.getIban();
		if (!this.existsAccount(iban)) 
		   accounts.add(account);
	}
	// getAccount(int index) -> Account
	// getAccount(String iban) -> Account
	// getAccounts() -> List<Account>
	// getNumberOfAccounts() -> int
	// existsAccount(String iban) -> boolean
	// removeAccount(String iban)
	// removeAccount(Account)
	// getTotalBalance() -> double
	
}
