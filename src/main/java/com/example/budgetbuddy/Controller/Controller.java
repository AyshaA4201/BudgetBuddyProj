package com.example.budgetbuddy.Controller;

import com.example.budgetbuddy.DTO.TransferDTO;
import com.example.budgetbuddy.DTO.UserDTO;
import com.example.budgetbuddy.Models.User;
import com.example.budgetbuddy.Services.Services;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.xml.ws.Response;

import static org.springframework.http.ResponseEntity.ok;

@RequestMapping
@RestController
public class Controller {
    Services services = new Services();

    @PostMapping(path="createUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody UserDTO user){
        return ResponseEntity.ok(services.createUser(user));
    }

    @PostMapping(path="createAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAccount(@RequestBody UserDTO user) {
        return ResponseEntity.ok(services.createAccount(user));
    }

    @PostMapping(path="transactions",consumes =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> makeTransaction(@RequestBody TransferDTO transferDTO){
        return ResponseEntity.ok(services.makeTransfer(transferDTO));
    }

    @PostMapping(path="viewAccounts", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllAccounts(@RequestBody UserDTO username){
        return ResponseEntity.ok(services.listAllMyAccounts(username.getUsername()));
    }

}
