package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.security.config.auth.PrincipalDetailsCustVO;

@Controller
public class SecurityController {


	
	@RequestMapping("/loginsuccess")
	public String loginsuccess(Model m, @AuthenticationPrincipal PrincipalDetailsCustVO principalDetails,HttpSession session) { 
		System.out.println("principalDetails : " + principalDetails.getUser());
		session.setAttribute("user", principalDetails.getUser());

		return "redirect:/";
	}
	

//	@PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")// 접근권한 설정
//	@RequestMapping("/data")
//	public @ResponseBody String data(Model m) { 
//		
//		return "데이터 정보";
//	}
//	
	@RequestMapping("/loginForm")
	public String loginForm(Model m) { 
		
		return "loginForm";
	}
	
 



}
