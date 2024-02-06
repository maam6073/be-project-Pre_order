package com.dohyeong.preorder.domain.activitylog.repository;

import com.dohyeong.preorder.domain.activitylog.entity.ActivityLog;
import com.dohyeong.preorder.domain.follow.entity.Follow;
import com.dohyeong.preorder.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog,Long> {
    List<ActivityLog> findAllByFollowingMemberInOrderByCreatedAtDesc(List<Follow> followingMembers);
}
