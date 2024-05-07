package com.han;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @className: applicationMain
 * @description: TODO 类描述
 * @author: maybe
 * @date: 2024/4/24
 **/

@SpringBootApplication
@EnableDiscoveryClient
public class Order8000 {
    public static void main(String[] args) {
        SpringApplication.run(Order8000.class,args);
    }
}
