package com.dohyeong.preorder.domain.post.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

public class PostResponseDto {
    @Getter
    @Builder
    public static class createResponseDto{
        private Long post_id;
        private Long member_id;
        private String title;
        private String body;
    }
}
