package com.chtti.springbooot.demo.Demo7JPADocker.controller;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Customer;
import com.chtti.springbooot.demo.Demo7JPADocker.forms.CustomerForm;
import com.chtti.springbooot.demo.Demo7JPADocker.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    CustomerService service;

    @ModelAttribute
    CustomerForm setupForm(){
        return new CustomerForm();
    }

    @RequestMapping(value="/customers/create", method = RequestMethod.POST)
    String create(@Validated CustomerForm form, BindingResult result,Model model){
        if(result.hasErrors()) {
            return listAll(model);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(form,customer);
        service.saveCustomer(customer);
        return "redirect:/customers";
    }

    @RequestMapping(value= "customers",
            method= RequestMethod.GET)
    String listAll(Model model){
        model.addAttribute("customers",service.retrieveCustomers());
        return "customers/list";
    }

    @RequestMapping(value="/customers/delete",method=RequestMethod.POST)
    String delete(@RequestParam Integer id){
        service.deleteCustomer(id);
        return "redirect:/customers";

    }
}
