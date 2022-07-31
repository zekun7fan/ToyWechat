package org.example.request_service.controller;


import org.example.commonUtils.entity.Request;
import org.example.commonUtils.entity.Response;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.utils.ResponseBuilder;
import org.example.request_service.enumType.ReqDirection;
import org.example.request_service.enumType.ReqStatus;
import org.example.request_service.exception.CustomizeErrorCode;
import org.example.request_service.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request_service")
public class RequestController {

    @Autowired
    private RequestService service;


    @PostMapping("/request")
    public Response<Boolean> sendRequest(@RequestBody Request request){
        boolean b = service.addRequest(request);
        return new ResponseBuilder<Boolean>().data(b).build();
    }



    @PutMapping("/request")
    public Response<Boolean> handleRequest(@RequestBody Request request){
        boolean b = service.updateRequest(request);
        return new ResponseBuilder<Boolean>().data(b).build();
    }


    @GetMapping("/request")
    public Response<List<Request>> getRequests(
            @RequestParam("uid") String uid,
            @RequestParam("dir") Integer dir,
            @RequestParam("status") Integer status){
        List<Request> list = null;
        if (ReqDirection.SENT.getVal().equals(dir) && ReqStatus.PENDING.getVal().equals(status)){
            list = service.getSentAndPendingRequests(uid);
        }
        if (ReqDirection.SENT.getVal().equals(dir) && !ReqStatus.PENDING.getVal().equals(status)){
            list = service.getSentAndFinishedRequests(uid);
        }
        if (ReqDirection.HANDLE.getVal().equals(dir) && ReqStatus.PENDING.getVal().equals(status)){
            list = service.getHandledAndPendingRequests(uid);
        }
        if (ReqDirection.HANDLE.getVal().equals(dir) && !ReqStatus.PENDING.getVal().equals(status)){
            list = service.getHandledAndFinishedRequests(uid);
        }
        if (list == null){
            throw new CustomException(CustomizeErrorCode.SYSTEM_ERROR_EXCEPTION);
        }
        return new ResponseBuilder<List<Request>>().data(list).build();
    }




}



