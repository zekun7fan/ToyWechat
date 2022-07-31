package org.example.commonUtils.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.commonUtils.entity.UserJwtPayload;

import java.time.LocalDateTime;

public class JwtUtils {

    private static final String secret = "toy_wechat";

    private static final Algorithm algorithm = Algorithm.HMAC256(secret);

    private static final String userIdKey = "user_id";

    private static final String userExpireKey = "user_expire";


    public static String createToken(UserJwtPayload userJwtPayload){
        try {
            return JWT.create().withClaim(userIdKey, userJwtPayload.getUid())
                    .withClaim(userExpireKey, userJwtPayload.getExpire().toString())
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            return null;
        }
    }


    public static UserJwtPayload verifyToken(String token){
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            String uid = decodedJWT.getClaim(userIdKey).asString();
            LocalDateTime expire = LocalDateTime.parse(decodedJWT.getClaim(userExpireKey).asString());
            return new UserJwtPayload(uid, expire);
        }catch (JWTVerificationException exception){
            return null;
        }
    }


    public static String updateToken(String oldToken){
        if (oldToken == null){
            return null;
        }
        UserJwtPayload userJwtPayload = verifyToken(oldToken);
        if (userJwtPayload == null){
            return null;
        }
        userJwtPayload.setExpire(TimeUtils.after30days());
        return createToken(userJwtPayload);
    }
}
