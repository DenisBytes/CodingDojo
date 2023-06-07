package com.denis.burgertracker.controllers;

import com.denis.burgertracker.models.Burger;
import com.denis.burgertracker.services.BurgerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
                            BindingResult result, Model model){
        if(result.hasErrors()){
            List<Burger> burgerList = burgerService.allBurgers();
            model.addAttribute("burgers",burgerList);
            return "index";
        }
        burgerService.createBurger(burger);
        return "redirect:/";
    }

    @GetMapping("/burgers/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Burger burger = burgerService.findBurger(id);
        model.addAttribute("burger",burger);
        return "edit";
    }

    @PutMapping("/burgers/{id}")
    public String update (@Valid @ModelAttribute("burger") Burger burger,
                          BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("burger",burger);
            return "edit";
        }
        else{
            burgerService.updateBurger(burger);
            return "redirect:/";
        }
    }

}
