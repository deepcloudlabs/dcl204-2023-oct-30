package com.example.banking.domain;

import java.util.*;

public class Customer {
    private final String identityNo;
    private String fullName;
    private List<Account> accounts = new ArrayList<>();

    // Constructor -> identityNo (getter), fullName(getter/setter)

    public Customer(String identityNo, String fullName) {
        this.identityNo = identityNo;
        this.fullName = fullName;
    }

    //region getter/setter
    public String getIdentityNo() {
        return identityNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    //endregion

    public void addAccount(Account account) {
        String iban = account.getIban();
        if (!this.existsAccount(iban))
            accounts.add(account);
    }

    public boolean existsAccount(String iban) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban))
                return true;
        }
        return false;
    }

    public int getNumberOfAccounts() {
        return this.accounts.size();
    }

    public Optional<Account> getAccount(int index) {
        if (index < 0) return Optional.empty();
        if (index >= this.accounts.size()) return Optional.empty();
        return Optional.of(this.accounts.get(index));
    }

    public Optional<Account> getAccount(String iban) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban))
                return Optional.of(account);
        }
        return Optional.empty();
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(this.accounts);
    }

    public Optional<Account> removeAccount(String iban) {
        Optional<Account> foundAccount = getAccount(iban);
        if (foundAccount.isPresent()) {
            this.accounts.remove(foundAccount.get());
        }
        return foundAccount;
    }

    public Optional<Account> removeAccount(Account account) {
        if (this.accounts.remove(account))
            return Optional.of(account);
        return Optional.empty();
    }

    public double getTotalBalance() {
        double totalBalance = 0.0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
}
