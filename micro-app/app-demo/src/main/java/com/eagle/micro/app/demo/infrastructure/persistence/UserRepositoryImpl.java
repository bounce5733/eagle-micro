package com.eagle.micro.app.demo.infrastructure.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.micro.app.demo.application.api.response.UserResponseDTO;
import com.eagle.micro.app.demo.application.repository.UserReadModelRepository;
import com.eagle.micro.app.demo.domain.entity.User;
import com.eagle.micro.app.demo.domain.repository.UserRepository;
import com.eagle.micro.app.demo.infrastructure.persistence.assembler.UserPOAssembler;
import com.eagle.micro.app.demo.infrastructure.persistence.po.AddressPO;
import com.eagle.micro.app.demo.infrastructure.persistence.po.UserPO;

import lombok.extern.slf4j.Slf4j;

/**
 * UserRepository持久化实现
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
@Component
@Slf4j
public class UserRepositoryImpl implements UserRepository, UserReadModelRepository {

	@Autowired
	private JpaUserPORepository jpaUserPORepository;

	@Autowired
	private JpaAddressPORepository jpaAddressPORepository;

	@Autowired
	private UserPOAssembler userPOAssembler;

	@Override
	public List<UserResponseDTO> queryAllForUserResponseDTO() {
		return jpaUserPORepository.queryAllUsers();
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void add(User user) {
		UserPO userPO = userPOAssembler.assembler(user);
		log.info("==== userPO:{} ====", userPO);
		jpaUserPORepository.save(userPO);
		AddressPO addressPO = userPOAssembler.assemblerAddressPO(user);
		log.info("===== addressPO:{} ====", addressPO);
		jpaAddressPORepository.save(addressPO);
	}

}
