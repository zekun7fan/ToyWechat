package org.example.friend_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("org.example.friend_service.dao")
public class FriendServiceMain30002 {


    public static void main(String[] args) {
        SpringApplication.run(FriendServiceMain30002.class,args);
    }

}
