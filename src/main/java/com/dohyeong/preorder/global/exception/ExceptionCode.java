package com.dohyeong.preorder.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

    // 400 Bad Request (잘못된 요구)
    BAD_REQUEST(400, "Bad request - Check path"),
    NO_PERMISSION(400, "No permission"), //권한이 없는 사용자의 요청
    BAD_REQUEST_APPLY(400, "Writer cannot apply"),
    BAD_REQUEST_RECRUITING(400, "This content is not being recruited"),
    BAD_REQUEST_REVIEW(400, "Review can write when status is completed"),
    WRITE_NOT_ALLOWED(400, "Write not allowed"),
    EDIT_NOT_ALLOWED(400, "Edit not allowed"),
    DELETE_NOT_ALLOWED(400, "Delete not allowed"),
    ACCESS_NOT_ALLOWED(400, "Access not allowed"),
    INVALID_TOKEN(400, "Invalid token"),
    BAD_REQUEST_PW(400,"비밀번호가 맞지 않습니다."),
    BAD_REQUEST_FOLLOW(400,"Bad request follow"),

    // 401 (권한없음)
    MEMBER_STATUS_SECESSION(401, "현재 회원은 탈퇴된 상태입니다"),

    // 404
    NOT_FOUND_MEMBER(404, "Member not found"),
    NOT_FOUND_POST(404, "POST not found"),
    NOT_FOUND_COMMENT(404,"Comment not found"),

    // 409 (중복)
    EXISTS_MEMBER(409, "Member exists"),
    EXISTS_EMAIL(409, "This Email is already in use"),
    EXISTS_NICKNAME(409, "This nickname is already in use"),
    EXISTS_APPLY(409, "Applicant already applied"),
    EXISTS_REVIEW(409, "This member already wrote review");

    int code;
    String message;
}