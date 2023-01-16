package com.company.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final String HOME = "index";

    @GetMapping("/")
    public String goToHomePage(){
        return HOME;
    }
}
