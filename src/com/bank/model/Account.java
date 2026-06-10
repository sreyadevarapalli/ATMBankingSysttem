package com.bank.model;

import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber,
                   String accountHolderName,
                   double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account Number : " + accountNumber +
               "\nAccount Holder : " + accountHolderName +
               "\nBalance        : " + balance;
    }
}