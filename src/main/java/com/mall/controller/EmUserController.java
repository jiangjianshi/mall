package com.mall.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mall.model.EmUser;
import com.mall.service.EmUserService;

@Controller
@RequestMapping("/emUser")
public class EmUserController {

	@Resource
	EmUserService emUserService;

	@RequestMapping(path = "/login")
	public ModelAndView login(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("login"); 
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		EmUser user = emUserService.selectForLogin(account, password);
		if (user != null) {
			HttpSession session = req.getSession();
			req.setAttribute(session.getId(), user);
			mv.addObject("info","登录成功");
		} else {
			mv.addObject("info", "用户名或密码不正确");
		}
		return mv;
	}

	@RequestMapping("/addUser")
	@ResponseBody
	public int addUser(EmUser vo) {
		return emUserService.add(vo);
	}
}
