package com.vikingzorros.rehabit.service;

import com.vikingzorros.rehabit.daorepositories.PostRepository;
import com.vikingzorros.rehabit.dto.PostDto;
import com.vikingzorros.rehabit.entities.Category;
import com.vikingzorros.rehabit.entities.Post;
import com.vikingzorros.rehabit.objectmappers.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostMapper postMapper;

    @Override
    @Transactional
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();


//        List<Post> openPosts = new ArrayList<>();
//        for(Post post: posts){
//            if(post.getIsAnonymous()==0) {
//                openPosts.add(post);
//                log.info("user name of post-->"+post.getUser().getUserName()+"");
//            }
//        }
        List<PostDto> postDtoList = new ArrayList<>();
        for(Post post: posts){
                log.info("user name of post-->"+post.getUser().getUserName()+"");
                postDtoList.add(postMapper.convertToDto(post));
        }
//        List<PostDto> postDtoList = postMapper.convertToDtos(posts);

        for(PostDto post: postDtoList){
            log.info("user name of postDto-->"+post.getUser()+"");
        }
        return postDtoList;
    }

    @Override
    @Transactional
    public PostDto findById(int id) {

        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent())
            return postMapper.convertToDto(post.get());
        else
         throw  new RuntimeException("Post not Found  id :"+id);
    }

    @Override
    public void save(PostDto post) {

        Post thePost = postMapper.convertToEntity(post);
        postRepository.save(thePost);

    }

    @Override
    @Transactional
    public List<PostDto> findAllByUserId(int id) {

        List<Post> posts = postRepository.findAllByUserId(id);

        for(Post post: posts){
            log.info("user name of post-->"+post.getUser().getUserName()+"");
        }

        List<PostDto> postDtoList = postMapper.convertToDtos(posts);
        return postDtoList;
    }


    @Override
    @Transactional
    public void deleteById(int id) {

    }

    @Override
    @Transactional
    public List<PostDto> findByCategory(Category category) {

        return null;
    }

    public List<PostDto> findAllPostsTracker(int id) {
        List<Post> posts = postRepository.findAllByUserId(id);
        for (Post post: posts)
            post.getTrackHabitList();
        List<PostDto> postDtoList = postMapper.convertToDtos(posts);
        return postDtoList;
    }
//
//    @Override
//    public void savePostTrackHabit(int id, TrackHabit trackHabit) {
//
//        Optional<Post> post = postRepository.findById(id);
//        //TrackHabit trackHabit = new TrackHabit();
//        //trackHabit.setResponse(Integer.parseInt(response));
//        post.ifPresent(value -> value.getTrackHabitList().add(trackHabit));
//
//    }
}
