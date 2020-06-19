package com.chtti.springbooot.demo.Demo7JPADocker.controller;

import com.chtti.springbooot.demo.Demo7JPADocker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    @Autowired
    CustomerService service;
    @RequestMapping(value= "customers",
            method= RequestMethod.GET)
    String listAllP(Model model){
        model.addAttribute("customers",service.retrieveCustomers());
        return "customers/list";
    }
}
