package org.example.post_content_service;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("org.example.post_content_service.dao")
public class PostContentServiceMain30006 {

    public static void main(String[] args) {
        SpringApplication.run(PostContentServiceMain30006.class,args);
    }
}
