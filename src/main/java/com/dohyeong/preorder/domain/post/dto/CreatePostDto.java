package com.dohyeong.preorder.domain.post.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CreatePostDto {
    @Length(max = 20)
    private String title;


    @Length(max = 150)
    private String body;
}
