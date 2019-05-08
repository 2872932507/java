package com.zl.web;

import com.zl.service.IUserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private  IUserService userService;

	@RequestMapping(path="/login.action",method=RequestMethod.POST)
	public String login(HttpSession session,Model model , String name,String password) throws Exception{
		if(userService.login(name, password)){
			session.setAttribute("loginName", name);
			return "redirect:/page/list.htm";
		}
		model.addAttribute("error", "用户名或者密码错误");
		return "login";
	}
	
}
