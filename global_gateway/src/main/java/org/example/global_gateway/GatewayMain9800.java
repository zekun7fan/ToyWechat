package org.example.global_gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayMain9800 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9800.class,args);
    }

}
