package org.example.post_content_service.dao;

import org.apache.ibatis.annotations.Param;
import org.example.commonUtils.entity.PostContent;
import org.example.commonUtils.entity.PostContentExample;

import java.util.List;

public interface PostContentExtendMapper {


    List<PostContent> get10PostContentListAfterID(@Param("uid") String uid, @Param("id") Integer id);

    List<PostContent> get1PostContentListAfterID(@Param("uid") String uid, @Param("id") Integer id);


    List<PostContent> get10PostContentListBeforeID(@Param("uid") String uid, @Param("id") Integer id);

    List<PostContent> get1PostContentListBeforeID(@Param("uid") String uid, @Param("id") Integer id);
}