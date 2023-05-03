package com.example.authservice.exception;

import com.example.authservice.enumeration.ErrorCode;
import com.example.authservice.exception.error.ApiError;
import lombok.Getter;

public class GlobalException extends RuntimeException {

    @Getter
    private ApiError apiError;

    public GlobalException(ErrorCode errorCode) {
        apiError = new ApiError();
        apiError.setCode(errorCode.getCode());
        apiError.setMessage(apiError.getMessage());
    }

    public GlobalException() {

    }
}
