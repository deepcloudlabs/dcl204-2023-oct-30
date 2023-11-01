package com.example.banking.domain;

import java.util.List;

public final class Bank {
	private final int bddkId;
	private String commercialName;
	private List<Customer> customers;
	// Constructors
	// setter/getter
	// business methods: 
	// Customer createCustomer(String identityNo, String fullName)
	// Optional<Customer> findCustomer(String identityNo)
	// Optional<Customer> removeCustomer(String identityNo)
	// double getTotalBalance()
	// Optional<Account> getAccount(String iban)
}
