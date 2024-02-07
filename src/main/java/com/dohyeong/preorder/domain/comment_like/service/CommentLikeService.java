package com.dohyeong.preorder.domain.comment_like.service;

import com.dohyeong.preorder.domain.activitylog.entity.ActivityType;
import com.dohyeong.preorder.domain.activitylog.service.ActivityLogService;
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
    private final ActivityLogService activityLogService;
    public CommentLike saveCommentLike(long commentId){
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.NOT_FOUND_COMMENT));
        Member curMember = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        CommentLike saveCommentLike = CommentLike.builder()
                .comment(comment)
                .member(curMember)
                .build();

        activityLogService.logMemberActivity(curMember,comment.getMember().getName(), curMember.getName()+"님이 "
                +comment.getMember().getName() + "님 댓글을 좋아합니다.", ActivityType.COMMENT_LIKE);
        return commentLikeRepository.save(saveCommentLike);
    }
}
