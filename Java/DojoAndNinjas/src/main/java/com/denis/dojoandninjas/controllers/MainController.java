package com.denis.dojoandninjas.controllers;

import com.denis.dojoandninjas.models.Dojo;
import com.denis.dojoandninjas.models.Ninja;
import com.denis.dojoandninjas.services.DojoService;
import com.denis.dojoandninjas.services.NinjaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    NinjaService ninjaService;

    @Autowired
    DojoService dojoService;


    //Get Routes

    @GetMapping("/dojos/new")
    public String dojoIndex(@ModelAttribute("dojo") Dojo dojo){
        return "NewDojo";
    }

    @GetMapping("/ninjas/new")
    public String ninjaIndex(@ModelAttribute("ninja") Ninja ninja, Model model){
        model.addAttribute("dojos", dojoService.allDojos());
        return "NewNinja";
    }

    @GetMapping("/dojos/{dojoId}")
    public String show(@PathVariable("dojoId") Long id, Model model){
        Dojo dojo = dojoService.findDojo(id);

        model.addAttribute("dojo", dojo);
        return "show";
    }

    //Post Routes

    @PostMapping("/dojos/new")
    public String postDojo(@Valid @ModelAttribute("dojo")Dojo dojo,
                           BindingResult result){
        if(result.hasErrors()){
            return "NewDojo";
        }
        else{
            dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
    }

    @PostMapping("ninjas/new")
    public String postNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
                            BindingResult result){
        if(result.hasErrors()){
            return "NewNinja";
        }
        else{
            ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }
}
