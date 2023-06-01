package com.denis.omikuji.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;

@Controller
@RequestMapping("omikuji")
public class OmikujiController {
    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public String send(
            @RequestParam (value = "number") Integer number,
            @RequestParam (value = "city") String city,
            @RequestParam (value = "personName") String personName,
            @RequestParam (value = "hobby") String hobby,
            @RequestParam (value = "livingThing") String livingThing,
            @RequestParam (value = "somethingNice") String somethingNice,
            HttpSession session
    ){
        session.setAttribute("number",number);
        session.setAttribute("city",city);
        session.setAttribute("personName",personName);
        session.setAttribute("hobby",hobby);
        session.setAttribute("livingThing",livingThing);
        session.setAttribute("somethingNice",somethingNice);

        return "redirect:/omikuji/show";
    }

    @RequestMapping("/show")
    public String show(Model model, HttpSession session){

        Integer number = (Integer) session.getAttribute("number");
        String city = (String) session.getAttribute("city");
        String personName = (String) session.getAttribute("personName");
        String hobby = (String) session.getAttribute("hobby");
        String livingThing = (String) session.getAttribute("livingThing");
        String somethingNice = (String) session.getAttribute("somethingNice");

        model.addAttribute("number", number);
        model.addAttribute("city", city);
        model.addAttribute("personName", personName);
        model.addAttribute("hobby", hobby);
        model.addAttribute("livingThing", livingThing);
        model.addAttribute("somethingNice", somethingNice);

        return"show";
    }
}


