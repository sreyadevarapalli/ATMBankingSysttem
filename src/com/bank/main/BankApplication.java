package com.bank.main;

import java.util.Scanner;

import com.bank.model.Account;
import com.bank.service.*;
import com.bank.exception.*;

public class BankApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankService bankService =
                new BankService();

        SerializationService fileService =
                new SerializationService();

        bankService.setAccounts(
                fileService.loadAccounts());

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");

            System.out.println("1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Check Balance");
            System.out.println("5.Transfer Money");
            System.out.println("6.Display All Accounts");
            System.out.println("7.Exit");

            choice = sc.nextInt();

            try {

                switch(choice) {

                case 1:

                    System.out.print(
                            "Account Number : ");
                    int accNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Account Holder : ");
                    String name =
                            sc.nextLine();

                    System.out.print(
                            "Initial Balance : ");
                    double bal =
                            sc.nextDouble();

                    bankService.createAccount(
                            new Account(
                                    accNo,
                                    name,
                                    bal));

                    System.out.println(
                            "Account Created");
                    break;

                case 2:

                    System.out.print(
                            "Account Number : ");
                    accNo = sc.nextInt();

                    System.out.print(
                            "Amount : ");
                    double dep =
                            sc.nextDouble();

                    bankService.deposit(
                            accNo, dep);

                    System.out.println(
                            "Deposit Success");
                    break;

                case 3:

                    System.out.print(
                            "Account Number : ");
                    accNo = sc.nextInt();

                    System.out.print(
                            "Amount : ");
                    double wd =
                            sc.nextDouble();

                    bankService.withdraw(
                            accNo, wd);

                    System.out.println(
                            "Withdrawal Success");
                    break;

                case 4:

                    System.out.print(
                            "Account Number : ");
                    accNo = sc.nextInt();

                    System.out.println(
                            bankService.findAccount(accNo));

                    break;

                case 5:

                    System.out.print(
                            "From Account : ");
                    int from =
                            sc.nextInt();

                    System.out.print(
                            "To Account : ");
                    int to =
                            sc.nextInt();

                    System.out.print(
                            "Amount : ");
                    double amount =
                            sc.nextDouble();

                    bankService.transfer(
                            from,
                            to,
                            amount);

                    System.out.println(
                            "Transfer Successful");

                    break;

                case 6:

                    bankService.displayAllAccounts();
                    break;

                case 7:

                    fileService.saveAccounts(
                            bankService.getAccounts());

                    System.out.println(
                            "Thank You");
                    break;

                default:
                    System.out.println(
                            "Invalid Choice");
                }

            } catch(Exception e) {

                System.out.println(
                        e.getMessage());
            }

        } while(choice != 7);

        sc.close();
    }
}