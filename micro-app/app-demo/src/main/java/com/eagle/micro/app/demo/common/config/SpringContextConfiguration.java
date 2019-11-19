package com.eagle.micro.app.demo.common.config;

import com.eagle.micro.app.demo.common.util.SpringContextUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringContextConfiguration
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 17:15
 * @Version 1.0
 **/
@Configuration
public class SpringContextConfiguration {

    @Bean
    public SpringContextUtil getSpringContextUtil() {
        return new SpringContextUtil();
    }
}
