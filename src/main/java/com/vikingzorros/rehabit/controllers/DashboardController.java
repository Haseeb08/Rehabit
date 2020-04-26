
package com.vikingzorros.rehabit.controllers;

import com.vikingzorros.rehabit.dto.UserDto;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


    @Controller
    @RequestMapping("/Rehabit")
    public class DashboardController {

        @Autowired
        private PostService postService;




    }