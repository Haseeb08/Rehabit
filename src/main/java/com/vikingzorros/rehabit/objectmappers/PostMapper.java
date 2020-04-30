package com.vikingzorros.rehabit.objectmappers;

import com.vikingzorros.rehabit.dto.PostDto;
import com.vikingzorros.rehabit.entities.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PostDto convertToDto(Post post)
    {
        PostDto postDto= modelMapper.map(post, PostDto.class);

        return postDto;
    }

    public Post convertToEntity(PostDto thePostDto)
    {
        Post post = modelMapper.map(thePostDto, Post.class);
        return post;
    }

    public List<PostDto> convertToDtos(Collection<Post> posts) {
        return posts.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public final List<Post> convertToEntities(final Collection<PostDto> postDtos) {
        return postDtos.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
