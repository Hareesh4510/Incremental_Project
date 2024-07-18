package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.CustomerService;
import com.wecp.progressive.service.CustomerServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() throws SQLException {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId) throws SQLException {
     return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
    @PostMapping
    public ResponseEntity<Integer> addCustomer(@RequestBody Customers customers) throws SQLException {
        return ResponseEntity.ok(customerService.addCustomer(customers));
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable int customerId,@RequestBody Customers customers) throws SQLException {
        customerService.updateCustomer(customers);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) throws SQLException {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    
}
