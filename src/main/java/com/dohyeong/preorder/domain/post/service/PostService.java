package com.dohyeong.preorder.domain.post.service;


import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.post.entity.Post;
import com.dohyeong.preorder.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    //글 저장
    public Post savePost(Post post){
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post savePost =
                Post.builder()
                        .member(member)
                        .title(post.getTitle())
                        .body(post.getBody())
                        .build();
        return postRepository.save(savePost);
    }

    //글 수정


    //글 삭제


    //글 확인
}
