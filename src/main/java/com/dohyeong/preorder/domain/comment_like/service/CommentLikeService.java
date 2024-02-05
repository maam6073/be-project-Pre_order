package com.dohyeong.preorder.domain.comment_like.service;

import com.dohyeong.preorder.domain.comment.entity.Comment;
import com.dohyeong.preorder.domain.comment.repository.CommentRepository;
import com.dohyeong.preorder.domain.comment_like.entity.CommentLike;
import com.dohyeong.preorder.domain.comment_like.repository.CommentLikeRepository;
import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.global.exception.BusinessLogicException;
import com.dohyeong.preorder.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentLikeService {
    private final CommentRepository commentRepository;
    private final CommentLikeRepository commentLikeRepository;
    public CommentLike saveCommentLike(long commentId){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_COMMENT));
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CommentLike saveCommentLike = CommentLike.builder()
                .comment(comment)
                .member(member)
                .build();
        return commentLikeRepository.save(saveCommentLike);
    }
}
