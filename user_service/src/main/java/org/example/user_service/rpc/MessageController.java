package org.example.user_service.rpc;

import org.example.commonUtils.dto.Message;
import org.example.commonUtils.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient(value = "message-service")
@RequestMapping("/message_service")
public interface MessageController {


    @DeleteMapping("/consumer")
    public Response<Boolean> removeConsumer(@RequestParam("uid") String uid);


}
