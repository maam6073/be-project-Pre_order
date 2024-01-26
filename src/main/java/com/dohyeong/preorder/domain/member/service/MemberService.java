package com.dohyeong.preorder.domain.member.service;

import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    public Member saveMember(Member member, MultipartFile image) throws IOException{

        return null;
    }
}
