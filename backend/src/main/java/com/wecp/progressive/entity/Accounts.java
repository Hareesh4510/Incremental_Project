package com.wecp.progressive.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Accounts {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private Integer customerId;
    private Double balance;
    
    @OneToMany(mappedBy = "accounts",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Transactions>transactions;

    @ManyToOne
    private Customers customers;
    
    public Accounts(Integer accountId, Integer customerId, Double balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
    }
    public Accounts() {
    }
    
    public Integer getAccountId() {
        return accountId;
    }
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public List<Transactions> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
    public Customers getCustomers() {
        return customers;
    }
    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    
    

}