package org.example.post_like_service.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class PostLikeCache {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


//    public void delete(String pid){
//        redisTemplate.delete(pid);
//    }
//
//
//    public List<String> add(String pid, List<String> userIdList) {
//        redisTemplate.opsForList().leftPushAll(pid, (Set<String>) userIdList);
//    }
//
//
//    public List<String> get(String pid){
//    }
}
