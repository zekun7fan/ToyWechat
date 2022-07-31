package org.example.post_like_service.service;


import org.example.commonUtils.exception.CustomException;
import org.example.post_like_service.dao.PostLikeMapper;
import org.example.commonUtils.entity.PostLike;
import org.example.commonUtils.entity.PostLikeExample;
import org.example.post_like_service.exception.CustomizeErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostLikeService {

    @Autowired
    private PostLikeMapper mapper;


    public void likePost(String uid, String pid){
        PostLike postLike = new PostLike();
        postLike.setUserId(uid);
        postLike.setPostContentId(pid);
        postLike.setCreateTime(LocalDateTime.now());
        int insert = mapper.insert(postLike);
        if (insert == 0){
            throw new CustomException(CustomizeErrorCode.POST_LIKE_EXCEPTION);
        }
    }

    public void unlikePost(String uid, String pid){
        PostLikeExample example = new PostLikeExample();
        example.createCriteria().andUserIdEqualTo(uid).andPostContentIdEqualTo(pid);
        int i = mapper.deleteByExample(example);
        if (i == 0){
            throw new CustomException(CustomizeErrorCode.POST_UNLIKE_EXCEPTION);
        }
    }

    public List<String> getUserIdListUnderPostLike(String pid){
        PostLikeExample example = new PostLikeExample();
        example.createCriteria().andPostContentIdEqualTo(pid);
        return mapper.selectByExample(example).stream().map(PostLike::getUserId).collect(Collectors.toList());
    }


}
