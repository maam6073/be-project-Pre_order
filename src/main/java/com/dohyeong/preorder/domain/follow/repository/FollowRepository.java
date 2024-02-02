package com.dohyeong.preorder.domain.follow.repository;

import com.dohyeong.preorder.domain.follow.entity.Follow;
import com.dohyeong.preorder.domain.member.entity.Member;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow,Long> {


    @Query("select f from Follow f where f.follower = :follower and f.following = :following")
    Optional<Follow> findFollow(@Param("follower") Member follower, @Param("following") Member following);
}
