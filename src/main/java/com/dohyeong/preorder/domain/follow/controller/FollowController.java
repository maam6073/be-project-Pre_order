package com.dohyeong.preorder.domain.follow.controller;

import com.dohyeong.preorder.domain.follow.service.FollowService;
import com.dohyeong.preorder.domain.follow.dto.FollowPostDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;

    //회원 팔로우
    @PostMapping()
    public ResponseEntity followMember(@Valid @RequestBody FollowPostDto followPostDto){
        followService.follow(followPostDto.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
