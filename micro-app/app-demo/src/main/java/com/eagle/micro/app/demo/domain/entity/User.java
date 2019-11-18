package com.eagle.micro.app.demo.domain.entity;

import com.eagle.micro.app.demo.common.util.SpringContextUtil;
import com.eagle.micro.app.demo.domain.external.UserExtService;
import com.eagle.micro.app.demo.domain.vo.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 领域对象放在domain.entity中
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	public static final String USER_EXT_SERVICE_BEAN_NAME = "UserExtService";

	private Long id;

	private String name;

	private Address address;

	/**
	 * 充血模型domain里面包含领域行为
	 * 
	 * @return
	 */
	public boolean doSomething() {
		UserExtService userExtService = SpringContextUtil.getBean(USER_EXT_SERVICE_BEAN_NAME);
		return userExtService.visit(this);
	}
}
