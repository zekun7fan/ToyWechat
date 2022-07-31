package org.example.post_content_service.exception;

import org.example.commonUtils.exception.ICustomizeErrorCode;

public enum CustomizeErrorCode  implements ICustomizeErrorCode {


    POST_DELETION_EXCEPTION(200, "post content does not exist"),
    POST_INSERTION_EXCEPTION(200, "fail to insert new post"),
    POST_QUERY_EXCEPTION(200, "you have no permission to these posts"),
    PARAM_FORMAT_EXCEPTION(200, "params format incorrect"),
    DISCOVERY_NO_DATA_EXCEPTION(200, "no anymore posts found"),

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
