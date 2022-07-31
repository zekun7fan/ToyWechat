package org.example.message_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MessageServiceMain30011 {

    public static void main(String[] args) {
        SpringApplication.run(MessageServiceMain30011.class,args);
    }
}
