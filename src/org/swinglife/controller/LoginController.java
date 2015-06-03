package org.swinglife.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import org.swinglife.model.User;
import org.swinglife.service.AccountService;

/****
 * 用户登录Controller
 * 
 * @author Swinglife
 * 
 */
@Controller
public class LoginController {

	/***
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toLogin")
	public String toLogin() {
		// 跳转到/page/login.jsp页面
		return "login";
	}

	/***
	 * 实现用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String Login(String username, String password) {
		User user = accountService.getUserByUserName(username);
		if (user == null) {
			return "error";
		}
		if (!user.getPassword().equals(password)) {
			return "error";
		}
		// 登录后存放进shiro token
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		System.out.println("登录成功");
		return "redirect:/home";
	}

	// 处理用户业务类
	@Autowired
	private AccountService accountService;
}
