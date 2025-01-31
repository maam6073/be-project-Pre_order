package com.dohyeong.preorder.domain.comment.entity;

import com.dohyeong.preorder.domain.common.BaseEntity;
import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.post.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Comment extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    @Id
    private Long comment_id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 50)
    private String comment;
}
