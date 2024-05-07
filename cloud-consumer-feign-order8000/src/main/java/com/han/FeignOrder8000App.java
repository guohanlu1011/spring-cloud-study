package com.han;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @className: Applicationapp
 * @description: TODO 类描述
 * @author: maybe
 * @date: 2024/4/25
 **/

@SpringBootApplication
@EnableDiscoveryClient // 该注解用于使用consul为注册中心时 注册服务
@EnableFeignClients // 启动deign客户端 定义服务+ 绑定接口 以声明式的方法优雅而简单的实现服务调用
public class FeignOrder8000App {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrder8000App.class,args);
    }
}
