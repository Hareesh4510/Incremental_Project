package com.wecp.progressive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.exception.AccountNotFoundException;
import com.wecp.progressive.repository.AccountRepository;

@Service
public class AccountServiceImplJpa {
    @Autowired
    private AccountRepository accountRepository;
    public List<Accounts>getAllAccounts()
    {
        List<Accounts> list=accountRepository.findAll();
        return list;
    }
    public Accounts getAccountById(Integer accountId)
    {
        Accounts a=accountRepository.findById(accountId).get();
        if(a==null)
        {
            throw new AccountNotFoundException("Account Not Found");
        }
        return a;
    }
    public Accounts getAccountsByUser(Integer CustomerId)
    {
        return accountRepository.findById(CustomerId).get();
    }
    public Integer addAccount(Accounts acc)
    {
        accountRepository.save(acc);
        return acc.getAccountId();
    }
    public void updateAccount(Integer accountId,Accounts acc)
    {
        Accounts a=accountRepository.findById(accountId).get();
        if(a!=null)
        {
         accountRepository.save(acc);
        }
        
    }
    public void deleteAccount(Integer accountId)
    {
    if(accountId==null)
    {
        throw new AccountNotFoundException("Account Not Found");
    }
    accountRepository.deleteById(accountId);
}
    
   
    
}