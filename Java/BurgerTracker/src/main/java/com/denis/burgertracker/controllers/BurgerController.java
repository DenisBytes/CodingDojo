package com.denis.burgertracker.controllers;

import com.denis.burgertracker.models.Burger;
import com.denis.burgertracker.services.BurgerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BurgerController {
    @Autowired
    BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping("/")
    public String index(@ModelAttribute("burger") Burger burger,
                        Model model){
        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        return "index";
    }

    @PostMapping("/")
    public String elaborate(@Valid @ModelAttribute("burger") Burger burger,
                            BindingResult result){
        if(result.hasErrors()){
            return "index";
        }
        burgerService.createBurger(burger);
        return "redirect:/";
    }

}
