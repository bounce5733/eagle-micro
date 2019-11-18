package com.eagle.micro.app.demo.domain.external;

import com.eagle.micro.app.demo.domain.entity.User;

/**
 * domain中的外部接口依赖，接口定义在domain.external，实现在infrastructure中
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
public interface UserExtService {

	/**
	 * 访问接口
	 * 
	 * @param user
	 * @return boolean
	 */
	boolean visit(User user);
}
