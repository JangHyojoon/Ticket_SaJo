package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AdminBiz;
import com.multi.vo.AdminVO;

@Controller
public class MainController {
	
	@Autowired
	AdminBiz abiz;
	
	@RequestMapping("/")
	public String main(Model m, HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("user");
		m.addAttribute("center", "center");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model m, String msg) {
		if(msg != null && msg.equals("f")) {
			m.addAttribute("msg", "아이디, 비밀번호를 확인하세요");
		}
		m.addAttribute("center", "login");
		return "login";
	}
	@RequestMapping("/loginimpl")
	public String loginimpl(Model m, String id, String pwd, HttpSession session) {
		AdminVO admin = null;
		try {
			admin = abiz.get(id);
			if(admin == null) {
				throw new Exception();
			}
			if(admin.getPwd().equals(pwd)) {
				session.setAttribute("loginadmin", admin);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return "redirect:/login?msg=f";
		}
		return "redirect:/";
	}
	@RequestMapping("/register")
	public String register(Model m) {

		return "register";
	}
}