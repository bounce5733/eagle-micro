package com.eagle.micro.app.demo.application.api.assembler;

import com.eagle.micro.app.demo.application.api.request.AddUserRequestDTO;
import com.eagle.micro.app.demo.domain.entity.User;
import com.eagle.micro.app.demo.domain.factory.UserFactory;
import org.springframework.stereotype.Component;

/**
 * assembler用于对象之间的转换
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 16:53
 * @Version 1.0
 **/
@Component
public class UserDTOAssembler {

    public User assembler(AddUserRequestDTO dto) {
        User user = UserFactory.createInstance(dto.getName(), dto.getProvince(), dto.getCity(), dto.getDetail());
        return user;
    }
}
