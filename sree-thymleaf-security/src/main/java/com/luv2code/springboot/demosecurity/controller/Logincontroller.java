package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Logincontroller {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "loginpage";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
    // completed successfully comleted 
    
}
