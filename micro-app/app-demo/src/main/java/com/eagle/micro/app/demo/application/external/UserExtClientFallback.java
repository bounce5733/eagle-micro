package com.eagle.micro.app.demo.application.external;

import com.eagle.micro.app.demo.application.external.request.AddUserExtRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * fallback逻辑
 * 当请求失败时 进入fallback
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 16:35
 * @Version 1.0
 **/
@Component
@Slf4j
public class UserExtClientFallback implements UserExtClient {

    /**
     * 产生fallback时 默认user_id
     */
    public static final Long NULL_USER_ID_WHEN_EXT_CREATE_FALLBACK = -1L;

    public Long createUser(AddUserExtRequest request) {
        log.warn("==== 调用外部服务创建用户失败 进入fallback ====");
        return NULL_USER_ID_WHEN_EXT_CREATE_FALLBACK;
    }
}
