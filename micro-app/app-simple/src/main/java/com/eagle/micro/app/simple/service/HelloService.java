package com.eagle.micro.app.simple.service;/**
 * TODO
 *
 * @author: yh.jiang
 * @time: 2020/12/11 16:19
 */

import com.eagle.micro.model.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/12/11 16:19
 * @Version 1.0
 **/
@Slf4j
@DubboService(version = "1.0.0")
public class HelloService implements IHelloService {

    @Override
    public String say(String msg) {
        return "hello " + msg;
    }
}
