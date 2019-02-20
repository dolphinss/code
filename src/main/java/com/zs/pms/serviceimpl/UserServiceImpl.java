package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.util.Constants;
import com.zs.pms.util.MD5;
import com.zs.pms.vo.QueryUser;

@Service
@Transactional//需要开启事物的业务对象
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	/**
	 * 根据用户id查询权限
	 */
	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	/**
	 * 根据原有权限整理菜单
	 */
	@Override
	public List<TPermission> getMenu(List<TPermission> pers) {
		// TODO Auto-generated method stub
		// 创建新容器
		List<TPermission> list = new ArrayList<>();
		// 遍历权限列表
		for (TPermission per : pers) {
			// 一级菜单
			if (per.getLev() == 1) {
				// 加载该一级菜单下的二级菜单
				for (TPermission per2 : pers) {
					// 二级权限的上级pid等于一级权限的id
					if (per2.getPid() == per.getId()) {
						// 添加子权限
						per.addChild(per2);
					}
				}
				// 增加到新的集合中
				list.add(per);
			}
		}
		return list;
	}

	/**
	 * 新增
	 * @throws AppException 
	 */
	@Override
	//该方法只要有异常就回滚事物
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUser user) throws AppException {
		// TODO Auto-generated method stub
		//模拟业务异常
		if("admin".equals(user.getLoginname())) {
			throw new AppException(1003, "登录名不能为admin！");
		}
		MD5 md5 = new MD5();
		user.setPassword(user.getPassword());
		//user.setPassword(md5.getMD5ofStr(user.getPassword()));
		// 新增
		dao.insertUser(user);
		//int a=1/0;
		//dao.insertUser(user);
		// 返回主键id
		return user.getId();
	}

	/**
	 * 修改
	 */
	@Override
	public void updateUser(TUser user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		dao.deleteUser(id);
	}

	/**
	 * 根据条件查询
	 */
	@Override
	public List<TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub
		return dao.queryByCon(query);
	}

	/**
	 * 分页查询
	 */
	@Override
	public List<TUser> queryByPage(int page, QueryUser query) {
		// TODO Auto-generated method stub
		// 起始页数，从1开始
		int start = (page - 1) * Constants.num + 1;
		// 截止数
		int end = page * Constants.num;
		query.setStart(start);
		query.setEnd(end);
		return dao.queryByPage(query);
	}

	/**
	 * 计算总页数
	 */
	@Override
	public int queryCount(QueryUser query) {
		// TODO Auto-generated method stub
		// 通过总条数计算总页数
		int count = dao.queryCount(query);
		// 能整除
		if (count % Constants.num == 0) {
			return count / Constants.num;
		} else {
			return count / Constants.num + 1;
		}
	}

}
