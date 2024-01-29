package com.dohyeong.preorder.global.exception;

import java.util.List;

public class ErrorResponse {
    private int status;
    private String message;

    private ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
