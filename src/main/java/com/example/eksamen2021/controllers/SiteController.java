package com.example.eksamen2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SiteController {

    @GetMapping("/terms")
    public String terms(){
        return "terms";
    }
}
