package com.chtti.springbooot.demo.Demo7JPADocker.controller;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Customer;
import com.chtti.springbooot.demo.Demo7JPADocker.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRestController.class.getSimpleName());
    @Autowired
    private CustomerService service;
    @GetMapping("/api/customers")
    public List<Customer>  getCustomers(){
        List<Customer> customers = service.retrieveCustomers();
        return customers;
    }
    @GetMapping("/api/customers/{customerId}")
    public Customer getCustomer(@PathVariable(name="customerId") Integer customerId){
        return service.getCustomer(customerId);
    }
    @PostMapping("/api/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(Customer customer){
        service.saveCustomer(customer);
        LOGGER.info("{} saved successfully.",customer);
        return customer;
    }
    @DeleteMapping("/api/customers/{customerId}")
    //@ResponseStatus(HttpStat)
    public void deleteCustomer(@PathVariable(name="customerId") Integer customerId){
        service.deleteCustomer(customerId);
        LOGGER.info("{} id delete successfully.",customerId);
    }
    @PutMapping("/api/customers/{customerId}")
    public void updateCustomer(@RequestBody Customer customer,
                               @PathVariable(name="customerId")Integer customerId){
        customer.setId(customerId);
        service.updateCustomer(customer);
        LOGGER.info("{} has been updated.",customer);
    }
}
