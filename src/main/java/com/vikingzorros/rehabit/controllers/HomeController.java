package com.vikingzorros.rehabit.controllers;

import com.vikingzorros.rehabit.entities.User;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/Rehabit")
public class HomeController {

    @RequestMapping("/testdash")
    public String testdash(){
        return "dashboarddemo";
    }

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
    public String processSignup(Model model){

        User user = new User();

        model.addAttribute("user",user);

        return "signup";
    }

    @RequestMapping("/otp")
    public String otpPage(Model theModel){
        theModel.addAttribute("test","hi");
        return "otp";
    }

    @PostMapping("/processOtp")
    public String processOtp(HttpServletRequest request, Model theModel){
        theModel.addAttribute("message","Wrong OTP entered");
        String otpValue=request.getParameter("otpValue");
        if (otpValue==null){
            return "otp";
        }
        if (otpValue.equals("1234")){
            return "dashboard";
        }else {
            return "otp";
        }
    }

    @PostMapping("/processLogin")
    public String processLogin(HttpServletRequest request, Model theModel){
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        if(email!=null){email=email.trim();}
        if(password!=null){password=password.trim();}
        if((!email.equals(""))&&(!password.equals(""))) {
            if(authorizeUser(email,password)){
                //System.out.println(email+password);
                return "dashboard";
            }else{
                theModel.addAttribute("notMatch","Email and password not matching");
                return "login";
            }
        }else{
            if(email.equals("")){
            theModel.addAttribute("emailError","Email cannot be empty"+email);}
            if(password.equals("")){
            theModel.addAttribute("emailValue",email);
            theModel.addAttribute("passError","password cannot be empty"+password);}
            return "login";
        }

    }

    public boolean authorizeUser(String email,String password){
        if(email.equals("vamshi@gmail.com")){
            if(password.equals("1234")){
                return true;
            }else{
                return false;
            }
        }
        else if(email.equals("haseeb@gmail.com")){
            if(password.equals("1234")){
                return true;
            }else{
                return false;
            }
        }
        else if(email.equals("madhuri@gmail.com")){
            if(password.equals("1234")){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }

    }

    @PostMapping("/processSignup")
    public String processSignup(@Valid @ModelAttribute("user") User user,
                                BindingResult theBindingResult){
        if(theBindingResult.hasErrors()) {
            return "signup";
        }else {
            return "otp";
        }
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

}

