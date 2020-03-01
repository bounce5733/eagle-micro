package com.eagle.micro.app.demo.application.external;

import com.eagle.micro.app.demo.common.config.FeignClientLogConfiguration;
import com.eagle.micro.app.demo.application.external.request.AddUserExtRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 通过application层调用接口
 * <p>
 * 若使用feignclient可以直接把feignclient定义在application.external包中
 * <p>
 * 如果是其他方式接口调用 则在application.external定义service接口 在infrastructure.external包中写实现接口 （参考domain）
 *
 * @Author jiangyonghua
 * @Date 2019/11/21 10:07
 * @Version 1.0
 **/
@FeignClient(name = "DEMO", fallback = UserExtClientFallback.class, configuration = FeignClientLogConfiguration.class)
public interface UserExtClient {

    /**
     * 模拟调用创建用户时外部接口，返回用户id
     *
     * @param request AddUserExtRequest
     * @return Long
     */
    @PostMapping("/v1/ext/users")
    Long createUser(@RequestBody AddUserExtRequest request);
}
