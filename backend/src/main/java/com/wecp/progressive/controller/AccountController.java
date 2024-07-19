package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;
import com.wecp.progressive.service.AccountServiceImpl;
import com.wecp.progressive.service.AccountServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {
@Autowired
private AccountService accountService;
    @GetMapping   
    public ResponseEntity<List<Accounts>> getAllAccounts() throws SQLException {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @GetMapping("/{accountId}")
    public ResponseEntity<Accounts> getAccountById(@PathVariable int accountId) throws SQLException {
        return ResponseEntity.ok(accountService.getAccountById(accountId));
    }
    // @GetMapping("/user/{customerId}")
    // public ResponseEntity<List<Accounts>> getAccountsByUser(String param) {
    //     return ResponseEntity.ok(accountService.getAccountsByUser());
    // }
    @PostMapping
    public ResponseEntity<Integer> addAccount(@RequestBody Accounts accounts) throws SQLException {
        return new ResponseEntity<>(accountService.addAccount(accounts),HttpStatus.CREATED);
    }
    @PutMapping("/{accountId}")
    public ResponseEntity<Void> updateAccount(@RequestBody Accounts accounts) throws SQLException {
        accountService.updateAccount(accounts);
       return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int accountId) throws SQLException {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}