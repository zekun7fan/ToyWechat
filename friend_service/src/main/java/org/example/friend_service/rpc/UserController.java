package org.example.friend_service.rpc;


import org.example.commonUtils.entity.Response;
import org.example.commonUtils.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "user-service")
@RequestMapping("/user_service")
public interface UserController {

    @PostMapping("/user")
    public Response<List<User>> getUserListByUserId(@RequestBody List<String> userIdList);


}
