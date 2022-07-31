package org.example.user_service.service;


import org.example.commonUtils.entity.UserJwtPayload;
import org.example.commonUtils.exception.CustomException;
import org.example.commonUtils.utils.JwtUtils;
import org.example.commonUtils.utils.TimeUtils;
import org.example.commonUtils.utils.UUIDUtils;
import org.example.user_service.dao.UserMapper;
import org.example.user_service.dto.LoginedUserInfo;
import org.example.commonUtils.entity.User;
import org.example.commonUtils.entity.UserExample;
import org.example.user_service.dto.UserPicInfo;
import org.example.user_service.exception.CustomizeErrorCode;
import org.example.user_service.mongodb.PictureMapper;
import org.example.user_service.rpc.MessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper mapper;


    @Autowired
    private MessageController messageController;


    @Autowired
    private PictureMapper pictureMapper;

    public User getUserByEmail(String email){
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(email);
        List<User> users = mapper.selectByExample(example);
        if (users.isEmpty()){
            throw new CustomException(CustomizeErrorCode.USER_NOT_EXIST_EXCEPTION);
        }
        assert users.size() == 1;
        return users.get(0);
    }

    public User getUserById(String uid){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(uid);
        List<User> users = mapper.selectByExample(example);
        if (users.isEmpty()){
            throw new CustomException(CustomizeErrorCode.USER_NOT_EXIST_EXCEPTION);
        }
        assert users.size() == 1;
        return users.get(0);
    }

    public LoginedUserInfo toLogin(User user) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andEmailEqualTo(user.getEmail())
                .andPasswordEqualTo(user.getPassword());
        List<User> users = mapper.selectByExample(example);
        if (users.isEmpty()){
            throw new CustomException(CustomizeErrorCode.EMAIL_OR_PASSWORD_INCORRECT_EXCEPTION);
        }
        assert users.size() == 1;
        User u = users.get(0);
        UserJwtPayload userJwtPayload = new UserJwtPayload(u.getUserId(), TimeUtils.after30days());
        String token = JwtUtils.createToken(userJwtPayload);
        return new LoginedUserInfo(u.getUserId(), u.getName(), token);

    }


    public void toRegister(User user){
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(user.getEmail());
        List<User> users = mapper.selectByExample(example);
        if (!users.isEmpty()){
            throw new CustomException(CustomizeErrorCode.EMAIL_EXIST_EXCEPTION);
        }
        user.setUserId(UUIDUtils.getRandomUUID());
        user.setCreateTime(LocalDateTime.now());
        user.setAvatarUrl("");
        user.setBackgroundUrl("");
        int insert = mapper.insert(user);
        if (insert == 0){
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
    }

    public LoginedUserInfo toLogout(User user){
        messageController.removeConsumer(user.getUserId());
        UserJwtPayload userJwtPayload = new UserJwtPayload(user.getUserId(), TimeUtils.before1day());
        String token = JwtUtils.createToken(userJwtPayload);
        return new LoginedUserInfo(user.getUserId(), user.getName(), token);
    }

    public List<User> getUserListByUserId(List<String> userIdList){
        if (userIdList == null || userIdList.isEmpty()) {
            return new ArrayList<>();
        }
        UserExample example = new UserExample();
        example.createCriteria().andUserIdIn(userIdList);
        return mapper.selectByExample(example);
    }

    public boolean updateUser(User user) {
        int cnt = mapper.updateByPrimaryKeySelective(user);
        return cnt == 1;
    }

    public UserPicInfo updateUserAvatar(String uid, byte[] data) {
        String url = "pic/avatar/" + uid;
        UserPicInfo info = new UserPicInfo(url, data);
        pictureMapper.deleteUserPicInfoByUrl(url);
        pictureMapper.save(info);
        User user = new User();
        user.setUserId(uid);
        user.setAvatarUrl(url);
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(uid);
        mapper.updateByExampleSelective(user, example);
        return info;
    }

    public UserPicInfo updateUserBackground(String uid, byte[] data) {
        String url = "pic/bg/" + uid;
        UserPicInfo info = new UserPicInfo(url, data);
        pictureMapper.save(info);
        return info;
    }

    public byte[] getPicture(String url) {
        UserPicInfo info = pictureMapper.findUserPicInfoByUrl(url);
        if (info == null) {
            throw new CustomException(CustomizeErrorCode.SYSTEM_EXCEPTION);
        }
        return info.getData();
    }


}
