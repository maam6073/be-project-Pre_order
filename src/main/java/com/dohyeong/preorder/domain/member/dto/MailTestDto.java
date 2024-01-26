package com.dohyeong.preorder.domain.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MailTestDto {
    @Email @NotBlank
    private String email;
}
