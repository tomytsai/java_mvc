package com.chtti.springbooot.demo.Demo7JPADocker.service;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Customer;

import java.util.List;

public interface CustomerService {
    //get all
    List<Customer> retrieveCustomers();
    Customer getCustomer(Integer customerId);
    void saveCustomer(Customer customer);
    void deleteCustomer(Integer customerId);
    void updateCustomer(Customer customer);
}
