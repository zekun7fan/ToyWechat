package org.example.commonUtils.utils;


import org.example.commonUtils.constant.RespCodeConstant;
import org.example.commonUtils.constant.RespMessageConstant;
import org.example.commonUtils.entity.Response;

public class ResponseBuilder<T> {

    private Response<T> response;

    public ResponseBuilder(){
        response = new Response<>();
        response.setCode(RespCodeConstant.SUCCESS);
        response.setMessage(RespMessageConstant.OPERATE_SUCCESS);
        response.setData(null);
    }

    public ResponseBuilder<T> code(Integer code){
        response.setCode(code);
        return this;
    }

    public ResponseBuilder<T> message(String message){
        response.setMessage(message);
        return this;
    }

    public ResponseBuilder<T> data(T data){
        response.setData(data);
        return this;
    }

    public Response<T> build(){
        return response;
    }



}
