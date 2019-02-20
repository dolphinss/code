package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TDep;

public interface DepService {
	//根据上级部门id查询二级部门
	public List<TDep> queryByPid(int pid);
}
