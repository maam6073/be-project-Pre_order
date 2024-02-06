package com.dohyeong.preorder.domain.follow.entity;


import com.dohyeong.preorder.domain.common.BaseEntity;
import com.dohyeong.preorder.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Follow extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private Long follow_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "following")
    private Member following;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "follower")
    private Member follower;
}
