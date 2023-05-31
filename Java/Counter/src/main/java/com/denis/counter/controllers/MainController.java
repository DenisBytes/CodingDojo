package com.denis.counter.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class MainController {

    @RequestMapping("")
    public String index(HttpSession session){

        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        else {
            int i = (int) session.getAttribute("count");
            session.setAttribute("count",i+1);
        }
        return "index";
    }

    @RequestMapping("/counter")
    public String countPage(){
        return "counter";
    }

    @RequestMapping("/doublecounter")
    public String doubleCountPage(HttpSession session, Model model){
        Integer doubleCount = (Integer) session.getAttribute("count");
        doubleCount *= 2;
        model.addAttribute("doubleNumber",doubleCount);
        return "doublecounter";
    }

    @RequestMapping("/reset")
    public String resetCount(HttpSession session){
        session.setAttribute("count",0);
        return "redirect:/your_server";
    }
}
