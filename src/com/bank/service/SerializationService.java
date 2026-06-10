package com.bank.service;

import java.io.*;
import java.util.ArrayList;

import com.bank.model.Account;

public class SerializationService {

    private static final String FILE_NAME =
            "accounts.ser";

    public void saveAccounts(
            ArrayList<Account> accounts) {

        try(ObjectOutputStream oos =
                new ObjectOutputStream(
                new FileOutputStream(FILE_NAME))) {

            oos.writeObject(accounts);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Account> loadAccounts() {

        try(ObjectInputStream ois =
                new ObjectInputStream(
                new FileInputStream(FILE_NAME))) {

            return (ArrayList<Account>)
                    ois.readObject();

        } catch(Exception e) {
            return new ArrayList<>();
        }
    }
}