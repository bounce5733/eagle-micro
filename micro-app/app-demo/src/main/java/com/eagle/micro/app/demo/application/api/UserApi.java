package com.eagle.micro.app.demo.application.api;

import com.eagle.micro.app.demo.application.api.request.AddUserRequestDTO;
import com.eagle.micro.app.demo.application.api.response.UserResponseDTO;
import com.eagle.micro.app.demo.application.service.UserAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * api接口统一放在application.api包下
 * 类名以Api结尾
 * 系统内部使用和外部使用的接口可以通过给mapping设置不同的前缀来区分
 *
 * @ClassName UserApi
 * @Author jiangyonghua
 * @Date 2019/11/19 15:52
 * @Version 1.0
 **/
@RestController
@Slf4j
public class UserApi {

    @Autowired
    private UserAppService userAppService;

    public UserApi(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    /**
     * 查询用户信息
     *
     * @return String
     */
    @GetMapping("/v1/users")
    public List<UserResponseDTO> queryAll() {

//        Tracing current = Tracing.current();
//        log.info("====  采样为：{} ====", current.currentTraceContext().get().sampled());
//
//        log.info("==== get user list ====");
        return userAppService.queryUsers();
    }

    /**
     * 超时
     *
     * @throws InterruptedException
     */
    @GetMapping("/v1/user2")
    public void err() throws InterruptedException {
        Thread.sleep(100 * 1000);
        return;
    }

    /**
     * 新增用户
     * @param dto
     */
    @PostMapping("/v1/users")
    public void addUser(@Validated @RequestBody AddUserRequestDTO dto) {
        /*
         *参数验证后调用application.service
         * 无法通过注解验证的字段 调用application service前通过代码做验证
         */
        userAppService.createUser(dto);
    }

}
