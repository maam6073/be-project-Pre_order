package com.dohyeong.preorder.domain.follow.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class FollowPostDto {
    @NotBlank @Getter
    private String name;
}
