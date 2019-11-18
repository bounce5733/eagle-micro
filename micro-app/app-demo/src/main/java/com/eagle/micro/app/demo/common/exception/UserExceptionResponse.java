package com.eagle.micro.app.demo.common.exception;

public class UserExceptionResponse {

	private int errcode;

	private String errmsg;

	public UserExceptionResponse(int errcode, String errmsg) {
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	public UserExceptionResponse(ErrorCode errCode) {
		this.errcode = errCode.getCode();
		this.errmsg = errCode.getMsg();
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
}
