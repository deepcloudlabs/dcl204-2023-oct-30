package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class Bank {
	private final int bddkId;
	private String commercialName;
	private final List<Customer> customers;

	// Constructors
	public Bank(int bddkId, String commercialName) {
		this.bddkId = bddkId;
		this.commercialName = commercialName;
		customers = new ArrayList<>();
	}
	// setter/getter

	public String getCommercialName() {
		return commercialName;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

	public int getBddkId() {
		return bddkId;
	}

	public List<Customer> getCustomers() {
		return Collections.unmodifiableList(this.customers);
	}

	// business methods:
	public Customer createCustomer(String identityNo, String fullName) {
		var customer = new Customer(identityNo, fullName);
		this.customers.add(customer);
		return customer;
	}

	public Optional<Customer> findCustomer(String identityNo) {
		for (var customer : customers)
			if (customer.getIdentityNo().equals(identityNo))
				return Optional.of(customer);
		return Optional.empty();
	}

	public double getTotalBalance() {
		var total = 0.0;
		for (var customer : customers)
			total += customer.getTotalBalance();
		return total;
	}

	public Optional<Account> findAccount(String iban) {
		for (var customer : customers) {
			var account = customer.getAccount(iban);
			if (account.isPresent())
				return account;
		}
		return Optional.empty();
	}

	public Optional<Customer> removeCustomer(String identityNo) {
		var customer = findCustomer(identityNo);
		if (customer.isPresent())
			customers.remove(customer.get());
		return customer;
	}

}
