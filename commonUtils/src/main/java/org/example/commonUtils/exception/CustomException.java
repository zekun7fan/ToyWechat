package org.example.commonUtils.exception;

public class CustomException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }


}
