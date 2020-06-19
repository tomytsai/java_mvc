package com.chtti.springbooot.demo.Demo7JPADocker.repository;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDemoRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT x from Customer x ORDER BY x.lastName, x.firstName")
    List<Customer> findAllOrderByName();
}
