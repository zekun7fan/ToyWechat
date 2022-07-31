package org.example.message_service.controller;


import org.example.commonUtils.dto.Message;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.exception.CustomizeErrorCode;
import org.example.message_service.rpc.UserController;
import org.example.message_service.service.MessageService;
import org.example.commonUtils.entity.Response;
import org.example.commonUtils.utils.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message_service")
public class MessageController {

    @Autowired
    private MessageService service;

    @Autowired
    private UserController userController;


    @PostMapping("/message")
    public Response<Boolean> sendMessage(@RequestBody Message message){
        boolean b = service.sendMsg(message);
        return new ResponseBuilder<Boolean>().data(b).build();
    }



    @GetMapping("/message")
    public Response<List<Message>> retrieveMessage(
            @RequestParam("uid") String uid ){
        long t1 = System.currentTimeMillis();
        List<Message> list = service.retrieveMsg(uid);
        long t2 = System.currentTimeMillis();
        System.out.println("retrieveMessage--->" + (t2-t1));
        return new ResponseBuilder<List<Message>>().data(list).build();

    }



    @GetMapping("/conditional_message")
    public Response<List<Message>> retrieveMessageByOffset(
            @RequestParam("uid") String uid,
            @RequestParam("topic") String topic,
            @RequestParam("offset") long offset,
            @RequestParam("dir") String dir){
        List<Message> list = new ArrayList<>();
        if ("after".equals(dir)){
            list = service.retrieveMsgAfterOffset(uid, topic, offset);
        }else if ("before".equals(dir)){
            list = service.retrieveMsgBeforeOffset(uid, topic, offset);
        }else if ("newest".equals(dir)){
            list = service.retrieveNewestMsg(uid, topic);
        }
        if (list == null){
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        return new ResponseBuilder<List<Message>>().data(list).build();

    }




    @DeleteMapping("/consumer")
    public Response<Boolean> removeConsumer(@RequestParam("uid") String uid) {
        boolean res = service.removeConsumer(uid);
        return new ResponseBuilder<Boolean>().data(res).build();
    }

}
