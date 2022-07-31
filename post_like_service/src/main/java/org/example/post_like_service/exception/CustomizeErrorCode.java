package org.example.post_like_service.exception;

import org.example.commonUtils.exception.ICustomizeErrorCode;

public enum CustomizeErrorCode  implements ICustomizeErrorCode {


    POST_LIKE_EXCEPTION(200, "system error, please try later"),
    POST_UNLIKE_EXCEPTION(200, "system error, please try later"),

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
