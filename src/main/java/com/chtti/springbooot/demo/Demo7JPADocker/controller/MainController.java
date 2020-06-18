package com.chtti.springbooot.demo.Demo7JPADocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(value = "/")
    public String main(){
        return "index";
    }
}
