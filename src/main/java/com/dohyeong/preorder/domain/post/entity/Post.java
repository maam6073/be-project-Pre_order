package com.dohyeong.preorder.domain.post.entity;

import com.dohyeong.preorder.domain.common.BaseEntity;
import com.dohyeong.preorder.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long post_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;
}
