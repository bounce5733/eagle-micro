package com.eagle.micro.app.demo.common.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * H2 控制台
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 17:10
 * @Version 1.0
 **/
@Configuration
public class H2Configuration {

    /**
     * ServletRegistrationBean
     * 项目启动和访问/h2-console可以打开控制台，数据库配置在配置文件中
     *
     * @return ServletRegistrationBean
     */
    @Bean
    ServletRegistrationBean h2ServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/h2-console/*");
        return servletRegistrationBean;
    }

}
