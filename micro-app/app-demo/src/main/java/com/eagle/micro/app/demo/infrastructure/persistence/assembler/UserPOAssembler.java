package com.eagle.micro.app.demo.infrastructure.persistence.assembler;

import com.eagle.micro.app.demo.domain.entity.User;
import com.eagle.micro.app.demo.infrastructure.persistence.assembler.mapper.AddressPOMapper;
import com.eagle.micro.app.demo.infrastructure.persistence.assembler.mapper.UserPOMapper;
import com.eagle.micro.app.demo.infrastructure.persistence.po.AddressPO;
import com.eagle.micro.app.demo.infrastructure.persistence.po.UserPO;
import org.springframework.stereotype.Component;

/**
 * UserPO Assembler
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
@Component
public class UserPOAssembler {

	public UserPO assembler(User user) {
		return UserPOMapper.INSTANCE.fromUser(user);
	}

	public AddressPO assemblerAddressPO(User user) {
		AddressPO addressPO = AddressPOMapper.INTANCE.fromAddress(user.getAddress());
		addressPO.setUserId(user.getId());
		return addressPO;
	}
}
