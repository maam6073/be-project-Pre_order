package com.dohyeong.preorder.domain.member.mapper;

import com.dohyeong.preorder.domain.member.dto.MemberPostDto;
import com.dohyeong.preorder.domain.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member memberPostToMember(MemberPostDto memberPostDto){
        return Member.builder().
                email(memberPostDto.getEmail()).
                password(memberPostDto.getPassword()).
                description(memberPostDto.getAbout()).
                build();
    }
}
