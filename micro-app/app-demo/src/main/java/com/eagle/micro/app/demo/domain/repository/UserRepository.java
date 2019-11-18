package com.eagle.micro.app.demo.domain.repository;

import com.eagle.micro.app.demo.domain.entity.User;

/**
 * UserRepository接口实现在infrastructure
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
public interface UserRepository {

	/**
	 * 保存用户接口
	 * 
	 * @param user User
	 */
	public void add(User user);
}
