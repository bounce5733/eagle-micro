package com.eagle.micro.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 接口返回包装体
 * 
 * @author jiangyonghua
 * @date 2019年10月16日
 */
@Data
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;

	private String msg;

	private T data;

	@SuppressWarnings("unused")
	private Result() {
	}

	public Result(ResultCodeEnum resultCode, T data) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
		this.data = data;
	}

	public static Result<Object> success() {
		return new Result<Object>(ResultCodeEnum.SUCCESS, null);
	}

	public static Result<Object> success(Object data) {
		return new Result<Object>(ResultCodeEnum.SUCCESS, data);
	}

	public static Result<Object> failure(ResultCodeEnum resultCode) {
		return new Result<Object>(resultCode, null);
	}
}
