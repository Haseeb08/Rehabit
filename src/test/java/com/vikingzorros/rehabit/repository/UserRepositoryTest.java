package com.vikingzorros.rehabit.repository;

import com.vikingzorros.rehabit.daorepositories.PostRepository;
import com.vikingzorros.rehabit.daorepositories.UserRepository;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testSave() {
        User expectedUser=getUser1();
        userRepository.save(expectedUser);
        Optional<User> actualUser=userRepository.findById(expectedUser.getId());
        assertThat(actualUser.get()).isEqualTo(expectedUser);
    }

    @Test
    public void testFindAll() {

        User user1=getUser1();
        User user2=getUser2();

        List<User> expectedUsersList = new ArrayList<>();
        expectedUsersList.add(user1);
        expectedUsersList.add(user2);

        userRepository.save(user1);
        userRepository.save(user2);

        List<User> actualUsers = userRepository.findAll();

        assertThat(actualUsers).isEqualTo(expectedUsersList);
    }

    @Test
    public void testFindById() {
        User expectedUser=getUser1();
        userRepository.save(expectedUser);
        Optional<User> actualUser=userRepository.findById(expectedUser.getId());
        assertThat(actualUser.get()).isEqualTo(expectedUser);
    }

    @Test
    public void testDeleteUser() {
        User user=getUser1();
        userRepository.save(user);
        Optional<User> actualUser=userRepository.findById(user.getId());
       // assertThat(actualUser.get()).isEqualTo(user);
        userRepository.delete(user);
        Optional<User> returnedUser=userRepository.findById(user.getId());
        assertThat(returnedUser).isEqualTo(Optional.empty());

    }



    private User getUser1(){
        User user = new User();
        user.setUserName("Haseeb");
        user.setPassword("Haseeb123");
        user.setPhoneNumber("9797989797");
        user.setEmail("haseeb@gmail.com");
        user.setCreateTime("time");

        return user;
    }

    private User getUser2(){
        User user = new User();
        user.setUserName("Vamshi");
        user.setPassword("Vamshi123");
        user.setPhoneNumber("9898989898");
        user.setEmail("vamshi@gmail.com");
        user.setCreateTime("time");

        return user;
    }

    private Post getPost1(){
        Post post = new Post();
        post.setTitle("My bad habit.");
        post.setDescription("this is so bad, bad bad. I have to stop it.");
        post.setCreateTime("time");
       // post.setUser(getUser1());

        return post;
    }

// Testing the mapping bw User and Post
    @Test
    public void testUserAndPost(){
        User user = getUser1();
        Post post = getPost1();
       post.setUser(user);
        Post thePost = postRepository.save(getPost1());
        List<Post> userPosts = new ArrayList<>();
        userPosts.add(post);
        user.setPosts(userPosts);
        User savedUserInDb = userRepository.save(user);
        Optional<Post> getPostFromDb = postRepository.findById(post.getId());
        log.info("User details : {} ",user);
        assertThat(getPostFromDb.get().getUser()).isEqualTo(savedUserInDb);
    }

}