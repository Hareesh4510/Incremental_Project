package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.repository.CustomerRepository;
import com.wecp.progressive.repository.TransactionRepository;

@Service
public class CustomerServiceImplJpa implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customerRepository.findAll();
    }
    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        customerRepository.save(customers);
        return customers.getCustomerId();
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        // TODO Auto-generated method stub
        customerRepository.save(customers);
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        // TODO Auto-generated method stub
        customerRepository.deleteById(customerId);
    }
    // @Override
    // public List<Customers> getAllCustomersSortedByName() throws SQLException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByName'");
    // }
    // @Override
    // public Customers getCustomerById(int customerId) throws SQLException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getCustomerById'");
    // }
    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByName'");
    }
    @Override
    public List<Customers> getAllCustomersFromArrayList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersFromArrayList'");
    }
    @Override
    public List<Customers> addCustomersToArrayList(Customers customers) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCustomersToArrayList'");
    }
    @Override
    public List<Customers> getAllCustomersSortedByNameFromArrayList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByNameFromArrayList'");
    }
    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emptyArrayList'");
    }

    // @Override
    // public List<Customers> getAllCustomersSortedByName() throws SQLException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByName'");
    // }

    // @Override
    // public List<Customers> getAllCustomersFromArrayList() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersFromArrayList'");
    // }

    // @Override
    // public List<Customers> addCustomersToArrayList(Customers customers) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'addCustomersToArrayList'");
    // }

    // @Override
    // public List<Customers> getAllCustomersSortedByNameFromArrayList() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAllCustomersSortedByNameFromArrayList'");
    // }

    // @Override
    // public void emptyArrayList() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'emptyArrayList'");
    // }
    
    
    
    
}