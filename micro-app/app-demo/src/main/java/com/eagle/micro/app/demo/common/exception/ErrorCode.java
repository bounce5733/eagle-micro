package com.eagle.micro.app.demo.common.exception;

/**
 * 异常相关放到common.exception中
 * <p>
 * error code枚举
 * 
 * @author jiangyonghua
 * @date 2019年11月15日
 */
public enum ErrorCode {

	/**
	 * 参数错误
	 */
	PARAMETER_ERROR(1001, "请求参数错误"),

	/**
	 * 内部错误
	 */
	INTERNAL_SERVER_ERROR(1002, "internal server error"),

	/**
	 * 创建用户时，姓名为空
	 */
	USER_NAME_NULL_WHEN_CREATE(100001, "创建用户时，姓名为空"),

	/**
	 * 创建用户时，调用外部依赖失败
	 */
	CREATE_FAIL_EXT_CALL_FAIL(100001, "创建用户，调用外部依赖失败");

	private int code;

	private String msg;

	ErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
