package com.example.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
    @RequestMapping("/")
    public String helloHuman(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "last_name", required = false) String last_name,
                             @RequestParam(value = "times", required = false) Integer loops){


        if (name != null && last_name != null){
            return "Hello "+name + " "+"Skendaj";
        }
        else if (name != null && loops != null){
            String temp = new String();
            for (int i = 0; i<loops; i++){
                temp += "Hello "+name+"\n";
            }
            return temp;
        }
        else if (last_name != null && loops != null){
            String temp = new String();
            for (int i = 0; i<loops; i++){
                temp += "Hello "+last_name+"\n";
            }
            return temp;
        }
        else if (name != null){
            return "Hello "+name;
        }
        else if (last_name!=null){
            return "Hello "+last_name;
        }
        else {
            return "Hello human";
        }
    }
}
