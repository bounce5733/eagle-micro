package com.eagle.micro.app.demo.application.external.assembler.mapper;

import com.eagle.micro.app.demo.application.api.request.AddUserRequestDTO;
import com.eagle.micro.app.demo.application.external.request.AddUserExtRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * mapstruct实现对象转换
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 17:06
 * @Version 1.0
 **/
@Mapper
public interface UserExtMapper {

    UserExtMapper INSTANCE = Mappers.getMapper(UserExtMapper.class);


    /**
     * AddUserRequestDTO转换为AddUserExtRequest
     *
     * @param dto AddUserRequestDTO
     * @return AddUserExtRequest
     */
    AddUserExtRequest toAddUserExtRequest(AddUserRequestDTO dto);
}
