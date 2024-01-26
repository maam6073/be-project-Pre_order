package com.dohyeong.preorder.domain.member.controller;

import com.dohyeong.preorder.domain.member.dto.MailTestDto;
import com.dohyeong.preorder.domain.member.dto.MemberPatchDto;
import com.dohyeong.preorder.domain.member.dto.MemberPostDto;
import com.dohyeong.preorder.domain.member.service.MemberService;
import com.dohyeong.preorder.global.mail.service.MailServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/members")
public class MemberController {

    private final MailServiceImpl mailService;
    private final MemberService memberService;

    //이메일 인증
    @PostMapping("/emailConfirm")
    public ResponseEntity emailConfirm(@Valid @RequestBody MailTestDto mailTestDto) throws Exception{
        //인증번호
        String confirm = mailService.sendSimpleMessage(mailTestDto.getEmail());
        System.out.println(confirm);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //회원가입
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity createMember(@Valid @RequestPart(value = "key")MemberPostDto memberPostDto,
                                       @RequestParam(value = "image")MultipartFile image) throws IOException{

        return null;
    }


    //회원정보 수정
    @PatchMapping()
    public ResponseEntity updateMember(@Valid @RequestPart(value = "key")MemberPatchDto memberPatchDto,
                                       @RequestParam(value = "image")MultipartFile image) throws IOException{
        return null;
    }

    //회원 조회


}
