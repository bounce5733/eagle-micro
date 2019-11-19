package com.eagle.micro.app.demo.infrastructure.external;

import com.eagle.micro.app.demo.domain.entity.User;
import com.eagle.micro.app.demo.domain.external.UserExtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * UserExtService接口实现
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
@Service("UserExtService")
@Slf4j
public class UserExtServiceImpl implements UserExtService {

	@Override
	public boolean visit(User user) {
		log.info("==== UserExtServiceImpl visit:{} ====", user);
		return null == user.getName() || user.getName().isEmpty() ? false : true;
	}

}
