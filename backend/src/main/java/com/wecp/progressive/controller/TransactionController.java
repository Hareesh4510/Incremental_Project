package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.TransactionService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() throws SQLException {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
    @GetMapping("/{transactionId}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable int transactionId) throws SQLException {
        return ResponseEntity.ok(transactionService.getTransactionById(transactionId));
    }
    @PostMapping
    public ResponseEntity<Integer> addTransaction(@RequestBody Transactions transaction) throws SQLException {
        return ResponseEntity.ok(transactionService.addTransaction(transaction));
    }
    @PutMapping("/{transactionId}")
    public ResponseEntity<Void> updateTransaction(@PathVariable int transactionId,@RequestBody Transactions transaction) throws SQLException {
        transactionService.updateTransaction(transaction);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable int transactionId) throws SQLException {
        transactionService.deleteTransaction(transactionId);
       return new ResponseEntity<Void>(HttpStatus.OK);
    }
    // public ResponseEntity<List<Transactions>>getAllTransactionsByCustomerId(Integer customerId)
    // {
    //     return ResponseEntity.ok(transactionService.getAllTransactionsByCustomerId(customerId));
    // }
}
