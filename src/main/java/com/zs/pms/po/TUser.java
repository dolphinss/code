package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

import com.zs.pms.util.DateUtil;

public class TUser implements Serializable {
	private static final long serialVersionUID = 4925738227933965841L;

	// id
	private int id;
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
	private TDep dept;
	// 真实姓名
	private String realname;
	// 创建人
	private int creator;
	// 创建时间
	private String creatime;
	// 修改人
	private int updator;
	// 修改时间
	private String updatime;
	// 头像
	private String pic;
	// 是否可用
	private int isenabled;
	//显示是否可用
	private String isenabledTxt;
	//显示日期
	private String birthdayTxt;
	
	

	public String getIsenabledTxt() {
		if(isenabled==1) {
			return "账户可用！";
		}else {
			return "账户不可用！";
		}
	}

	public void setIsenabledTxt(String isenabledTxt) {
		this.isenabledTxt = isenabledTxt;
	}

	public String getBirthdayTxt() {
		return DateUtil.getStrDate();
	}

	public void setBirthdayTxt(String birthdayTxt) {
		this.birthdayTxt = birthdayTxt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public TDep getDept() {
		return dept;
	}

	public void setDept(TDep dept) {
		this.dept = dept;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public String getCreatime() {
		return creatime;
	}

	public void setCreatime(String creatime) {
		this.creatime = creatime;
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

}
