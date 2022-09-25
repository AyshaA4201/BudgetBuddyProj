package com.example.budgetbuddy.DTO;

import com.example.budgetbuddy.Models.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransferDTO {
    String username;
    int moneyTransferred;
    int accountNumber;
    int relevanceNumber;
}
