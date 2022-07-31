package org.example.friend_service.controller;


import org.example.commonUtils.entity.Friend;
import org.example.commonUtils.entity.Response;
import org.example.commonUtils.entity.User;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.utils.ResponseBuilder;
import org.example.friend_service.exception.CustomizeErrorCode;
import org.example.friend_service.rpc.MessageController;
import org.example.friend_service.rpc.UserController;
import org.example.friend_service.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/friend_service")
public class FriendController {

    @Autowired
    private FriendService service;

    @Autowired
    private UserController userController;

    @Autowired
    private MessageController messageController;

    @GetMapping("/{uid}/visible_friends")
    public Response<List<String>> getVisibleFriendId(@PathVariable("uid") String uid){
        List<String> list = service.getVisibleFriendsId(uid);
        return new ResponseBuilder<List<String>>().data(list).build();
    }


    @GetMapping("/{uid}/friend")
    public Response<List<Friend>> getFriendList(@PathVariable("uid") String uid){
        List<Friend> friendList = service.getFriendList(uid);
        return new ResponseBuilder<List<Friend>>().data(friendList).build();
    }



    @GetMapping("/{uid}/friend_info")
    public Response<List<User>> getFriendInfo(@PathVariable("uid") String uid){
        List<String> userIdList = service.getFriendList(uid).stream().map(Friend::getFriendId).collect(Collectors.toList());
        List<User> userList = userController.getUserListByUserId(userIdList).getData();
        return new ResponseBuilder<List<User>>().data(userList).build();
    }



    @GetMapping("/post_visibility")
    public Response<Boolean> getVisibility(@RequestParam("uid")String uid, @RequestParam("fid") String friendId){
        boolean visibility = service.getVisibility(uid, friendId);
        return new ResponseBuilder<Boolean>().data(visibility).build();
    }


    @GetMapping("{uid}/friend_topic")
    public Response<List<String>> getFriendTopic(@PathVariable("uid")String uid){
        List<String> list = service.getFriendTopic(uid);
        return new ResponseBuilder<List<String>>().data(list).build();
    }


    @DeleteMapping("{uid}/friend")
    public Response<Boolean> deleteFriend(@PathVariable("uid") String uid, @RequestParam("fid") String fid){
        boolean b = service.deleteFriend(uid, fid);
        if (b) {
            b = messageController.removeConsumer(uid).getData();
            b = messageController.removeConsumer(fid).getData();
        }
        return new ResponseBuilder<Boolean>().data(b).build();
    }


    @PostMapping("{uid}/friend")
    public Response<Boolean> addFriend(@PathVariable("uid") String uid, @RequestParam("fid") String fid){
        boolean b = false;
        b = service.addFriend(uid, fid);
        if (b) {
            b = messageController.removeConsumer(uid).getData();
            b = messageController.removeConsumer(fid).getData();
        }
        if (!b){
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        return new ResponseBuilder<Boolean>().data(b).build();
    }


    @GetMapping("/relation")
    public Response<Friend> getRelation(@RequestParam("uid") String uid, @RequestParam("fid") String fid){
        Friend friend = service.getFriend(uid, fid);
        return new ResponseBuilder<Friend>().data(friend).build();
    }



    @PutMapping("/friend_visibility")
    public Response<Boolean> updateFriendVisibility(@RequestBody Friend friend){
        boolean b = service.updateFriendVisibility(friend);
        return new ResponseBuilder<Boolean>().data(b).build();
    }


}






