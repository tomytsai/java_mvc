package com.chtti.springbooot.demo.Demo7JPADocker.runner;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Customer;
import com.chtti.springbooot.demo.Demo7JPADocker.repository.CustomerDemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class CustomerRunner3 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner3.class.getSimpleName());
    @Autowired
    CustomerDemoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        printOrderd();
        printOrderdByPage();
    }

    private void printOrderd(){
        LOGGER.info("Print orderd data");
        repository.findAllOrderByName().forEach(customer -> LOGGER.info("[Order][All]:{}",customer));
    }


    private void printOrderdByPage() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Customer> customerPage1 = repository.findAllOrderByName(pageable);
        LOGGER.info("page size={}, current number={}, total page={}, total compoments={}",
                customerPage1.getSort(), customerPage1.getNumber(), customerPage1.getTotalPages(), customerPage1.getTotalElements());
        ;
        customerPage1.getContent().forEach(customer ->
                LOGGER.info("[{}],{}", customerPage1.getNumber(), customer));
        Page<Customer> customerPage2 = repository.findAllOrderByName(customerPage1.nextPageable());
        customerPage2.getContent().forEach(customer ->
                LOGGER.info("[{}],{}", customerPage2.getNumber(), customer));
    }
}
