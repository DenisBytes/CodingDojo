package com.denis.loginsetup.controllers;

import com.denis.loginsetup.models.LoginUser;
import com.denis.loginsetup.models.User;
import com.denis.loginsetup.services.UserService;
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
public class UserController {

    @Autowired
    UserService userService;

    //INDEX PAGE
    @GetMapping("/")
    public String index(@ModelAttribute("newUser")User user,
                        @ModelAttribute("newLogin")LoginUser loginUser,
                        HttpSession session){
        session.setAttribute("loggedInUserID", null);
        return"index";
    }

    //REGISTERING THE USER
    @PostMapping("/register")
    public String registerIndex(@Valid @ModelAttribute("newUser")User user,
                                BindingResult result, Model model, HttpSession session){
        userService.register(user,result);

        if(result.hasErrors()){
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        }
        session.setAttribute("loggedInUserID", user.getId());

        return "redirect:/home";
    }

    //LOGGING IN THE USER
    @PostMapping("/login")
    public String loginIndex(@Valid @ModelAttribute("newLogin") LoginUser loginUser,
                             BindingResult result, Model model, HttpSession session){
        User user = userService.login(loginUser,result);

        if(result.hasErrors()){
            model.addAttribute("newUser",new User());
            return "index";
        }

        session.setAttribute("loggedInUserID", user.getId());

        return "redirect:/home";
    }
}
