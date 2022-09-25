package com.example.budgetbuddy.Services;

import com.example.budgetbuddy.DTO.TransferDTO;
import com.example.budgetbuddy.DTO.UserDTO;
import com.example.budgetbuddy.Data.Users;
import com.example.budgetbuddy.Models.Account;
import com.example.budgetbuddy.Models.Transaction;
import com.example.budgetbuddy.Models.User;
import org.springframework.stereotype.Service;

@Service
public class Services {
    Users users = new Users();
    public String createUser(UserDTO userDTO){
        User user = new User(userDTO.getUsername());
        Account account = new Account(userDTO.getBalance());
        user.addAccount(account);
        users.saveUser(user);
        return "hi " + user.getUsername()+".\nYour new account number is: "+
                account.getAccountId() +".\nAnd your balance is: "
                + account.getBalance();
    }

    public String createAccount(UserDTO userDTO){
        User user = users.getUserByUsername(userDTO.getUsername());
        Account account = new Account(userDTO.getBalance());
        user.addAccount(account);
        return "New account created.\nThe account ID is: "+ account.getAccountId() +
                "\nAnd the account balance is: " + account.getBalance();
    }

    public String makeTransfer(TransferDTO transferDTO){
        User user = users.getUserByUsername(transferDTO.getUsername());
        Account account = user.getAccount(transferDTO.getAccountNumber());
        Transaction transaction = new Transaction(transferDTO);
        account.makeTransaction(transaction);
        return "You have made a transaction of " + transaction.getAmount() + " from your account "
                + transaction.getAccountId() +".\n Your new balance in that account is: "+
        account.getBalance();
    }

    public String listAllMyAccounts(String username){
        User user = users.getUserByUsername(username);
        String accounts = user.getAccounts().toString();
        return accounts;
    }

}
