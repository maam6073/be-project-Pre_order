package com.dohyeong.preorder.domain.comment_like.entity;

import com.dohyeong.preorder.domain.comment.entity.Comment;
import com.dohyeong.preorder.domain.member.entity.Member;
import jakarta.persistence.*;

@Entity
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_like_id")
    private Long comment_like_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
}
