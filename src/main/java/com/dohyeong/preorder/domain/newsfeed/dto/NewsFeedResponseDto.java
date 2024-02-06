package com.dohyeong.preorder.domain.newsfeed.dto;

import com.dohyeong.preorder.domain.activitylog.entity.ActivityType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class NewsFeedResponseDto {
    private Long activityId;
    private LocalDateTime time;
    private String memberName;
    private String memberProfileUrl;
    private ActivityType type;
    private String activity;
}
