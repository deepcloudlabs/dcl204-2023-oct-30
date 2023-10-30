package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

// CUT (Class under Test): Account
// MUT (Method under Test): withdraw, deposit, ...
class AccountTest {
	
	@DisplayName("Deposit with negative amount should return false")
	@ParameterizedTest
	@CsvFileSource(resources = "deposit_negative.csv")
	void deposit_negative_amount_should_return_false(double amount) {
		// 1. test setup/fixture
		var acc = new Account("tr1", 1_000);
		// 2. call exercise method: deposit
		var result = acc.deposit(amount);
		// 3. verification
		assertAll(
			() -> assertFalse(result),
		    () -> assertEquals(1_000, acc.getBalance())
		);
		// 4. tear down
		// Garbage Collected Heap
	}
	
	@DisplayName("Withdraw with negative amount should return false")
	@ParameterizedTest
	@CsvFileSource(resources = "withdraw_negative.csv")
	void withdraw_negative_amount_should_return_false(double amount) {
		// 1. test setup/fixture
		var acc = new Account("tr1", 1_000);
		// 2. call exercise method: deposit
		var result = acc.withdraw(amount);
		// 3. verification
		assertAll(
				() -> assertFalse(result),
				() -> assertEquals(1_000, acc.getBalance())
				);
		// 4. tear down
		// Garbage Collected Heap
	}
	
	@DisplayName("Deposit with positive amount should return true")
	@ParameterizedTest
	@CsvFileSource(resources = "deposit_positive.csv")
	void deposit_positive_amount_should_return_true(double initBalance,double amount,double finalBalance) {
		// 1. test setup/fixture
		var acc = new Account("tr1", initBalance);
		// 2. call exercise method: deposit
		var result = acc.deposit(amount);
		// 3. verification
		assertAll(
				() -> assertTrue(result),
				() -> assertEquals(finalBalance, acc.getBalance())
				);
		// 4. tear down
		// Garbage Collected Heap
	}

	@DisplayName("Withdraw over balance should return false")
	@ParameterizedTest
	@CsvFileSource(resources = "withdraw_over_balance.csv")
	void withdraw_over_balance_should_return_false(double initBalance,double amount) {
		// 1. test setup/fixture
		var acc = new Account("tr1", initBalance);
		// 2. call exercise method: deposit
		var result = acc.withdraw(amount);
		// 3. verification
		assertAll(
				() -> assertFalse(result),
				() -> assertEquals(initBalance, acc.getBalance())
				);
		// 4. tear down
		// Garbage Collected Heap
	}
	
	
	@DisplayName("Withdraw less than or all balance should return true")
	@ParameterizedTest
	@CsvFileSource(resources = "withdraw_under_balance.csv")
	void withdraw_over_balance_should_return_false(double initBalance,double amount,double finalBalance) {
		// 1. test setup/fixture
		var acc = new Account("tr1", initBalance);
		// 2. call exercise method: deposit
		var result = acc.withdraw(amount);
		// 3. verification
		assertAll(
				() -> assertTrue(result),
				() -> assertEquals(finalBalance, acc.getBalance(),0.001)
				);
		// 4. tear down
		// Garbage Collected Heap
	}
	
}
