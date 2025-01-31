package com.dohyeong.preorder.domain.post.mapper;

import com.dohyeong.preorder.domain.post.dto.CreatePostDto;
import com.dohyeong.preorder.domain.post.dto.PostResponseDto;
import com.dohyeong.preorder.domain.post.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public Post createPostDtoToPost(CreatePostDto createPostDto){
        return Post.builder()
                .title(createPostDto.getTitle())
                .body(createPostDto.getBody())
                .build();
    }

    public PostResponseDto.createResponseDto postToPostResponseDto(Post post){
        return PostResponseDto.createResponseDto.builder()
                .post_id(post.getPost_id())
                .member_id(post.getMember().getMember_id())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

}
