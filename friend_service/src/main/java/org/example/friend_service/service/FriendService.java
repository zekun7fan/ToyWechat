package org.example.friend_service.service;


import org.example.commonUtils.entity.Friend;
import org.example.commonUtils.entity.FriendExample;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.exception.CustomizeErrorCode;
import org.example.commonUtils.utils.UUIDUtils;
import org.example.friend_service.dao.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendService {

    @Autowired
    private FriendMapper friendMapper;



    public List<String> getVisibleFriendsId(String uid){
        FriendExample example1 = new FriendExample();
        example1.createCriteria()
                .andUserIdEqualTo(uid)
                .andBlockOppositeEqualTo(false);
        // friends who I am willing to see
        List<String> friendIdList1 = friendMapper.selectByExample(example1).stream().map(Friend::getFriendId).collect(Collectors.toList());

        FriendExample example2 = new FriendExample();
        example2.createCriteria()
                .andFriendIdEqualTo(uid)
                .andHideMyselfEqualTo(false);

        // friends who allow me to see
        List<String> friendIdList2 = friendMapper.selectByExample(example2).stream().map(Friend::getUserId).collect(Collectors.toList());

        friendIdList1.retainAll(friendIdList2);
        friendIdList1.add(uid);
        return friendIdList1;
    }




    public List<Friend> getFriendList(String uid){
        FriendExample example = new FriendExample();
        example.createCriteria()
                .andUserIdEqualTo(uid);
        return friendMapper.selectByExample(example);
    }


    public Friend getFriend(String uid, String fid){
        FriendExample example = new FriendExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andFriendIdEqualTo(fid);
        List<Friend> list = friendMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }


    public boolean getVisibility(String uid, String friendId) {
        if (uid.equals(friendId)){
            return true;
        }
        FriendExample example1 = new FriendExample();
        example1.createCriteria()
                .andUserIdEqualTo(uid)
                .andFriendIdEqualTo(friendId)
                .andBlockOppositeEqualTo(false)
                .andValidEqualTo(true);
        List<Friend> friends1 = friendMapper.selectByExample(example1);
        FriendExample example2 = new FriendExample();
        example2.createCriteria()
                .andUserIdEqualTo(friendId)
                .andFriendIdEqualTo(uid)
                .andHideMyselfEqualTo(false)
                .andValidEqualTo(true);
        List<Friend> friends2 = friendMapper.selectByExample(example2);
        return !friends1.isEmpty() && !friends2.isEmpty();

    }



    public List<String> getFriendTopic(String uid){
        FriendExample example = new FriendExample();
        example.createCriteria().andUserIdEqualTo(uid);
        return friendMapper.selectByExample(example).stream().map(Friend::getTopicId).collect(Collectors.toList());
    }


    public boolean deleteFriend(String uid, String fid){
        FriendExample example1 = new FriendExample();
        FriendExample example2 = new FriendExample();
        example1.createCriteria()
                .andUserIdEqualTo(uid)
                .andFriendIdEqualTo(fid);
        List<Friend> list1 = friendMapper.selectByExample(example1);
        if (list1.size() != 1) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        if (friendMapper.deleteByPrimaryKey(list1.get(0).getId(), uid, fid) != 1) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }

        example2.createCriteria()
                .andUserIdEqualTo(fid)
                .andFriendIdEqualTo(uid);
        List<Friend> list2 = friendMapper.selectByExample(example2);
        if (list2.isEmpty()) {
            return true;
        }
        if (list2.size() != 1) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        Friend friend = list2.get(0);
        friend.setValid(false);
        if (friendMapper.updateByPrimaryKeySelective(friend) != 1) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        return true;
    }





    public boolean addFriend(String uid1, String uid2) {

        FriendExample example1 = new FriendExample();
        FriendExample example2 = new FriendExample();
        example1.createCriteria()
                .andUserIdEqualTo(uid1)
                .andFriendIdEqualTo(uid2);
        example2.createCriteria()
                .andUserIdEqualTo(uid2)
                .andFriendIdEqualTo(uid1);
        List<Friend> list1 = friendMapper.selectByExample(example1);
        List<Friend> list2 = friendMapper.selectByExample(example2);
        if (!list1.isEmpty() && !list2.isEmpty()){
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        if (list1.size() == 1) {
            Friend f1 = list1.get(0);
            f1.setValid(true);
            Friend f2 = new Friend();
            f2.setUserId(uid2);
            f2.setFriendId(uid1);
            f2.setTopicId(f1.getTopicId());
            f2.setHideMyself(false);
            f2.setBlockOpposite(false);
            f2.setInChatting(true);
            f2.setValid(true);
            int n1 = friendMapper.updateByPrimaryKeySelective(f1);
            int n2 = friendMapper.insert(f2);
            if (n1 != 1 || n2 != 1) {
                throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
            }
            return true;
        }
        if (list2.size() == 1) {
            Friend f2 = list2.get(0);
            f2.setValid(true);
            Friend f1 = new Friend();
            f1.setUserId(uid1);
            f1.setFriendId(uid2);
            f1.setTopicId(f2.getTopicId());
            f1.setHideMyself(false);
            f1.setBlockOpposite(false);
            f1.setInChatting(true);
            f1.setValid(true);
            int n2 = friendMapper.updateByPrimaryKeySelective(f2);
            int n1 = friendMapper.insert(f1);
            if (n1 != 1 || n2 != 1) {
                throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
            }
            return true;
        }
        return addFullFriend(uid1, uid2);
    }


    private boolean addFullFriend(String uid1, String uid2){
        String topic = UUIDUtils.getRandomUUID();
        Friend friend1 = new Friend();
        friend1.setUserId(uid1);
        friend1.setFriendId(uid2);
        friend1.setTopicId(topic);
        friend1.setHideMyself(false);
        friend1.setBlockOpposite(false);
        friend1.setInChatting(true);
        friend1.setValid(true);

        Friend friend2 = new Friend();
        friend2.setUserId(uid2);
        friend2.setFriendId(uid1);
        friend2.setTopicId(topic);
        friend2.setHideMyself(false);
        friend2.setBlockOpposite(false);
        friend2.setInChatting(true);
        friend2.setValid(true);
        if (friendMapper.insert(friend1) != 1){
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        if (friendMapper.insert(friend2) != 1){
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        return true;
    }



    public boolean updateFriendVisibility(Friend friend){
        if (friendMapper.updateByPrimaryKeySelective(friend) != 1){
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        return true;
    }
}


