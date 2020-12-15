package com.eagle.micro.app.simple2.rest;/**
 * TODO
 *
 * @author: yh.jiang
 * @time: 2020/12/14 14:18
 */

import com.eagle.micro.model.service.IHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @Author jiangyonghua
 * @Date 2020/12/14 14:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("hello")
public class HelloRest {

    @DubboReference(version = "1.0.0")
    private IHelloService helloService;

    @GetMapping("/say")
    public ResponseEntity<String> say() {
        String msg = helloService.say("dubbo");
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
