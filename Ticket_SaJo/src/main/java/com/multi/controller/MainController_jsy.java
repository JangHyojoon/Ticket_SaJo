package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@Controller
public class MainController_jsy {
	
	@Autowired
	CustBiz custbiz;
	
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("center", "login");
		return "index";
	}

	@RequestMapping("/loginimpl")
	public String loginimpl(Model m, String id, String pwd, String name, HttpSession session) {
		String next = "";
		System.out.println("loginimpl");
		CustVO cust = null;
		try {
			cust = custbiz.get(id);
			if(cust !=null) {
				if(cust.getPwd().equals(pwd)) {
					session.setAttribute("user",cust);
					m.addAttribute("user", cust);
					next = "loginok";
				}else {
					throw new Exception(); 
				}
				
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			next="loginfail";		
		}
		
		m.addAttribute("center", next);
		return "index";
	}

}