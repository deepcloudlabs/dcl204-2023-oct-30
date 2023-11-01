package com.example.banking.domain;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CustomerTest.class, AccountTest.class, CheckingAccountTest.class, BankTest.class })
public class BankingTestSuite {

}
