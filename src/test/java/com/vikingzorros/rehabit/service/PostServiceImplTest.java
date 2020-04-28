package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
class PostServiceImplTest {

    @Autowired
    PostService postService;

    public Post getPost() {

       // User u1 = getUser1();
       // Category c1= getCategory1();
        Post p1=new Post();
       // p1.setUser(u1);
        p1.setTitle("Testing Post");
        p1.setDescription("Testing the Post service");
       // p1.setCategory(c1);
        p1.setCreateTime("time");
        p1.setHabitCount(2);
        p1.setIsAnonymous(0);

        return p1;
    }

    @Test
    void findAllByUserId() {
    }

    @Test
    void findAllPosts() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByCategory() {
    }

//    @Test
//    void TestPostandCategory() {
//
//        Post thePost = getPost();
//        log.info("Post : {}",thePost);
//        Category c1 = getCategory1();
//        log.info("Category: {}",c1);
//        User u1 = getUser1();
//        log.info("User : {}",u1);
//
//        thePost.setUser(u1);
//        thePost.setCategory(c1);
//        log.info("Post : {}",thePost);
//
//        List<Post> Posts = new ArrayList<>();
//        Posts.add(thePost);
//        c1.setPosts(Posts);
//        u1.setPosts(Posts);
//        postService.save(thePost);
//
//        log.info("Post : {}",thePost);
//
//        assertEquals(c1.getPosts().ge,u1.getPosts().get(0));
//
//    }
//
    private User getUser1(){
        User user = new User();
        user.setUserName("Haseeb");
        user.setPassword("Haseeb123");
        user.setPhoneNumber("9797989797");
        user.setEmail("haseeb@gmail.com");
        user.setCreateTime("time");

        return user;
    }

    private Category getCategory1(){
        Category category = new Category();
        category.setName("Temp Category");
        category.setDescription("blablabla");

        return category;
    }

}