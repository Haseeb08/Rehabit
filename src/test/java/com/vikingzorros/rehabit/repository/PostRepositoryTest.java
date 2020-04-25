package com.vikingzorros.rehabit.repository;


import com.vikingzorros.rehabit.daorepositories.PostRepository;
import com.vikingzorros.rehabit.entities.Post;;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;


    @Test
    public void testSave() {
        Post expectedPost=getPost();
        postRepository.save(expectedPost);
        Optional<Post> actualPost=postRepository.findById(expectedPost.getId());
        assertThat(actualPost.get()).isEqualTo(expectedPost);
    }

    @Test
    public void testFindAll() {
        Post thePost1 = getPost();
        Post thePost2 = getPost();
        List<Post> postList = new ArrayList<>();
        postList.add(thePost1);
        postList.add(thePost2);
        postRepository.save(thePost1);
        postRepository.save(thePost2);
        List<Post> retrievedPostList = postRepository.findAll();
        assertThat(postList).isEqualTo(retrievedPostList);
    }

    @Test
    public void testFindById() {
        Post thePost = getPost();
        postRepository.save(thePost);
        Optional<Post> actualPost=postRepository.findById(thePost.getId());
        assertThat(actualPost.get()).isEqualTo(thePost);
    }


    @Test
    public void testDeletePost() {
        Post thePost = getPost();
        postRepository.save(thePost);
        Optional<Post> actualPost=postRepository.findById(thePost.getId());
        // assertThat(actualUser.get()).isEqualTo(user);
        postRepository.delete(thePost);
        Optional<Post> returnedPost = postRepository.findById(thePost.getId());
        assertThat(returnedPost).isEqualTo(Optional.empty());

    }

    private Post getPost(){
        Post post = new Post();
        post.setTitle("My bad habit.");
        post.setDescription("this is so bad, bad,  bad. I have to stop it.");
        post.setCreateTime("time");

        return post;
    }

}
