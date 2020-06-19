package com.chtti.springbooot.demo.Demo7JPADocker;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Customer;
import com.chtti.springbooot.demo.Demo7JPADocker.repository.CustomerDemoRepository;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MyUnitTest1 {
    @Autowired
    private CustomerDemoRepository repository;
    private static final int ALREADY_EXISTS_COUNT = 9;
    @BeforeEach
    public void prepare() {
        System.out.println("clear all data");
        repository.deleteAll();
    }
    @Test
    public void foo(){
        System.out.println("start to test foo");
        repository.save(new Customer(null,"Mark","Ho"));
        assertEquals(repository.count(),1);
    }
    @Test
    public void foo2(){
        System.out.println("start to test foo2");
        repository.save(new Customer(null,"Mark","Ho"));
        assertEquals(repository.count(),1);
    }
}
