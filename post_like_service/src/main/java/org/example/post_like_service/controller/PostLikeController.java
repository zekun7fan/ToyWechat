package org.example.post_like_service.controller;


import org.example.commonUtils.entity.Response;
import org.example.commonUtils.entity.User;
import org.example.commonUtils.utils.ResponseBuilder;
import org.example.post_like_service.rpc.UserController;
import org.example.post_like_service.service.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post_like_service")
public class PostLikeController {


    @Autowired
    private PostLikeService service;

    @Autowired
    private UserController userController;

    @PostMapping("/{pid}/postLike")
    public Response<Object> likePost(@RequestParam("uid") String uid, @PathVariable("pid") String pid){
        service.likePost(uid, pid);
        return new ResponseBuilder<Object>().build();
    }

    @DeleteMapping("/{pid}/postLike")
    public Response<Object> unlikePost(@RequestParam("uid") String uid, @PathVariable("pid") String pid){
        service.unlikePost(uid, pid);
        return new ResponseBuilder<Object>().build();
    }


    @GetMapping("/{pid}/postLike")
    public Response<List<String>> getLikedUserIdList(@PathVariable("pid") String pid){
        List<String> userIdList = service.getUserIdListUnderPostLike(pid);
        return new ResponseBuilder<List<String>>().data(userIdList).build();
    }

}
