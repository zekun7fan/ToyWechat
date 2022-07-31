package org.example.post_content_service.rpc;


import org.example.commonUtils.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "friend-service")
@RequestMapping("/friend_service")
public interface FriendController {

    @GetMapping("/post_visibility")
    public Response<Boolean> getVisibility(@RequestParam("uid")String uid, @RequestParam("friendId")String friendId);
}
