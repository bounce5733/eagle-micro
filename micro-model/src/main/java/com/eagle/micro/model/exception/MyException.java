package com.eagle.micro.model.exception;

/**
 * 自定义异常
 * 
 * @author jiangyonghua
 * @date 2019年7月3日
 */
public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyException(String msg) {
		super(msg);
	}

}
