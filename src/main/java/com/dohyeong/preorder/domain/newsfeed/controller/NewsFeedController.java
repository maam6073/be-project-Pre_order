package com.dohyeong.preorder.domain.newsfeed.controller;

import com.dohyeong.preorder.domain.newsfeed.dto.NewsFeedResponseDto;
import com.dohyeong.preorder.domain.newsfeed.service.NewsFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/newsfeed")
@RequiredArgsConstructor
public class NewsFeedController {

    private final NewsFeedService newsFeedService;

    @GetMapping()
    public ResponseEntity<List<NewsFeedResponseDto>> getNewsFeedByMember() {
        return new ResponseEntity<>(newsFeedService.getNewsFeedForMember(), HttpStatus.OK);
    }
}
