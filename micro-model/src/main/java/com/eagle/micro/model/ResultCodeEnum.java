package com.eagle.micro.model;

/**
 * 接口状态码<br>
 * 错误分类：
 * <ol>
 * <li>1000-1999参数错误</li>
 * <li>2000-2999用户错误</li>
 * <li>3000-3999接口异常</li>
 * <li>4000-4999服务器异常</li>
 * </ol>
 * 
 * @author jiangyonghua
 * @date 2019年10月16日
 */
public enum ResultCodeEnum {

	/* 成功 */
	SUCCESS(0, "成功"),

	/* 参数错误 */
	PARAM_IS_INVALID(1001, "参数无效"), PARAM_IS_BLANK(1002, "参数为空"), PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),
	PARAM_NOT_COMPLETE(1004, "参数缺失"),

	/* 用户错误 */
	USER_NOT_LOGGED_IN(2001, "用户未登陆"), USER_LOGIN_ERROR(2002, "账号不存在或密码错误"), USER_ACCOUNT_FORBIDDEN(2003, "账号已被禁用"),
	USER_NOT_EXIST(2004, "用户不存在"), USER_HAS_EXISTED(2005, "用户已存在"),

	/* 服务器内部错误 */
	SERVER_INTERNAL_ERROR(4001, "服务器内部异常");

	private final Integer code;
	private final String msg;

	private ResultCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}
}
