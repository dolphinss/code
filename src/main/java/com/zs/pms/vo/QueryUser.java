package com.zs.pms.vo;

import java.util.Date;

public class QueryUser {

	// 登录名
	private String loginname;
	// 密码
	private String password;
	// 性别
	private String sex;
	// 出生日期
	private Date birthday;
	// 邮箱
	private String email;
	// 部门
	private int dept;
	// 真实姓名
	private String realname;
	// 修改人
	private int updator;
	// 修改时间
	private String updatime;
	// 头像
	private String pic;
	// 是否可用
	private int isenabled;
	// 起始页数
	private int start;
	// 截止页数
	private int end;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getUpdator() {
		return updator;
	}

	public void setUpdator(int updator) {
		this.updator = updator;
	}

	public String getUpdatime() {
		return updatime;
	}

	public void setUpdatime(String updatime) {
		this.updatime = updatime;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getIsenabled() {
		return isenabled;
	}

	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
