package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@RestController
public class AjaxController_jsy {
	
	@Autowired
	CustBiz custbiz;
	
	@RequestMapping("checkid")
	public String checkid(String id) {
		String result="";
		CustVO cust = null;
		
		if(id.equals("") || id == null) {
			return "1";
		}
		
		try {
			cust = custbiz.get(id);
			if(cust == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("checkname")
	public String checkname(String name) {
		String result="";
		CustVO cust = null;
		
		if(name.equals("") || name == null) {
			return "1";
		}
		
		try {
			cust = custbiz.get(name);
			if(cust == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("checkpwd")
		public String checkpwd(String delete_pwd, HttpSession session) {
			CustVO cust = null;
			List<CustVO> list = null;
			cust = (CustVO) session.getAttribute("user");
			String pwd = cust.getPwd();
			String result = "0";
			
			try {
				if(pwd.equals(delete_pwd)) {
					result = "1";
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	}