package com.eagle.micro.app.demo.common.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 与业务无关的bean定义在common.config
 * <p>
 * feign调用打印日志级别控制
 * 需要在logback中调整feginclient的日志输出为debug
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 16:40
 * @Version 1.0
 **/
@Configuration
public class FeignClientLogConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
