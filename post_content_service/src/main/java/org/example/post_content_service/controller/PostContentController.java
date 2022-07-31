package org.example.post_content_service.controller;


import org.example.commonUtils.entity.Response;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.utils.ResponseBuilder;
import org.example.commonUtils.entity.PostContent;
import org.example.post_content_service.dto.DiscoveryResult;
import org.example.post_content_service.exception.CustomizeErrorCode;
import org.example.post_content_service.rpc.FriendController;
import org.example.post_content_service.service.PostContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post_content_service")
public class PostContentController {

    @Autowired
    private PostContentService service;

    @Autowired
    private FriendController friendController;

    @PostMapping("/{uid}/postContent")
    public Response<PostContent> addPostContent(@PathVariable("uid") String uid, @RequestBody PostContent content) {
        PostContent postContent = service.addPostContent(content);
        return new ResponseBuilder<PostContent>().data(postContent).build();
    }


    @DeleteMapping("/{uid}/postContent")
    public Response<Object> delPostContent(@PathVariable("uid") String uid, @RequestParam("pid") String pid) {
        service.deletePostContent(uid, pid);
        return new ResponseBuilder<>().build();

    }


    @GetMapping("/{friend_id}/postContent")
    public Response<List<PostContent>> getPostContentList(
            @PathVariable("friend_id") String friendId,
            @RequestParam("id") Integer id,
            @RequestParam("dir") String dir) {
        List<PostContent> list = new ArrayList<>();
        if ("new".equals(dir)) {
            list = service.get10NewPostContentList(friendId, id);
        } else if ("old".equals(dir)) {
            list = service.get10OldPostContentList(friendId, id);
        }
        return new ResponseBuilder<List<PostContent>>().data(list).build();
    }


    @PostMapping("/{uid}/discovery")
    public Response<DiscoveryResult> discoveryPostContent(
            @PathVariable("uid") String uid,
            @RequestParam("dir") String dir,
            @RequestBody Map<String, Integer> map) {


//        HashMap<String, Integer> map1 = new HashMap<>();
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            map1.put(entry.getKey(), (Integer) entry.getValue());
//        }


        DiscoveryResult result = null;
        if ("new".equals(dir)) {
            result = service.discoveryNewPostContents(map);
        } else if ("old".equals(dir)) {
            result = service.DiscoveryOldPostContents(map);
        } else {
            throw new CustomException(CustomizeErrorCode.PARAM_FORMAT_EXCEPTION);
        }
        if (result == null) {
            throw new CustomException(CustomizeErrorCode.DISCOVERY_NO_DATA_EXCEPTION);
        }
        return new ResponseBuilder<DiscoveryResult>().data(result).build();
    }


}
