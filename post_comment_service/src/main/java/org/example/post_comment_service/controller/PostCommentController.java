package org.example.post_comment_service.controller;


import org.example.commonUtils.entity.Response;
import org.example.commonUtils.utils.ResponseBuilder;
import org.example.commonUtils.entity.PostComment;
import org.example.post_comment_service.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post_comment_service")
public class PostCommentController {

    @Autowired
    private PostCommentService service;

    @PostMapping("/{pid}/comment")
    public Response<PostComment> addComment(@RequestBody PostComment comment){
        PostComment postComment = service.addComment(comment);
        return new ResponseBuilder<PostComment>().data(postComment).build();
    }

    @DeleteMapping("/{pid}/comment")
    public Response<Object> deleteComment(@PathVariable("pid") String pid, @RequestParam("cid") String cid){
        service.deleteComment(pid, cid);
        return new ResponseBuilder<>().build();
    }


    @GetMapping("/{pid}/comment")
    public Response<List<PostComment>> getNewComments(
            @PathVariable("pid") String pid,
            @RequestParam("id") Integer id){
        List<PostComment> comments = service.getNewComments(pid, id);
        return new ResponseBuilder<List<PostComment>>().data(comments).build();
    }
}
