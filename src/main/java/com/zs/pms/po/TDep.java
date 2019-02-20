package com.zs.pms.po;

import java.io.Serializable;

public class TDep implements Serializable {

	private static final long serialVersionUID = -1640931736530463006L;
	
	// id
	private int id;
	// 部门名称
	private String name;
	// 上级部门
	private int pid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
