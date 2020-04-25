package com.vikingzorros.rehabit.controllers;

import com.vikingzorros.rehabit.dto.UserDto;

import com.vikingzorros.rehabit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/Rehabit")
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/testdash")
    public String testdash(){
        return "dashboarddemo";
    }

    @GetMapping
    public String homePage(){
        return "home1";
    }

    @GetMapping("/test")
    public String homePage1(){
        return "home2";
    }

    @GetMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";
    }

    @GetMapping("/login")
    public String processLogin(){
        return "login";
    }


    @GetMapping("/signout")
    public String processSignOut(){
        return "redirect:/Rehabit/";
    }

    @RequestMapping("/signup")
    public String processSignup(Model model){

        UserDto user = new UserDto();

        model.addAttribute("user",user);

        return "signup";
    }

    @PostMapping("/saveUser")
    public String saveuser(
            @Valid @ModelAttribute("user") UserDto theUserDto,
            BindingResult theBindingResult,
            Model theModel) {

        String userName = theUserDto.getUserName();
        log.info("Processing registration form for:{} " + userName);

        // form validation
        if (theBindingResult.hasErrors()){
            return "signup";
        }
        else {
            theUserDto.setCreateTime(Long.toString(System.currentTimeMillis()));
            userService.save(theUserDto);

            log.info("Successfully created user: {} " + userName);

            return "otp";
        }

//        // check the database if user already exists
//        UserDto existing = userService.findByUserDtoName(userName);
//        if (existing != null){
//            theModel.addAttribute("theUserDto", new UserDto());
//            theModel.addAttribute("registrationError", "UserDto name already exists.");
//
//            logger.warning("UserDto name already exists.");
//            return "signup";
//        }



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



    @PostMapping("/processSignup")
    public String processSignup(@Valid @ModelAttribute("user") UserDto user,
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

