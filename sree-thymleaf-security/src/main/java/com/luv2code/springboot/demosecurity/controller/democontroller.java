package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class democontroller {
    @GetMapping("/")
    public String showForm() {
        return "threepage";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admins";
    }
    @GetMapping("/buyer")
    public String buyer() {
        return "buyers";
    }
    @GetMapping("/sellers")
    public String seller() {
        return "sellers";
    }
}
