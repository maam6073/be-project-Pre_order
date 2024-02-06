package com.dohyeong.preorder.domain.newsfeed.service;

import com.dohyeong.preorder.domain.activitylog.entity.ActivityLog;
import com.dohyeong.preorder.domain.activitylog.service.ActivityLogService;
import com.dohyeong.preorder.domain.newsfeed.dto.NewsFeedResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsFeedService {


    private final ActivityLogService activityLogService;


    //팔로잉한 해당 로그 내용 뽑아서 출력

    public List<NewsFeedResponseDto> getNewsFeedForMember(){
        List<ActivityLog> followingActivityLogs = activityLogService.findFollowingMemberByActivityTypeOrderByTimestamp();

        List<NewsFeedResponseDto> responseDtoList = new ArrayList<>();

        for(ActivityLog log : followingActivityLogs){
            NewsFeedResponseDto newsFeedResponseDto = NewsFeedResponseDto.builder()
                    .activityId(log.getActivity_id())
                    .time(log.getCreatedAt())
                    .memberName(log.getFollowingMember().getName())
                    .memberProfileUrl(log.getFollowingMember().getProfile_img())
                    .type(log.getType())
                    .activity(log.getActivity())
                    .build();

            responseDtoList.add(newsFeedResponseDto);
        }

        return responseDtoList;
    }

}
