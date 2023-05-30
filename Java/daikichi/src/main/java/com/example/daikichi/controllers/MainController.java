package com.example.daikichi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/hbar")
    public String hedera(){
        return "index";
    }
}
