package com.denis.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/date")
    public String date(Model model){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        Date date = new Date();
        String dateFormatted = dateFormat.format(date);
        model.addAttribute("currentDate",dateFormatted);
        return "date";
    }

    @RequestMapping("/time")
    public String time(Model model){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        Date time = new Date();
        String timeFormatted = timeFormat.format(time);
        model.addAttribute("currentTime",timeFormatted);
        return "time";
    }
}
