package com.vikingzorros.rehabit.controllers;


import com.vikingzorros.rehabit.dto.UserDto;
import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.objectmappers.UserMapper;
import com.vikingzorros.rehabit.service.CategoryService;
import com.vikingzorros.rehabit.service.PostService;
import com.vikingzorros.rehabit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/Rehabit")
public class UserHomeController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    UserMapper mapper;


//    @GetMapping("/posts")
//    public String userPosts(Model model, HttpServletRequest request){
//
//        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
//        List<Post> userPosts = postService.findAllByUserId(userDto.getId());
//
//        model.addAttribute("userPosts",userPosts);
//        return "addPostPage";
//    }

    @GetMapping("/dashboard")
    public String testdash(Model model){

        List<Post> posts = postService.findAllPosts();

        model.addAttribute("allPosts",posts);
        return "tempDashboard";
    }


    @GetMapping("/addPostPage")
    public String addPost(Model theModel, HttpServletRequest request){


        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        List<Post> userPosts = postService.findAllByUserId(userDto.getId());

        theModel.addAttribute("userPosts",userPosts);
        Post post=new Post();
        List<Category> allCategories = categoryService.findAllCategories();
        theModel.addAttribute("post",post);
        theModel.addAttribute("categories",allCategories);
        Category category = new Category();
        theModel.addAttribute("category",category);
        return "addPostPage";
    }

    @PostMapping("/addPost")
    public String addingPost(@ModelAttribute("post") Post thePost, @ModelAttribute("category") Category theCategory){

        log.info("Post : {}",thePost);
        //Category theCategory =thePost.getCategory();
        thePost.setCategory(theCategory);
        //Post thePost = (Post) theModel.getAttribute("post");
      //  Category theCategory = (Category) theModel.getAttribute("category");

      //  thePost.setCategory(theCategory);


        thePost.setCreateTime("2:41 pm");
        postService.save(thePost);
        log.info("Saving the Post : {}",thePost);

        return "redirect:/Rehabit/tempDashboard";
    }




}
