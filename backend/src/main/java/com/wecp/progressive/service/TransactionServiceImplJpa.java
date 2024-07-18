package com.wecp.progressive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.repository.CustomerRepository;
import com.wecp.progressive.repository.TransactionRepository;

@Service
public class TransactionServiceImplJpa {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<Transactions>getAllTransactions()
    {
        return transactionRepository.findAll();
    }
    public Transactions getTransactionById(int transactionId)
    {
        return transactionRepository.findById(transactionId).get();
    }
    public Integer addTransaction (Transactions transaction)
    {
        transactionRepository.save(transaction);
        return transaction.getTransactionId();
    }
    public void updateTransaction(int transactionId, Transactions transaction)
    {
        Transactions t=transactionRepository.findById(transactionId).get();
        if(t!=null)
        {
            transactionRepository.save(transaction);
        }
    }
    public void deleteTransaction(int transactionId)
    {
        transactionRepository.deleteById(transactionId);
    }
    public List<Transactions>getAllTransactionsByCustomerId(Integer customerId)
    {
        Customers c =customerRepository.findById(customerId).get();
        if(c!=null)
        {
            return transactionRepository.findAll();
        }
        return null;
    }

}
