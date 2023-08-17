package com.denis.ninjagoldgame.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(HttpSession session, Model model){
        if (session.getAttribute("gold") == null){
            session.setAttribute("gold", 0);
            session.setAttribute("activities", new ArrayList<>());
        }
        model.addAttribute("gold",session.getAttribute("gold"));
        model.addAttribute("activities", session.getAttribute("activities"));

        return "index";
    }
    @RequestMapping(value = "/elaborate", method = RequestMethod.POST)
    public String elaborate(HttpSession session, @RequestParam ("place") String place){
        Random random = new Random();
        SimpleDateFormat date = new SimpleDateFormat("MMMM d yyyy h:mm a");
        int i = (int) session.getAttribute("gold");
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");

        if (place.equals("farm")){
            int farm = random.nextInt(11)+10;
            session.setAttribute("gold", i+farm);
            activities.add("You entered a farm and earned "+ farm + " gold. " + date.format(new Date()));
        }
        else if (place.equals("cave")){
            int cave = random.nextInt(6)+5;
            session.setAttribute("gold", i+cave);
            activities.add("You entered a cave and earned "+ cave + " gold. " + date.format(new Date()));
        }
        else if (place.equals("house")){
            int house = random.nextInt(4)+2;
            session.setAttribute("gold", i+house);
            activities.add("You entered a house and earned "+ house + " gold. " + date.format(new Date()));
        }
        else if (place.equals("spa")){
            int spa = random.nextInt(16)+5;
            session.setAttribute("gold", i-spa);
            activities.add("You entered a house and lost "+ spa + " gold. " + date.format(new Date()));
        }
        else {
            int quest = random.nextInt(51);
            boolean addRemove= random.nextBoolean();
            if(addRemove){
                session.setAttribute("gold", i+ quest);
                activities.add("You entered a quest and earned "+ quest + " gold. " + date.format(new Date()));
            }
            else{
                session.setAttribute("gold",i-quest);
                activities.add("You entered a quest and lost "+ quest + " gold. " + date.format(new Date()));
            }
        }
        session.setAttribute("activities", activities);

        if((int)session.getAttribute("gold")<=-100){
            return "redirect:/prison";
        }
        return "redirect:/";
    }

    @RequestMapping("/reset")
    public String reset(HttpSession session){
        session.setAttribute("gold",0);
        session.setAttribute("activities",new ArrayList<>());

        return "redirect:/";
    }

    @RequestMapping("/prison")
    public String prison(){
        return "prison";
    }

}