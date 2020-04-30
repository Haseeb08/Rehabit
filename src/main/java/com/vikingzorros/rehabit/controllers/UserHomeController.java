package com.vikingzorros.rehabit.controllers;



import com.vikingzorros.rehabit.dto.*;
import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Comment;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.entities.TrackHabit;
import com.vikingzorros.rehabit.objectmappers.UserMapper;
import com.vikingzorros.rehabit.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.management.StandardEmitterMBean;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Autowired
    TrackHabitService trackHabitService;

    @Autowired
    MotivationalMessageService motivationalMessageService;

    @GetMapping("/dashboard")
    public String getdash(Model model,HttpServletRequest request){

        List<Post> allPosts = postService.findAllPosts();
       UserDto userDto = (UserDto) request.getSession().getAttribute("user");
       allPosts = getPostsTime(allPosts);
        model.addAttribute("user",userDto);
        model.addAttribute("allPosts",allPosts);
        return "dashboard";
    }


    @GetMapping("/addPostPage")
    public String addPost(Model theModel, HttpServletRequest request){

        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        List<PostDto> userPosts = postService.findAllByUserId(userDto.getId());
        theModel.addAttribute("userPosts",userPosts);
        Post post=new Post();
        userPosts=getPostTime(userPosts);
        theModel.addAttribute("post",post);
        return "addPostPage";
    }

    @PostMapping("/addPost")
    public String addingPost(@ModelAttribute("post") PostDto thePost, @ModelAttribute("category") CategoryDto category,Model theModel, HttpServletRequest request){


          UserDto userDto = (UserDto) request.getSession().getAttribute("user");
          String  categoryName=request.getParameter("categoryName");
          CategoryDto theCategory = categoryService.findByName(categoryName);

          thePost.setCategory(theCategory);
        log.info("Post : {}",thePost);

        List<PostDto> posts = new ArrayList<>();
        posts.add(thePost);
        theCategory.setPosts(posts);
        thePost.setUser(userDto);
        thePost.setCreateTime(TimeController.convert(thePost.getCreateTime()));
        postService.save(thePost);
        log.info("Saving the Post : {}",thePost);

        return "redirect:/Rehabit/dashboard";
    }

    @GetMapping("/commentPage")
    public String showCommentPage(@RequestParam("postId") int postId, Model theModel){

        PostDto post = postService.findById(postId);
        post.setCreateTime(TimeController.convert(post.getCreateTime()));
        List<Comment> commentDtoList = commentService.findByPost(post);
        commentDtoList = getCommentTime(commentDtoList);
        Comment comment = new Comment();
        theModel.addAttribute("post",post);
        theModel.addAttribute(("comment"),comment);
        theModel.addAttribute("comments",commentDtoList);
        return "Comment";
    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam("postId") int postId, Model theModel,
                             HttpServletRequest request,
                             @ModelAttribute("comment") CommentDto comment){

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
    public String getProfile(Model model,HttpServletRequest request) throws ParseException {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(userDto.getCreateTime());
        userDto.setCreateTime( df.format(date));
        model.addAttribute("user",userDto);
        return  "profile";
    }

    @GetMapping("/postTracker")
    public String postTracker(Model model, HttpServletRequest request,@ModelAttribute("motivationMessage") String motivationMessage){

        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        List<PostDto> posts = postService.findAllPostsTracker(userDto.getId());

        posts = getPostTime(posts);
        for(PostDto postDto:posts) {
            postDto.setTrackHabitList(getTrackhabitTime(postDto.getTrackHabitList()));
        }
        model.addAttribute("posts",posts);
        model.addAttribute("message",motivationMessage);
        TrackHabitDto trackHabit = new TrackHabitDto();
        model.addAttribute("trackHabit",trackHabit);


        log.info("adding habit tracer {}",trackHabit);
        return "habitTracker";
    }
    @PostMapping("/addTrackHabit/{id}")
    public String postTracker(@PathVariable int id, @ModelAttribute TrackHabitDto trackHabit, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes){

        log.info("updating response of habit-->{}",id);
        PostDto post = postService.findById(id);


        String  response=request.getParameter("response");
        trackHabit.setResponse(response);

        if(response.equals("YES")) {
            postService.updateHabitCount(id,true);
            Random random = new Random();
            int messageId = random.nextInt(30)+1;
            MotivationalMessageDto motivationalMessage = motivationalMessageService.findById(messageId);
            redirectAttributes.addAttribute("motivationMessage",motivationalMessage.getMessage());
        }

        log.info("setting response of post {} to {}",id,response);

        TrackHabitDto trackHabit1 = new TrackHabitDto();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        trackHabit1.setResponse(response);
        trackHabit1.setNotifyTime(timestamp.toString());
        trackHabit1.setPost(post);
        log.info("saving trackhabit {}",trackHabit1);
        if(post!=null)
            trackHabitService.save(trackHabit1);

        return "redirect:/Rehabit/postTracker";
    }


    private List<Post> getPostsTime(List<Post> posts){

        for(Post post: posts){
            log.info(" In Dashboard user name of post-->"+post.getUser().getUserName()+"");
            String time1 = TimeController.convert(post.getCreateTime());
            post.setCreateTime(time1);
        }
    return posts;
    }

    private List<PostDto> getPostTime(List<PostDto> postDtos) {

        for (PostDto post : postDtos) {
            log.info(" In Dashboard user name of post-->" + post.getUser().getUserName() + "");
            String time1 = TimeController.convert(post.getCreateTime());
            post.setCreateTime(time1);
        }
        return postDtos;
    }
    private List<Comment> getCommentTime(List<Comment> commentDtos){

        for(Comment commentDto: commentDtos){
            log.info(" In Dashboard user name of comment-->"+commentDto.getUser().getUserName()+"");
            String time1 = TimeController.convert(commentDto.getCreateTime());
            commentDto.setCreateTime(time1);
        }
        return commentDtos;
    }

    private List<TrackHabitDto> getTrackhabitTime(List<TrackHabitDto> trackHabitDtos){

        for(TrackHabitDto trackHabitDto: trackHabitDtos){

            String time1 = TimeController.convert(trackHabitDto.getNotifyTime());
            trackHabitDto.setNotifyTime(time1);
        }
        return trackHabitDtos;
    }
}
