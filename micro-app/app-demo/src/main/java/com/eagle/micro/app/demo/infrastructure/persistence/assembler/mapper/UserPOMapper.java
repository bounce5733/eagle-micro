package com.eagle.micro.app.demo.infrastructure.persistence.assembler.mapper;

import com.eagle.micro.app.demo.domain.entity.User;
import com.eagle.micro.app.demo.infrastructure.persistence.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
