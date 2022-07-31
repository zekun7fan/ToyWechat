package org.example.post_comment_service.service;


import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.utils.UUIDUtils;
import org.example.post_comment_service.dao.PostCommentMapper;
import org.example.commonUtils.entity.PostComment;
import org.example.commonUtils.entity.PostCommentExample;
import org.example.post_comment_service.exception.CustomizeErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostCommentService {

    @Autowired
    private PostCommentMapper mapper;

    public PostComment addComment(PostComment comment){
        comment.setPostCommentId(UUIDUtils.getRandomUUID());
        comment.setCreateTime(LocalDateTime.now());
        int insert = mapper.insert(comment);
        if (insert == 0){
            throw new CustomException(CustomizeErrorCode.POST_COMMENT_INSERTION_EXCEPTION);
        }
        return comment;
    }

    public void deleteComment(String pid, String cid){
        PostCommentExample example = new PostCommentExample();
        example.createCriteria().andPostContentIdEqualTo(pid).andPostCommentIdEqualTo(cid);
        int i = mapper.deleteByExample(example);
        if (i == 0){
            throw new CustomException(CustomizeErrorCode.POST_COMMENT_DELETION_EXCEPTION);
        }
    }


    public List<PostComment> getNewComments(String pid, Integer id){
        return mapper.getPostCommentsAfterID(pid, id);
    }


}
