package org.launchcode.cheesemvc.controllers;

//import org.launchcode.models.User;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//package org.launchcode.cheesemvc.models;

@Controller
@RequestMapping("user")
public class UserController {

    private String username;
    private String email;
    private String password;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Register");
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute User user, @RequestParam String verify){
        if (user.getPassword().equals(verify)) {
            model.addAttribute("user", user);
            return "user/index";
        }
        user.setPassword("");
        model.addAttribute("title", "Register");
        model.addAttribute("user", user);
        model.addAttribute("error", "Passwords don't match");
        return "user/add";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}