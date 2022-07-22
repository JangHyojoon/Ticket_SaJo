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
	
	@RequestMapping("/signin")
	public String signin(Model m) {
		m.addAttribute("center", "signin");
		return "index";
	}
	
	@RequestMapping("/signout")
	public String signout(Model m, HttpSession session) {
		if(session !=null ) {
			session.invalidate();			
		}
		return "index";
	}

	@RequestMapping("/signinimpl")
	public String signinimpl(Model m, String id, String pwd, HttpSession session) {
		String next = "";
		CustVO cust = null;
		try {
			cust = custbiz.get(id);
			if(cust !=null) {
				if(cust.getPwd().equals(pwd)) {
					session.setAttribute("user",cust);
					m.addAttribute("user", cust);
				}else {
					throw new Exception(); 
				}
				
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			next="signinfail";		
		}
		return "index";
	}
	
	@RequestMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("center", "signup");
		return "index";
	}
	
	@RequestMapping("/signupimpl")
	public String signupimpl(Model m, CustVO cust, HttpSession session) {
		try {
			System.out.println(cust);
			custbiz.register(cust);
			session.setAttribute("user", cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/mypage")
	public String mypage(Model m) {
		m.addAttribute("center", "mypage");
		return "index";
	}

}