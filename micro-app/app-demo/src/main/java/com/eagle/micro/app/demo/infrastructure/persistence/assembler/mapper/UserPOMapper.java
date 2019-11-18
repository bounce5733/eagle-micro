package com.eagle.micro.app.demo.infrastructure.persistence.assembler.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.eagle.micro.app.demo.domain.entity.User;
import com.eagle.micro.app.demo.infrastructure.persistence.po.UserPO;

/**
 * UserPO Mapper
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
@Mapper
public interface UserPOMapper {

	UserPOMapper INSTANCE = Mappers.getMapper(UserPOMapper.class);

	UserPO fromUser(User user);
}
