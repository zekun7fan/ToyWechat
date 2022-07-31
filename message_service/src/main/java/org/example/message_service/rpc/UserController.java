package org.example.message_service.rpc;


import org.example.commonUtils.entity.Response;
import org.example.commonUtils.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "user-service")
@RequestMapping("/user_service")
public interface UserController {

    @GetMapping("/{uid}/topic")
    public Response<List<String>> getUserTopicList(@PathVariable("uid") String uid);

}
