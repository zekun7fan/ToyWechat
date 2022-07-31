package org.example.user_service.exception;

import org.example.commonUtils.exception.ICustomizeErrorCode;

public enum CustomizeErrorCode  implements ICustomizeErrorCode {


    USER_NOT_EXIST_EXCEPTION(200, "no user exist"),
    EMAIL_EXIST_EXCEPTION(200, "email exist, please try another one"),
    EMAIL_OR_PASSWORD_INCORRECT_EXCEPTION(200, "email or password is not correct"),
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

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
