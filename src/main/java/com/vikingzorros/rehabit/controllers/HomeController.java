package com.vikingzorros.rehabit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Rehabit")
public class HomeController {

    @RequestMapping
    public String homePage(){
        return "home1";
    }

    @RequestMapping("/test")
    public String homePage1(){
        return "home2";
    }
    @RequestMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";
    }

    @RequestMapping("/login")
    public String processLogin(){
        return "login";
    }
    @RequestMapping("/signup")
    public String processSignup(){
        return "signup";
    }


}
