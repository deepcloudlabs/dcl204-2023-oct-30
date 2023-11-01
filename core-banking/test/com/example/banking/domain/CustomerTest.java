package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {

	@Test
	void createCustomerSuccessfully() {
		var jack = new Customer("1", "jack bauer");
		assertAll(
			() -> assertEquals("1", jack.getIdentityNo()),
			() -> assertEquals("jack bauer", jack.getFullName()),
			() -> assertEquals(0, jack.getNumberOfAccounts())
		);
	}
	
	@Test
	void addCustomerSuccessfully() {
		var jack = new Customer("1", "jack bauer");
		jack.addAccount(new Account("tr1",100_000));
		jack.addAccount(new CheckingAccount("tr2",100_000,500));
		assertAll(
			() -> assertEquals(2, jack.getNumberOfAccounts())
		);
	}
}
