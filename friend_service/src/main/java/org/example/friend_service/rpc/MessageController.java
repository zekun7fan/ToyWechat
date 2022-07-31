package org.example.friend_service.rpc;


import org.example.commonUtils.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "message-service")
@RequestMapping("/message_service")
public interface MessageController {

    @DeleteMapping("/consumer")
    public Response<Boolean> removeConsumer(@RequestParam("uid") String uid);


}
