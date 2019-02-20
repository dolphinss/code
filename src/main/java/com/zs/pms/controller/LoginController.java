package com.zs.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
/**
 * 这是一个控制器
 * @author admin
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.util.DateUtil;
import com.zs.pms.util.MD5;
import com.zs.pms.vo.QueryLogin;
import com.zs.pms.vo.QueryUser;

@Controller
public class LoginController {
	@Autowired
	UserService us;

	// 去登录页面
	@RequestMapping("/tologin.do")
	public String tologin() {
		return "login";
	}

	// 去主页面
	@RequestMapping("/login.do")
	public String login(QueryLogin login, HttpSession session, ModelMap model) {
		// 1、验证验证码
		String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		// 判断输入的信息和生成的验证码是否一致，如果不一致就直接回到登录页面，如果一致接着去验证账号密码
		if (!code.equals(login.getChkcode())) {
			model.addAttribute("MSG", "验证码有误，请重新输入");
			return "login";
		}
		// 2、验证账号和密码
		// 装载数据
		QueryUser query = new QueryUser();
		MD5 md5 = new MD5();
		// 用户名
		query.setLoginname(login.getLoginname());
		// 加密密码
		query.setPassword(login.getPassword());
		//query.setPassword(md5.getMD5ofStr(login.getPassword()));
		// 是否可用
		query.setIsenabled(1);
		// 返回登录的用户
		List<TUser> users = us.queryByCon(query);
		// 登录失败
		if (users == null || users.size() != 1) {
			model.addAttribute("MSG", "用户名或密码错误！");
			return "login";
		}
		// 登录成功，装session
		session.setAttribute("CUSER", users.get(0));
		// 返回主页面
		return "main";
	}

	// 去顶部页面
	@RequestMapping("/top.do")
	public String top(ModelMap model) {
		// 将当前时间返回页面
		model.addAttribute("TODAY", DateUtil.getStrDate());
		// 返回顶部页面
		return "top";
	}

	// 去左侧菜单页面
	@RequestMapping("/left.do")
	public String menu(HttpSession session, ModelMap model) {
		// 获得当前登录的用户
		TUser user = (TUser) session.getAttribute("CUSER");
		// 获得该用户的权限列表
		List<TPermission> list = us.queryByUid(user.getId());
		// 返回菜单
		model.addAttribute("MENU", us.getMenu(list));
		return "left";
	}

	// 去右侧页面
	@RequestMapping("/right.do")
	public String main() {
		return "right";
	}

}
