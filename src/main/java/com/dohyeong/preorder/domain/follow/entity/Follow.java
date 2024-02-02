package com.dohyeong.preorder.domain.follow.entity;


import com.dohyeong.preorder.domain.common.BaseEntity;
import com.dohyeong.preorder.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
public class Follow extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Long follow_id;

    @ManyToOne
    @JoinColumn(name = "following")
    private Member following;

    @ManyToOne
    @JoinColumn(name = "follower")
    private Member follower;






}
