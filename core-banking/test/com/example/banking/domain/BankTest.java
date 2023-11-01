package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class BankTest {

	@Test
	void createCustomer() {
		var bank = new Bank(1,"denizbank");
		var jack = bank.createCustomer("1", "jack bauer");
		var kate = bank.createCustomer("2", "kate austen");
		assertAll(
			() ->	assertEquals(2, bank.getCustomers().size()),
			() ->	assertEquals("1", jack.getIdentityNo()),
			() ->	assertEquals("jack bauer", jack.getFullName()),
			() ->	assertEquals("2", kate.getIdentityNo()),
			() ->	assertEquals("kate austen", kate.getFullName())
		);
	}
	
	@Test
	void findCustomerSuccessfully() {
		var bank = new Bank(1,"denizbank");
		var jack = bank.createCustomer("1", "jack bauer");
		var kate = bank.createCustomer("2", "kate austen");
		Optional<Customer> customer1 = bank.findCustomer("1");
		Optional<Customer> customer2 = bank.findCustomer("2");
		assertAll(
			() -> assertTrue(customer1.isPresent()),
			() -> assertEquals(jack.getIdentityNo(),customer1.get().getIdentityNo()),
			() -> assertTrue(customer2.isPresent()),
			() -> assertEquals(kate.getIdentityNo(),customer2.get().getIdentityNo())
		);
		
	}
	
	@Test
	void getTotalBalanceSuccessfullyReturns() {
		var bank = new Bank(1,"denizbank");
		var jack = bank.createCustomer("1", "jack bauer");
		jack.addAccount(new Account("1",100_000));
		jack.addAccount(new CheckingAccount("2",200_000,5_000));
		var kate = bank.createCustomer("2", "kate austen");
		kate.addAccount(new Account("3",300_000));
		kate.addAccount(new CheckingAccount("4",400_000,50_000));
		var totalBalance = bank.getTotalBalance();
		assertEquals(1_000_000,totalBalance);		
	}
	
	@Test
	void removeCustomerByIdentitySuccessfullyReturns() {
		var bank = new Bank(1,"denizbank");
		var jack = bank.createCustomer("1", "jack bauer");
		var kate = bank.createCustomer("2", "kate austen");
		assertEquals(2, bank.getCustomers().size());
		var customer1 = bank.removeCustomer(jack.getIdentityNo());
		assertAll(
			() -> assertEquals(1, bank.getCustomers().size()),
			() -> assertTrue(customer1.isPresent()),
			() -> assertEquals(jack.getIdentityNo(),customer1.get().getIdentityNo())
		);		
		var customer2 = bank.removeCustomer(kate.getIdentityNo());
		assertAll(
			() -> assertEquals(0, bank.getCustomers().size()),
			() -> assertTrue(customer2.isPresent()),
			() -> assertEquals(kate.getIdentityNo(),customer2.get().getIdentityNo())
		);		
	}
	
	@Test
	void findAccountByIbanSuccessfully() {
		var bank = new Bank(1,"denizbank");
		var jack = bank.createCustomer("1", "jack bauer");
		jack.addAccount(new Account("1",100_000));
		jack.addAccount(new CheckingAccount("2",200_000,5_000));
		var kate = bank.createCustomer("2", "kate austen");
		kate.addAccount(new Account("3",300_000));
		kate.addAccount(new CheckingAccount("4",400_000,50_000));
		var account1 = bank.findAccount("1");
		var account2 = bank.findAccount("2");
		var account3 = bank.findAccount("3");
		var account4 = bank.findAccount("4");
		assertAll(
			() -> assertTrue(account1.isPresent()),	
			() -> assertTrue(account2.isPresent()),	
			() -> assertTrue(account3.isPresent()),	
			() -> assertTrue(account4.isPresent()),	
			() -> assertEquals("1",account1.get().getIban()),		
			() -> assertEquals("2",account2.get().getIban()),		
			() -> assertEquals("3",account3.get().getIban()),		
			() -> assertEquals("4",account4.get().getIban())		
		);
	}

}
