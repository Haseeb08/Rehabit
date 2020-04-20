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
        return "home";
    }

    @RequestMapping("/test")
    public String homePage1(){
        return "home2";
    }
    @RequestMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";
    }

    @PostMapping("/processLogin")
    public String processLogin(){
        return "dashboard";
    }
    @PostMapping("/processSignup")
    public String processSignup(){
        return "dashboard";
    }


}
