package com.han;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @className: Main8001
 * @description: TODO 类描述
 * @author: maybe
 * @date: 2024/4/23
 **/

@SpringBootApplication
@MapperScan("com.han.mapper")
@EnableDiscoveryClient
public class Payment8001 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class,args);
    }
}
