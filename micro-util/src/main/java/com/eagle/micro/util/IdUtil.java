package com.eagle.micro.util;

import java.util.UUID;

/**
 * 主键工具
 * 
 * @author jiangyonghua
 * @date 2019年10月14日
 */
public class IdUtil {

	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
