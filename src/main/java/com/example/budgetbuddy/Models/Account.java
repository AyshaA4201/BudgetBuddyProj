package com.example.budgetbuddy.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@ToString
public class Account {

    int balance;
    int accountId;
    List<Transaction> transactions = new ArrayList<>();

    public Account (int balance){
        this.balance = balance;
        Random r = new Random();
        this.accountId = r.nextInt(9999-1000)+1000;
    }

    public int createAccount(int balance){
        this.balance = balance;
        Random r = new Random();
        this.accountId = r.nextInt(9999-1000)+1000;
        return accountId;
    }

    public void makeTransaction(Transaction transaction){
        balance += transaction.getAmount();
        transactions.add(transaction);
    }
}
