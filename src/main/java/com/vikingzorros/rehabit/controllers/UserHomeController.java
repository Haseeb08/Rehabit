package com.vikingzorros.rehabit.controllers;


import com.vikingzorros.rehabit.dto.CategoryDto;
import com.vikingzorros.rehabit.dto.CommentDto;
import com.vikingzorros.rehabit.dto.PostDto;
import com.vikingzorros.rehabit.dto.UserDto;
import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Comment;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.objectmappers.UserMapper;
import com.vikingzorros.rehabit.service.CategoryService;
import com.vikingzorros.rehabit.service.CommentService;
import com.vikingzorros.rehabit.service.PostService;
import com.vikingzorros.rehabit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.StandardEmitterMBean;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
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
    CommentService commentService;


    @GetMapping("/dashboard")
    public String getdash(Model model,HttpServletRequest request){

        List<PostDto> allPosts = postService.findAllPosts();
       UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        model.addAttribute("user",userDto);
        model.addAttribute("allPosts",allPosts);
        for(PostDto post: allPosts){
            log.info(" In Dashboard user name of post-->"+post.getUser().getUserName()+"");
        }

        return "dashboard";
    }


    @GetMapping("/addPostPage")
    public String addPost(Model theModel, HttpServletRequest request){

        UserDto userDto = (UserDto) request.getSession().getAttribute("user");

        List<PostDto> userPosts = postService.findAllByUserId(userDto.getId());

        theModel.addAttribute("userPosts",userPosts);
        Post post=new Post();
        List<CategoryDto> allCategories = categoryService.findAllCategories();
        theModel.addAttribute("post",post);

        return "addPostPage";
    }

    @PostMapping("/addPost")
    public String addingPost(@ModelAttribute("post") PostDto thePost, @ModelAttribute("category") CategoryDto category, Model theModel, HttpServletRequest request){

      UserDto userDto = (UserDto) request.getSession().getAttribute("user");
      String  categoryName=request.getParameter("categoryName");
      CategoryDto theCategory = categoryService.findByName(categoryName);

      thePost.setCategory(theCategory);
        log.info("Post : {}",thePost);

        List<PostDto> posts = new ArrayList<>();
        posts.add(thePost);
        theCategory.setPosts(posts);
        thePost.setUser(userDto);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        thePost.setCreateTime(timestamp+"");
        postService.save(thePost);
        log.info("Saving the Post : {}",thePost);

        return "redirect:/Rehabit/dashboard";
    }

    @GetMapping("/commentPage")
    public String showCommentPage(@RequestParam("postId") int postId, Model theModel){

        PostDto post = postService.findById(postId);
        theModel.addAttribute("post",post);
        List<CommentDto> commentDtoList = commentService.findByPost(post);
        Comment comment = new Comment();
        theModel.addAttribute(("comment"),comment);
        theModel.addAttribute("comments",commentDtoList);
        return "Comment";
    }

    @GetMapping("/postTracker")
    public String postTracker(Model model, HttpServletRequest request){

        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        List<PostDto> posts = postService.findAllPostsTracker(userDto.getId());
        log.info("posts tracking-->{}",posts.get(0).getHabitCount());
        model.addAttribute("posts",posts);
        return "habitTracker";
    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam("postId") int postId, Model theModel, HttpServletRequest request,@ModelAttribute("comment") CommentDto comment){

        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        PostDto postDto = postService.findById(postId);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setCreateTime(timestamp+"");
        comment.setStatus(false);
        comment.setUser(userDto);
        comment.setPost(postDto);
        log.info("Comment : {}",comment);
        commentService.save(comment);
        log.info("saved Comment : {}",comment);
        return "redirect:/Rehabit/commentPage?postId="+postId;
    }

    @GetMapping("/profile")
    public String getProfile(Model model,HttpServletRequest request){
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        model.addAttribute("user",userDto);
        return  "profile";
    }

}
