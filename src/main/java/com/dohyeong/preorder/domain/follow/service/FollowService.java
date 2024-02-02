package com.dohyeong.preorder.domain.follow.service;

import com.dohyeong.preorder.domain.follow.entity.Follow;
import com.dohyeong.preorder.domain.follow.repository.FollowRepository;
import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.member.service.MemberService;
import com.dohyeong.preorder.global.exception.BusinessLogicException;
import com.dohyeong.preorder.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final MemberService memberService;
    //팔로우
    public String follow(String followerName){
        Member following = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member follower = memberService.getMemberByName(followerName);

        //자기자신 팔로우 x
        if(follower.getName().equals(following.getName()))
            throw new BusinessLogicException(ExceptionCode.BAD_REQUEST);

        //중복 팔로우 x
        if(followRepository.findFollow(follower,following).isPresent())
            throw new BusinessLogicException(ExceptionCode.BAD_REQUEST_FOLLOW);

        Follow follow = Follow.builder()
                .following(following)
                .follower(follower)
                .build();

        followRepository.save(follow);
        return "Success";
    }



    //following 전체 출력


    //follower 전체 출력
}
