package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TPermission implements Serializable {

	private static final long serialVersionUID = -732116034532241252L;

	// id
	private int id;
	// 权限名
	private String pname;
	// 上级权限id
	private int pid;
	// 等级
	private int lev;
	// 是否叶子
	private int isleaf;
	// 顺序
	private int sort;
	// 路径
	private String url;
	// 图标
	private String iocn;
	// 子集权限
	private List<TPermission> children = new ArrayList<>();

	// 添加一个子权限
	public void addChild(TPermission per) {
		children.add(per);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIocn() {
		return iocn;
	}

	public void setIocn(String iocn) {
		this.iocn = iocn;
	}

	public List<TPermission> getChildren() {
		return children;
	}

	public void setChildren(List<TPermission> children) {
		this.children = children;
	}
	

}
