package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AdminBiz;
import com.multi.biz.CodeBiz;
import com.multi.vo.AdminVO;
import com.multi.vo.CodeVO;

@Controller
public class MainController {
	
	@Autowired
	AdminBiz abiz;
	@Autowired
	CodeBiz cbiz;
	
	@RequestMapping("/")
	public String main(Model m, HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");
		if (admin==null) {
			return "/login";
		}else {
		m.addAttribute("center", "center");
		return "index";}
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
	public String register(Model m,String msg) {
		if(msg != null && msg.equals("f")) {
			m.addAttribute("msg", "코드가 잘못되었습니다.");
		}
		return "register";
	}
	@RequestMapping("/registerimpl")
	public String registerimpl(Model m , String id, String pwd, String code, HttpSession session) {
		AdminVO admin = new AdminVO(id, pwd);
		try {
			CodeVO clist = cbiz.selectcode(code);
			if(clist == null) {
				throw new Exception();
			}else if(clist != null) {
				abiz.register(admin);
				session.setAttribute("loginadmin", admin);
			}
		} catch (Exception e) {
			return "redirect:/register?msg=f";
		}
		
		return "redirect:/";
	}
	@RequestMapping("/signout")
	   public String signout(Model m, HttpSession session) {
	      if(session !=null ) {
	         session.invalidate();         
	      }
	      return "redirect:/";
	   }
	@RequestMapping("/master")
	   public String master(Model m, HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");
		
		CodeVO code1 = null;
		try {
			cbiz.autoupdate();
			code1 = cbiz.get(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (admin==null) {
			return "/login";
		}else {
			m.addAttribute("code", code1);
		}
	      return "master";
	   }
	
}