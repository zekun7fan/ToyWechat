package org.example.post_like_service;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("org.example.post_like_service.dao")
public class PostLikeServiceMain30007 {

    public static void main(String[] args) {
        SpringApplication.run(PostLikeServiceMain30007.class,args);
    }
}
