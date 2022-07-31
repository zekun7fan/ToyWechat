package org.example.user_service.controller;


import org.example.commonUtils.entity.Response;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.exception.CustomizeErrorCode;
import org.example.commonUtils.utils.ResponseBuilder;
import org.example.user_service.dto.LoginedUserInfo;
import org.example.commonUtils.entity.User;
import org.example.user_service.dto.UserPicInfo;
import org.example.user_service.mongodb.PictureMapper;
import org.example.user_service.rpc.FriendController;
import org.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user_service")
public class UserController {

    @Autowired
    private UserService service;


    @Autowired
    private FriendController friendController;

    @Autowired
    private PictureMapper pictureMapper;


    @PutMapping("/toLogin")
    public Response<LoginedUserInfo> toLogin(@RequestBody User user){
        LoginedUserInfo loginedUserInfo = service.toLogin(user);
        return new ResponseBuilder<LoginedUserInfo>().data(loginedUserInfo).build();
    }

    @PostMapping("/toRegister")
    public Response<Object> toRegister(@RequestBody User user){
        service.toRegister(user);
        return new ResponseBuilder<>().build();

    }


    @DeleteMapping("/toLogout")
    public Response<LoginedUserInfo> toLogout(@RequestBody User user){
        LoginedUserInfo loginedUserInfo = service.toLogout(user);
        return new ResponseBuilder<LoginedUserInfo>().data(loginedUserInfo).build();
    }


    @PutMapping("/user")
    public Response<Boolean> updateUser(@RequestBody User user) {
        boolean res = service.updateUser(user);
        return new ResponseBuilder<Boolean>().data(res).build();
    }


    @GetMapping("/user/byemail")
    public Response<User> getUserByEmail(@RequestParam("email") String email){
        User user = service.getUserByEmail(email);
        return new ResponseBuilder<User>().data(user).build();
    }

    @GetMapping("/user/byid")
    public Response<User> getUserById(@RequestParam("uid") String uid){
        User user = service.getUserById(uid);
        return new ResponseBuilder<User>().data(user).build();
    }


    @PostMapping("/user")
    public Response<List<User>> getUserListByUserId(@RequestBody List<String> userIdList){
        List<User> list = service.getUserListByUserId(userIdList);
        return new ResponseBuilder<List<User>>().data(list).build();
    }


    @GetMapping("{uid}/topic")
    public Response<List<String>> getUserTopicList(@PathVariable("uid") String uid){
        List<String> list = friendController.getFriendTopic(uid).getData();
        list.add(uid);
        return new ResponseBuilder<List<String>>().data(list).build();
    }


    @GetMapping(
            value= "/pic/{str}/{uid}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPicture(@PathVariable("str") String str, @PathVariable("uid") String uid){
        String url = "pic/" + str + "/" + uid;
        return service.getPicture(url);
    }


    @PutMapping(value = "/{uid}/avatar")
    public Response<UserPicInfo> updateAvatar(@PathVariable("uid") String uid, @RequestParam("file") MultipartFile file){
        UserPicInfo info = null;
        try {
            info = service.updateUserAvatar(uid, file.getBytes());
        } catch (IOException e) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        return new ResponseBuilder<UserPicInfo>().data(info).build();
    }



    @PutMapping("/{uid}/background")
    public Response<UserPicInfo> updateBackGround(@PathVariable("uid") String uid, @RequestParam("file") MultipartFile file){
        UserPicInfo info = null;
        try {
            info = service.updateUserBackground(uid, file.getBytes());
        } catch (IOException e) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        return new ResponseBuilder<UserPicInfo>().data(info).build();
    }


}
