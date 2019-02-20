package com.zs.pms.vo;

/**
 * 装载登录验证数据
 * 
 * @author admin
 *
 */
public class QueryLogin {

	private String loginname;
	private String password;
	private String chkcode;

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChkcode() {
		return chkcode;
	}

	public void setChkcode(String chkcode) {
		this.chkcode = chkcode;
	}

}
