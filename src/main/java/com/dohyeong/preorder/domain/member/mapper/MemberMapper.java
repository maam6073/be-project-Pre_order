package com.dohyeong.preorder.domain.member.mapper;

import com.dohyeong.preorder.domain.member.dto.MemberPatchDto;
import com.dohyeong.preorder.domain.member.dto.MemberPostDto;
import com.dohyeong.preorder.domain.member.dto.MemberResponseDto;
import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.member.entity.MemberRole;
import org.springframework.stereotype.Component;


@Component
public class MemberMapper {
    public Member memberPostToMember(MemberPostDto memberPostDto){
        return Member.builder().
                email(memberPostDto.getEmail()).
                name(memberPostDto.getName()).
                password(memberPostDto.getPassword()).
                description(memberPostDto.getDescription()).
                memberRole(MemberRole.USER).
                build();
    }

    public Member memberPatchToMember(MemberPatchDto memberPatchDto){
        return Member.builder().
                name(memberPatchDto.getName()).
                description(memberPatchDto.getDescription()).
                build();
    }

    public MemberResponseDto.PatchDto memberToPatchResponse(Member member){
        return MemberResponseDto.PatchDto.builder().
                email(member.getEmail()).
                name(member.getName()).
                profile_img(member.getProfile_img()).
                description(member.getDescription())
                .build();
    }
}
