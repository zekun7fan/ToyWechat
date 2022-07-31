package org.example.request_service.rpc;


import org.example.commonUtils.entity.Response;
import org.example.commonUtils.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "user-service")
@RequestMapping("/user_service")
public interface UserController {

    @GetMapping("/user")
    public Response<User> getUserById(@RequestParam("uid") String uid);


}
