package com.example.hopperreceipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String world(Model model){
        String name = "Leemon Braid";
        String itemName = "$HBAR token";
        double price = 0.06;
        String description = "Hedera Hashgraph";
        String vendor = "HashPack Wallet";

        model.addAttribute("customerName",name);
        model.addAttribute("itemName",itemName);
        model.addAttribute("itemPrice",price);
        model.addAttribute("itemDescription",description);
        model.addAttribute("vendor",vendor);

        return "index";
    }
}
