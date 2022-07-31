package org.example.request_service.rpc;

import org.example.commonUtils.dto.Message;
import org.example.commonUtils.entity.Response;
import org.example.commonUtils.utils.ResponseBuilder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@FeignClient(value = "message-service")
@RequestMapping("/message_service")
public interface MessageController {


    @PostMapping("/message")
    public Response<Boolean> sendMessage(@RequestBody Message message);


}
