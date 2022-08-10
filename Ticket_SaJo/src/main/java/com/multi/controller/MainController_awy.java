package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController_awy {
	

	@RequestMapping("/cookietest")
	public String cookietest(Model m) {
		
		
		m.addAttribute("center", "/cookieTest");
		return "index";
	}

}