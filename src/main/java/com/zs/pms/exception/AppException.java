package com.zs.pms.exception;

public class AppException extends Exception {
	private int enCode;
	private String errMsg;

	public int getEnCode() {
		return enCode;
	}

	public void setEnCode(int enCode) {
		this.enCode = enCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public AppException(int enCode, String errMsg) {
		super();
		this.enCode = enCode;
		this.errMsg = errMsg;
	}

}
