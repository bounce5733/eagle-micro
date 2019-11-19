package com.eagle.micro.app.demo.application.repository;

import com.eagle.micro.app.demo.application.api.response.UserResponseDTO;

import java.util.List;

/**
 * 与领域无关的查询可以直接走读模型
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
public interface UserReadModelRepository {

	/**
	 * 查询所有用户信息
	 * 
	 * @return List<UserResponseDTO>
	 */
	List<UserResponseDTO> queryAllForUserResponseDTO();
}
