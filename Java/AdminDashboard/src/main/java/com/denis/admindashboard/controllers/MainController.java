package com.denis.admindashboard.controllers;

import com.denis.admindashboard.models.User;
import com.denis.admindashboard.services.UserService;
import com.denis.admindashboard.validator.UserValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @GetMapping("/login")
    public String index(@ModelAttribute("newUser")User user){
        return "signup";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser")User user,
                           @RequestParam(value = "error",required = false) String error,
                           BindingResult result, Model model, HttpSession session){
        userValidator.validate(user, result);
        if(error != null){
            model.addAttribute("errorMessage","Invalid credentials, Try again");
        }
        if(result.hasErrors()){
            return "signup";
        }
        if(userService.allUsers().size()==0){
            userService.saveWithAdminRole(user);
            return "redirect:/admin";
        }else{
            userService.saveWithUserRole(user);
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/admin")
    public String admin(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("allUsers", userService.allUsers());
        return "adminPage";
    }

    @GetMapping("/dashboard")
    public String dashboard(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "dashboardPage";
    }


}
