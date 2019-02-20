package com.zs.pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.service.DepService;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@Controller
public class UserController {
	@Autowired
	UserService us;
	@Autowired
	DepService ds;
	
	//显示列表页的方法
	@RequestMapping("/user/list.do")
	public String list(String page, QueryUser query, ModelMap model) {
		if (page == null) {
			page = "1";
		}
		// 返回分页数据
		model.addAttribute("LIST", us.queryByPage(Integer.parseInt(page), query));
		// 返回总页数
		model.addAttribute("PAGECOUNT", us.queryCount(query));
		// 当前页数
		model.addAttribute("PAGE", page);
		// 条件
		model.addAttribute("QUERY", query);
		return "user/list";
	}
	
	//去新增的方法
	@RequestMapping("/user/toadd.do")
	public String toadd(ModelMap model) {
		// 返回一级部门
		model.addAttribute("DLIST", ds.queryByPid(0));
		return "user/add";
	}
	
	// 新增
	@RequestMapping("/user/add.do")
	public String add(TUser user, HttpSession session, ModelMap model) {
		TUser tuser = (TUser) session.getAttribute("CUSER");
		try {
			// 装载数据
			user.setIsenabled(1);// 可用
			user.setCreator(tuser.getId());// 新增人
			user.setPic("");// 头像
			us.insertUser(user);
			// 跳转url
			return "redirect:list.do";
		} catch (AppException e) {
			model.addAttribute("MSG", e.getErrMsg());
			// 调用方法传递参数
			return this.toadd(model);
		}
	}
	
	//删除的方法
	@RequestMapping("/user/delete.do")
	public String delete(int id) {
		us.deleteUser(id);
		//跳转url
		return "redirect:list.do";
	}
	
	//批量删除的方法
	@RequestMapping("/user/deletes.do")
	public String deletes(int [] ids) {
		us.deleteByIds(ids);
		//跳转url
		return "redirect:list.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
