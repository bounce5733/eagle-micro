package com.eagle.micro.app.demo.common.exception;

import lombok.Getter;

/**
 * 用户服务异常类
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
@Getter
public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ErrorCode errorCode;

	public UserException(ErrorCode errorCode) {
		super(errorCode.getMsg());
		this.errorCode = errorCode;
	}
}
