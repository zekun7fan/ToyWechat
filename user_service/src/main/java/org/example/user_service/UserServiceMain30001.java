package org.example.user_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("org.example.user_service.dao")
public class UserServiceMain30001 {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceMain30001.class,args);
    }

}
