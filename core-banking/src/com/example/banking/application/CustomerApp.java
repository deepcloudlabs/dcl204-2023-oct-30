package com.example.banking.application;


import com.example.banking.domain.Account;
import com.example.banking.domain.Bank;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.Customer;

public class CustomerApp {
    public static void main(String[] args) {
    	Bank denizbank = new Bank(1, "Denizbank");
        Customer jack = denizbank.createCustomer("11111111110", "jack bauer");
        jack.addAccount(new Account("tr1", 100_000));
        jack.addAccount(new CheckingAccount("tr2", 100_000,5_000));
        System.out.println(jack.getAccount("tr1").get());
        System.out.println(jack.getAccount("tr2").get());
    }
}
