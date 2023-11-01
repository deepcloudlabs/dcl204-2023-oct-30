package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

import java.util.concurrent.ThreadLocalRandom;

public class StudyPolymorphism {
    public static void main(String[] args) {
        Account account;
        if (ThreadLocalRandom.current().nextBoolean())
            account = new Account("tr1", 100_000);
        else
            account = new CheckingAccount("tr2", 100_000,5_000);
        System.out.println(account.getClass().getSimpleName());
        account.withdraw(75_000);
    }
}
