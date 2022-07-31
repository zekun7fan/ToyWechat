package org.example.friend_service.exception;

import org.example.commonUtils.exception.ICustomizeErrorCode;

public enum CustomizeErrorCode implements ICustomizeErrorCode {


    SYSTEM_EXCEPTION(200, "system error, please try later"),

    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private final Integer code;
    private final String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
