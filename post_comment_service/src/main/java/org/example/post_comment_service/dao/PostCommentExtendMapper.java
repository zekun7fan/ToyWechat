package org.example.post_comment_service.dao;

import org.apache.ibatis.annotations.Param;
import org.example.commonUtils.entity.PostComment;
import org.example.commonUtils.entity.PostCommentExample;

import java.util.List;

public interface PostCommentExtendMapper {


    List<PostComment> getPostCommentsAfterID(@Param("pid") String pid, @Param("id") Integer id);
}