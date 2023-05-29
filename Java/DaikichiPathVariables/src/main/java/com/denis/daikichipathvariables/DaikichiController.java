package com.denis.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {

    @RequestMapping("")
    public String index (){
        return "Welcome!";
    }
    @RequestMapping("/m/{courseId}/{moduleId}")
    public String index1(@PathVariable("courseId") String courseId,
                         @PathVariable("moduleId") String moduleId){
        if (courseId.equals("travel")){
            return "Congratulations! You will soon travel to "+moduleId+"!";
        }
        else if (courseId.equals("lotto")){
            int num = Integer.parseInt(moduleId);
            String result = new String();
            if(num % 2 ==0){
                result = "You will take a grand journey in the near future, but be weary of tempting offers";
            }
            else {
                result = "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
            }
            return result;
        }
        else {
            return "wrong Path Variables";
        }
    }

}