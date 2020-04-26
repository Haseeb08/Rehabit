package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.daorepositories.PostRepository;
import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAllByUserId(int id) {
        List<Post> posts = postRepository.findAllByUserId(id);
        //List<PostDto> postDtos = postMapper.convertToDtos(posts);
        return posts;
    }

    @Override
    public List<Post> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<Post> openPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getIsAnonymous() == 0) {
                openPosts.add(post);
                log.info("user post-->" + post.getUser() + "");
            }
        }
        //List<PostDto> postDtos = postMapper.convertToDtos(posts);
        return openPosts;

    }


    @Override
    public Post findById(int id) {
        return null;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Post> findByCategory(Category category) {
        return null;
    }
}
