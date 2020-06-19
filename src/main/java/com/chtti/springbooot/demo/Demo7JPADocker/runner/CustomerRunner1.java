package com.chtti.springbooot.demo.Demo7JPADocker.runner;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Customer;
import com.chtti.springbooot.demo.Demo7JPADocker.repository.CustomerDemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CustomerRunner1 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner1.class.getSimpleName());
    @Autowired
    CustomerDemoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        initSampleData();
    }

    private void initSampleData(){
        LOGGER.info("init sample data for customers");
        Customer c1 = repository.save(new Customer(null,"Mark","Ho"));
        LOGGER.info("create 1 record:{}",c1);
        repository.save(new Customer(null,"Peter","Ho"));
        repository.save(new Customer(null,"Mark","Chen"));
        repository.save(new Customer(null,"Patty","Chen"));
        repository.save(new Customer(null,"John","Ho"));
        repository.save(new Customer(null,"John","Chang"));
        repository.save(new Customer(null,"Jimmy","Lee"));
        repository.save(new Customer(null,"Chloe","Wang"));
        repository.save(new Customer(null,"Mark","Ho"));
    }
}
