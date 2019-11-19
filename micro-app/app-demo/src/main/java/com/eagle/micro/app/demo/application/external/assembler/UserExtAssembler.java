package com.eagle.micro.app.demo.application.external.assembler;

import com.eagle.micro.app.demo.application.api.request.AddUserRequestDTO;
import com.eagle.micro.app.demo.application.external.assembler.mapper.UserExtMapper;
import com.eagle.micro.app.demo.application.external.request.AddUserExtRequest;
import org.springframework.stereotype.Component;

/**
 * assembler转换
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 17:04
 * @Version 1.0
 **/
@Component
public class UserExtAssembler {

    public AddUserExtRequest assembler(AddUserRequestDTO dto) {
        return UserExtMapper.INSTANCE.toAddUserExtRequest(dto);
    }
}
