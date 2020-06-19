package com.chtti.springbooot.demo.Demo7JPADocker.service;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Customer;
import com.chtti.springbooot.demo.Demo7JPADocker.repository.CustomerDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDemoRepository repository;

    @Override
    public List<Customer> retrieveCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        Optional<Customer> mbCustomer = repository.findById(customerId);
        return mbCustomer.get();
    }

    @Override
    public void saveCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        repository.deleteById(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        repository.save(customer);
    }
}
