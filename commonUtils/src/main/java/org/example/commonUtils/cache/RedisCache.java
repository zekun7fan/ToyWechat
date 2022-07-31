package org.example.commonUtils.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.print.DocFlavor;
import java.beans.ParameterDescriptor;
import java.util.List;

public class RedisCache {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    private final static String TOPIC = "TOPIC#";
    private final static String POST_CONTENT = "POST_CONTENT#";
    private final static String POST_LIKE = "POST_LIKE#";
    private final static String USER = "USER#";


    private String getUserTopicKey(String uid){
        return TOPIC + uid;
    }

    private String getPostContentKey(String pid){
        return POST_CONTENT + pid;
    }

    private String getPostLikeKey(String pid){
        return POST_LIKE + pid;
    }

    private String getUserKey(String uid){
        return USER + uid;
    }


    public void deleteUserTopicList(String uid){
        redisTemplate.delete(getUserTopicKey(uid));
    }

//    public List<String> getUserTopicList(String uid){
//        return (List<String>) redisTemplate.opsForList().range(getUserTopicKey(uid), 0, -1);
//    }











}
