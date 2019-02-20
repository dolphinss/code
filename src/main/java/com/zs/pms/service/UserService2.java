package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

public interface UserService2 {
	
	public void addUser(TUser user);
	
	public void updateUser(TUser user);
	
	//public List<TUser> queryByCon(QueryUser query);
}
