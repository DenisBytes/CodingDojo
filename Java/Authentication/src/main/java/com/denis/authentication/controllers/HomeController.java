package com.denis.authentication.controllers;

// .. don't forget to include all your imports! ..

import com.denis.authentication.models.LoginUser;
import com.denis.authentication.models.User;
import com.denis.authentication.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model,HttpSession session) {

        session.setAttribute("userRegistered", null);
        session.setAttribute("userLoggedIn", null);
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }

    @GetMapping("/home")
    public String dashboard(Model model, HttpSession session){

        model.addAttribute("userLoggedIn",userService.findUser((Long)session.getAttribute("loggedInUserID")));

        return "dashboard";
    }


    @GetMapping("/success")
    public String success(Model model, HttpSession session){


        model.addAttribute("userRegistered",userService.findUser((Long)session.getAttribute("createdUserID")));
        return "success";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {

        userService.register(newUser,result);

        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }

        session.setAttribute("createdUserID", newUser.getId());

        return "redirect:/success";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {

        User user = userService.login(newLogin, result);

        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index";
        }

        session.setAttribute("loggedInUserID",user.getId());

        return "redirect:/home";
    }

}
