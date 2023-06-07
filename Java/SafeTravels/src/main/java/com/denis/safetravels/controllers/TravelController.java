package com.denis.safetravels.controllers;

import com.denis.safetravels.models.Travel;
import com.denis.safetravels.services.TravelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class TravelController {
    @Autowired
    TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("")
    public String index(@ModelAttribute("travel") Travel travel, Model model){
        List<Travel> travels = travelService.allTravels();
        model.addAttribute("travels",travels);
        return "index";
    }

    @PostMapping("/adding")
    public String addTravel(@Valid @ModelAttribute("travel") Travel travel,
                            Model model, BindingResult result){
        if(result.hasErrors()){
            List<Travel> travels = travelService.allTravels();
            model.addAttribute("travels",travels);
            return "index";
        }
        else{
            Float amount = Float.parseFloat(travel.getAmount().toString());
            travel.setAmount(amount);

            travelService.createTravel(travel);
            return "redirect:/expenses";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Travel optionalTravel = travelService.findTravel(id);
        model.addAttribute("travel",optionalTravel);
        return "edit";
    }

    @PutMapping("/{id}")
    public String update(@Valid @ModelAttribute("travel") Travel travel,
                         Model model, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("travel", travel);
            return "edit";
        }
        else{
            travelService.updateTravel(travel);
            return "redirect:/expenses";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        travelService.deleteTravel(id);
        return "redirect:/expenses";
    }
}
