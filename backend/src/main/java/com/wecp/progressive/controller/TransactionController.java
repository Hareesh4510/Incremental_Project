package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.TransactionServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionServiceImplJpa transactionServiceImplJpa;
    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() {
        return ResponseEntity.ok(transactionServiceImplJpa.getAllTransactions());
    }
    @GetMapping("/{transactionId}")
    public ResponseEntity<Transactions> getTransactionById(int transactionId) {
        return ResponseEntity.ok(transactionServiceImplJpa.getTransactionById(transactionId));
    }
    @PostMapping
    public ResponseEntity<Integer> addTransaction(Transactions transaction) {
        return ResponseEntity.ok(transactionServiceImplJpa.addTransaction(transaction));
    }
    @PutMapping("/{transactionId}")
    public ResponseEntity<Void> updateTransaction(int transactionId, Transactions transaction) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    public ResponseEntity<Void> deleteTransaction(int transactionId) {
       return new ResponseEntity<Void>(HttpStatus.OK);
    }
    public ResponseEntity<List<Transactions>>getAllTransactionsByCustomerId(Integer customerId)
    {
        return ResponseEntity.ok(transactionServiceImplJpa.getAllTransactionsByCustomerId(customerId));
    }
}
