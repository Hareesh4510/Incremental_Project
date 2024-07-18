package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountServiceImpl;
import com.wecp.progressive.service.AccountServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {
@Autowired
private AccountServiceImplJpa accountServiceImplJpa;
    @GetMapping   
    public ResponseEntity<List<Accounts>> getAllAccounts() {
        return ResponseEntity.ok(accountServiceImplJpa.getAllAccounts());
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<Accounts> getAccountById(int accountId) {
        return ResponseEntity.ok(accountServiceImplJpa.getAccountById(accountId));
    }
    // @GetMapping("/user/{customerId}")
    // public ResponseEntity<List<Accounts>> getAccountsByUser(String param) {
    //     return ResponseEntity.ok(accountServiceImplJpa.getAccountsByUser());
    // }
    @PostMapping
    public ResponseEntity<Integer> addAccount(Accounts accounts) {
        return new ResponseEntity<>(accountServiceImplJpa.addAccount(accounts),HttpStatus.CREATED);
    }
    @PutMapping("/{accountId}")
    public ResponseEntity<Void> updateAccount(int accountId, Accounts accounts) {
       return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(int accountId) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}