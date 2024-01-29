package com.dohyeong.preorder.domain.member.service;

import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.member.repository.MemberRepository;
import com.dohyeong.preorder.global.exception.BusinessLogicException;
import com.dohyeong.preorder.global.exception.ExceptionCode;
//import com.dohyeong.preorder.global.s3.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //@Autowired
    //private S3Service s3Service;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //회원가입
    public Member saveMember(Member member, MultipartFile image) throws IOException{
        verifyMemberByEmail(member.getEmail());

        String encryptedPassword = passwordEncoder.encode(member.getPassword());

        member.setPassword(encryptedPassword);

        if(!image.isEmpty()){
            //String imgUrl = s3Service.imgUpload(image);
            //member.setProfile_img(imgUrl);
        }
        return memberRepository.save(member);
    }


    //회원 정보 수정(이름,프로필 이미지, 인사말)



    //이메일 중복 검사
    @Transactional(readOnly = true)
    private void verifyMemberByEmail(String email){
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent())
            throw new BusinessLogicException(ExceptionCode.EXISTS_EMAIL);
    }

    //이미지이름 가공
    private String findMemberByImgName(String url){
        return url.substring(url.lastIndexOf("/")+1);
    }
}
