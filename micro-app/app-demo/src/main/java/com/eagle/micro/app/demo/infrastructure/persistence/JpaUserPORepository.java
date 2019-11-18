package com.eagle.micro.app.demo.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eagle.micro.app.demo.application.api.response.UserResponseDTO;
import com.eagle.micro.app.demo.infrastructure.persistence.po.UserPO;

public interface JpaUserPORepository extends JpaRepository<UserPO, Long> {

	@Query(value = "select new com.eagle.micro.app.demo.application.api.response.UserResponseDTO("
			+ "u.id, u.name, a.province, a.city, a.detail ) "
			+ "from UserPO u left join AddressPO a on u.id = a.userId ")
	List<UserResponseDTO> queryAllUsers();
}
