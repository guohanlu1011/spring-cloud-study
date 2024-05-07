package com.han.conf;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @className: FeignConfig
 * @description: TODO 类描述
 * @author: maybe
 * @date: 2024/4/26
 **/

@Configuration
public class FeignConfig {

    @Bean
    public Retryer myRetryer(){
        return Retryer.NEVER_RETRY;
        // 最大请求次数为 3 （1+2） 初始间隔时间为100s  重试间最大间隔时间为1s
//        return new Retryer.Default(100,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
