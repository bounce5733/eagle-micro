package com.eagle.micro.app.demo.application.api.assembler.mapper;

import com.eagle.micro.app.demo.application.api.request.AddUserRequestDTO;
import com.eagle.micro.app.demo.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * User对象转换
 *
 * @Author jiangyonghua
 * @Date 2019/11/19 16:59
 * @Version 1.0
 **/
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDTOMapper {

    UserDTOMapper INSTANCE = Mappers.getMapper(UserDTOMapper.class);

    @Mappings({
            @Mapping(source = "province", target = "address.province"),
            @Mapping(source = "city", target = "address.city"),
            @Mapping(source = "detail", target = "address.detail")
    })
    User fromRequestDto(AddUserRequestDTO dto);
}
