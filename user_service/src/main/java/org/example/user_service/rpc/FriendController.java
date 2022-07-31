package org.example.user_service.rpc;


import org.example.commonUtils.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Component
@FeignClient(value = "friend-service")
@RequestMapping("/friend_service")
public interface FriendController {


    @GetMapping("{uid}/friend_topic")
    public Response<List<String>> getFriendTopic(@PathVariable("uid")String uid);



    @GetMapping("friend_relation")
    public Response<Boolean> isFriend(@RequestParam("uid") String uid, @RequestParam("fid") String fid);

}
