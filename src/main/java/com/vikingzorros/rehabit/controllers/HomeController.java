package com.vikingzorros.rehabit.controllers;

import com.vikingzorros.rehabit.dto.UserDto;

import com.vikingzorros.rehabit.service.AuthService;
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
import java.util.regex.Pattern;

@Slf4j
@Controller
@RequestMapping("/Rehabit")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserValidator userValidator;

    private UserDto sessionUser;
    private int otpSentCount;

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
    public String saveUser(
            @Valid @ModelAttribute("user") UserDto theUserDto,
            BindingResult theBindingResult,
            Model theModel) {

        if (!theBindingResult.hasErrors()) {

            if (userValidator.isValid(theUserDto)) {

                sessionUser = theUserDto;
                if(sendOtp()) {
                    log.info("otp sent");
                    otpSentCount = 1;
                    return "redirect:/Rehabit/otp";
                }
            }

            theModel.addAttribute("theUserDto", new UserDto());
            theModel.addAttribute("registrationError", userValidator.getErrorInfo());
        }
        return "signup";
    }

    @RequestMapping("/otp")
    public String otpPage(Model theModel){

        theModel.addAttribute("test","hi");
        log.info("redirecting to otp");
        return "otp";
    }

    @RequestMapping("/resendOtp")
    public String resendOtpPage(Model theModel){

        if(otpSentCount<5) {
            otpSentCount++;
            boolean status = sendOtp();
            if (status) {
                log.info("---otp sent");
                return "redirect:/Rehabit/otp";
            }
        }
        theModel.addAttribute("message","Failed to send otp... please try again after sometime");
        return "/otp";
    }

    private boolean sendOtp() {
        String userPhoneNumber = sessionUser.getPhoneNumber();
        return authService.sendToken(userPhoneNumber);
    }

    @PostMapping("/processOtp")
    public String processOtp(HttpServletRequest request, Model theModel){

        String errorMessage="";
        String otpValue=request.getParameter("otpValue");

        if (otpValue==null|| !(Pattern.matches("[0-9]+", otpValue))){
            errorMessage = "Otp should contain 6 digits";
        }
        else {

            String userPhoneNumber = sessionUser.getPhoneNumber();
            log.info("verifying user --->" + sessionUser + "");
            String otpStatus = authService.verifyToken(userPhoneNumber, otpValue);

            if (otpStatus.equals("approved")) {
                saveUserToDb();
                return "dashboard";
            } else if (otpStatus.equals("pending")) {
                errorMessage = "Wrong OTP entered";
            } else {
                errorMessage = "OTP Timed out";
            }
        }
        theModel.addAttribute("message",errorMessage);
        return "otp";

    }

    private void saveUserToDb() {

        sessionUser.setCreateTime(Long.toString(System.currentTimeMillis()));

        userService.save(sessionUser);

        log.info("Successfully created user: {} " + sessionUser.getUserName());
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

    }

}

