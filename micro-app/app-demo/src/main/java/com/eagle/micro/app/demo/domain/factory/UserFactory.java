package com.eagle.micro.app.demo.domain.factory;

import com.eagle.micro.app.demo.common.exception.ErrorCode;
import com.eagle.micro.app.demo.common.exception.UserException;
import com.eagle.micro.app.demo.domain.entity.User;
import com.eagle.micro.app.demo.domain.vo.Address;

/**
 * 用户工厂
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 16:54
 * @Version 1.0
 **/
public class UserFactory {

    public static final User createInstance(String name, String province, String city, String detail) {
        if (null == name || name.isEmpty()) {
            throw new UserException(ErrorCode.USER_NAME_NULL_WHEN_CREATE);
        }
        Address address = Address.builder().province(province).city(city).detail(detail).build();
        User user = User.builder().name(name).address(address).build();
        return user;
    }
}
