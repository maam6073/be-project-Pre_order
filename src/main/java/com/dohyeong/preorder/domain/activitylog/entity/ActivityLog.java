package com.dohyeong.preorder.domain.activitylog.entity;

import com.dohyeong.preorder.domain.common.BaseEntity;
import com.dohyeong.preorder.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ActivityLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activity_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member followingMember;

    private ActivityType type;

    private String activity;
}
