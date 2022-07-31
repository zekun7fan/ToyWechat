package org.example.request_service.rpc;


import org.example.commonUtils.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "friend-service")
@RequestMapping("/friend_service")
public interface FriendController {


    @PostMapping("{uid}/friend")
    public Response<Boolean> addFriend(@PathVariable("uid") String uid, @RequestParam("fid") String fid);


}