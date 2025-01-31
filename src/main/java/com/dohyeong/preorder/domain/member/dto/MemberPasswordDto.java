package com.dohyeong.preorder.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class MemberPasswordDto {
    @Getter
    @NotBlank(message = "암호는 공백 없이 8-20자여야 합니다.")
    @Length(min = 8, max = 20)
    private String cur_password;


    @Getter
    @NotBlank(message = "암호는 공백 없이 8-20자여야 합니다.")
    @Length(min = 8, max = 20)
    private String alter_password;
}
