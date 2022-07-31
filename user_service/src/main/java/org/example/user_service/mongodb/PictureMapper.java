package org.example.user_service.mongodb;


import org.example.user_service.dto.UserPicInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PictureMapper extends MongoRepository<UserPicInfo, String> {


    UserPicInfo findUserPicInfoByUrl(String url);

    void deleteUserPicInfoByUrl(String url);

}
