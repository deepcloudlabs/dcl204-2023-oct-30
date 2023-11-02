package com.example.banking.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class Bank {
	private final int bddkId;
	private String commercialName;
	private final Map<String, Customer> customers;

	// Constructors
	public Bank(int bddkId, String commercialName) {
		this.bddkId = bddkId;
		this.commercialName = commercialName;
		customers = new HashMap<>();
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
		return List.copyOf(customers.values());
	}

	// business methods:
	public Customer createCustomer(String identityNo, String fullName) {
		var customer = new Customer(identityNo, fullName);
		this.customers.put(identityNo, customer);
		return customer;
	}

	public Optional<Customer> findCustomer(String identityNo) {
		return Optional.ofNullable(customers.get(identityNo));
	}

	public double getTotalBalance() {
		var total = 0.0;
		for (var customer : customers.values())
			total += customer.getTotalBalance();
		return total;
	}

	public Optional<Account> findAccount(String iban) {
		for (var customer : customers.values()) {
			var account = customer.getAccount(iban);
			if (account.isPresent())
				return account;
		}
		return Optional.empty();
	}

	public Optional<Customer> removeCustomer(String identityNo) {
		var customer = findCustomer(identityNo);
		if (customer.isPresent())
			customers.remove(identityNo);
		return customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bddkId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return this.bddkId == other.bddkId;
	}

}
