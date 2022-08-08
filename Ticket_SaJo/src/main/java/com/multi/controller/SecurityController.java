package com.multi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
