package com.dohyeong.preorder.domain.activitylog.service;

import com.dohyeong.preorder.domain.activitylog.entity.ActivityLog;
import com.dohyeong.preorder.domain.activitylog.entity.ActivityType;
import com.dohyeong.preorder.domain.activitylog.repository.ActivityLogRepository;
import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.member.repository.MemberRepository;
import com.dohyeong.preorder.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogService {
    private final ActivityLogRepository activityLogRepository;
    private final MemberService memberService;
    public void logMemberActivity(Member member, String activity,ActivityType type){
        ActivityLog saveLog = ActivityLog.builder()
                .followingMember(member)
                .type(type)
                .activity(activity).build();
        activityLogRepository.save(saveLog);
    }


    public List<ActivityLog> findFollowingMemberByActivityTypeOrderByTimestamp(){
        Member findMember = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //해당멤버의 팔로잉한 멤버들의 ActivityLog를 시간순으로정렬해 List로 반환
        return activityLogRepository.findAllByFollowingMemberInOrderByCreatedAtDesc(findMember.getFollowings());
    }
}
