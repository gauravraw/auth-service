package com.example.authservice.enumeration;

import lombok.Getter;
import lombok.Setter;

public enum ErrorCode {

    EXP_001(100, "Database saving exception"), EXP_002(101, "UserName or Password is Empty"), EXP_003(102,
            "UserName or Password is Invalid");
    @Getter
    private final int code;

    @Getter
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
