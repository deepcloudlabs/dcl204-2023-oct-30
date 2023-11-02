package com.example.banking.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Customer {
	private final String identityNo;
	private String fullName;
	private final Map<String, Account> accounts = new HashMap<>();
	private final List<Account> accountList = new ArrayList<>();

	// Constructor -> identityNo (getter), fullName(getter/setter)

	Customer(String identityNo, String fullName) {
		this.identityNo = identityNo;
		this.fullName = fullName;
	}

	// region getter/setter
	public String getIdentityNo() {
		return identityNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	// endregion

	public void addAccount(Account account) {
		String iban = account.getIban();
		if (!this.existsAccount(iban)) {
			this.accounts.put(iban, account);
			this.accountList.add(account);
		}
	}

	public boolean existsAccount(String iban) {
		return accounts.containsKey(iban);
	}

	public int getNumberOfAccounts() {
		return this.accounts.size();
	}

	public Optional<Account> getAccount(int index) {
		if (index < 0)
			return Optional.empty();
		if (index >= this.accountList.size())
			return Optional.empty();
		return Optional.of(this.accountList.get(index));
	}

	public Optional<Account> getAccount(String iban) {
		return Optional.ofNullable(accounts.get(iban));
	}

	public List<Account> getAccounts() {
		return List.copyOf(this.accounts.values());
	}

	public Optional<Account> removeAccount(String iban) {
		Optional<Account> foundAccount = getAccount(iban);
		if (foundAccount.isPresent()) {
			this.accounts.remove(iban);
			this.accountList.remove(foundAccount.get());
		}
		return foundAccount;
	}

	public Optional<Account> removeAccount(Account account) {
		final var iban = account.getIban();
		if (this.accounts.containsKey(iban)) {
			this.accounts.remove(account.getIban());
			this.accountList.remove(account);
			return Optional.of(account);
		}
		return Optional.empty();
	}

	public double getTotalBalance() {
		double totalBalance = 0.0;
		for (Account account : accounts.values()) {
			totalBalance += account.getBalance();
		}
		return totalBalance;
	}
}
