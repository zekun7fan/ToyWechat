package org.example.post_content_service.service;


import org.example.commonUtils.entity.FriendExample;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.utils.UUIDUtils;
import org.example.post_content_service.dao.PostContentMapper;
import org.example.commonUtils.entity.PostContent;
import org.example.commonUtils.entity.PostContentExample;
import org.example.post_content_service.dto.DiscoveryResult;
import org.example.post_content_service.exception.CustomizeErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostContentService {

    @Autowired
    private PostContentMapper mapper;

    public PostContent addPostContent(PostContent content){
        content.setPostContentId(UUIDUtils.getRandomUUID());
        content.setCreateTime(LocalDateTime.now());
        int insert = mapper.insert(content);
        if (insert == 0){
            throw new CustomException(CustomizeErrorCode.POST_INSERTION_EXCEPTION);
        }
        return content;
    }

    public void deletePostContent(String uid, String pid){
        PostContentExample example = new PostContentExample();
        example.createCriteria().andUserIdEqualTo(uid).andPostContentIdEqualTo(pid);
        int i = mapper.deleteByExample(example);
        if (i == 0){
            throw new CustomException(CustomizeErrorCode.POST_DELETION_EXCEPTION);
        }
    }

    public List<PostContent> get10NewPostContentList(String uid, Integer id){
        return mapper.get10PostContentListAfterID(uid, id);
    }


    public List<PostContent> get10OldPostContentList(String uid, Integer id){
        return mapper.get10PostContentListBeforeID(uid, id);
    }


    private PostContent get1NewPostContent(String uid, Integer id){
        List<PostContent> list = mapper.get1PostContentListAfterID(uid, id);
        if (list == null || list.isEmpty()){
            return null;
        }
        return list.get(0);
    }


    private PostContent get1OldPostContent(String uid, Integer id){
        List<PostContent> list = mapper.get1PostContentListBeforeID(uid, id);
        if (list == null || list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public DiscoveryResult discoveryNewPostContents(Map<String, Integer> map){
        PriorityQueue<PostContent> q = new PriorityQueue<>(new Comparator<PostContent>() {
            @Override
            public int compare(PostContent o1, PostContent o2) {
                return Integer.compare(o2.getId(), o1.getId());
            }
        });
        ArrayList<PostContent> resList = new ArrayList<>();
        HashMap<String, Integer> resMap = new HashMap<>(map);

        int available = map.size();
        int limit = 10;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            PostContent postContent = get1NewPostContent(entry.getKey(), entry.getValue());
            if (postContent != null){
                q.offer(postContent);
            }else{
                available--;
            }
        }
        while (resList.size() < limit && available > 0){
            PostContent first = q.poll();
            resList.add(first);
            resMap.put(first.getUserId(), first.getId());
            PostContent p = get1NewPostContent(first.getUserId(), first.getId());
            if (p != null){
                q.offer(p);
            }else{
                available--;
            }
        }
        return new DiscoveryResult(resMap, resList);
    }

    public DiscoveryResult DiscoveryOldPostContents(Map<String, Integer> map){
        PriorityQueue<PostContent> q = new PriorityQueue<>(new Comparator<PostContent>() {
            @Override
            public int compare(PostContent o1, PostContent o2) {
                return Integer.compare(o2.getId(), o1.getId());
            }
        });
        ArrayList<PostContent> resList = new ArrayList<>();
        HashMap<String, Integer> resMap = new HashMap<>(map);

        int available = map.size();
        int limit = 10;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            PostContent postContent = get1OldPostContent(entry.getKey(), entry.getValue());
            if (postContent != null){
                q.offer(postContent);
            }else{
                available--;
            }
        }
        while (resList.size() < limit && available > 0){
            PostContent first = q.poll();
            resList.add(first);
            resMap.put(first.getUserId(), first.getId());
            PostContent p = get1OldPostContent(first.getUserId(), first.getId());
            if (p != null){
                q.offer(p);
            }else{
                available--;
            }
        }
        return new DiscoveryResult(resMap, resList);

    }

}
