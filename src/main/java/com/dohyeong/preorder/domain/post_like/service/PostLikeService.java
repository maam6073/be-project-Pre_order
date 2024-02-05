package com.dohyeong.preorder.domain.post_like.service;

import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.post.entity.Post;
import com.dohyeong.preorder.domain.post.repository.PostRepository;
import com.dohyeong.preorder.domain.post_like.entity.PostLike;
import com.dohyeong.preorder.domain.post_like.repository.PostLikeRepository;
import com.dohyeong.preorder.global.exception.BusinessLogicException;
import com.dohyeong.preorder.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    public PostLike savePostLike(long post_id){
        Post post = postRepository.findById(post_id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_POST));
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        PostLike savePostLike = PostLike.builder()
                .post(post)
                .member(member)
                .build();

        return postLikeRepository.save(savePostLike);
    }

}
