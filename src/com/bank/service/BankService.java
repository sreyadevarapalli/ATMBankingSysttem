package com.bank.service;

import java.util.ArrayList;

import com.bank.model.Account;
import com.bank.exception.*;

public class BankService {

    private ArrayList<Account> accounts =
            new ArrayList<>();

    public void createAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(int accNo)
            throws AccountNotFoundException {

        for(Account acc : accounts) {

            if(acc.getAccountNumber() == accNo) {
                return acc;
            }
        }

        throw new AccountNotFoundException(
                "Account Not Found");
    }

    public void deposit(int accNo, double amount)
            throws AccountNotFoundException {

        Account acc = findAccount(accNo);
        acc.deposit(amount);
    }

    public void withdraw(int accNo, double amount)
            throws Exception {

        Account acc = findAccount(accNo);

        if(acc.getBalance() < amount) {
            throw new InsufficientBalanceException(
                    "Insufficient Balance");
        }

        acc.withdraw(amount);
    }

    public void transfer(int from,
                         int to,
                         double amount)
            throws Exception {

        Account sender = findAccount(from);
        Account receiver = findAccount(to);

        if(sender.getBalance() < amount) {

            throw new InsufficientBalanceException(
                    "Insufficient Balance");
        }

        sender.withdraw(amount);
        receiver.deposit(amount);
    }

    public void displayAllAccounts() {

        for(Account acc : accounts) {
            System.out.println(acc);
            System.out.println("----------------");
        }
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}