package org.example.message_service.exception;

import org.example.commonUtils.exception.ICustomizeErrorCode;

public enum CustomizeErrorCode implements ICustomizeErrorCode {


    MSG_SENT_EXCEPTION(200, "fail to send error, please try later"),

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
