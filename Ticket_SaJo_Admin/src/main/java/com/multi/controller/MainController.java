package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;

@Controller
public class MainController {
	
	@Autowired
	CustBiz cbiz;
	
	@RequestMapping("/")
	public String main(Model m) {

		m.addAttribute("center", "center");
		return "index";
	}
	
	
}