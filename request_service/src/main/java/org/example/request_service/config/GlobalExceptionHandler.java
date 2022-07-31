package org.example.request_service.config;


import com.alibaba.fastjson.JSONObject;
import org.example.commonUtils.constant.RespCodeConstant;
import org.example.commonUtils.constant.RespMessageConstant;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.utils.ResponseBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    void handle(CustomException e, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(e.getCode());
        try {
            PrintWriter writer = response.getWriter();
            String resp = JSONObject.toJSONString(new ResponseBuilder<>().code(RespCodeConstant.FAIL).message(RespMessageConstant.OPERATE_FAIL).build());
            writer.write(resp);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
