package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cfr")
public class CFRController {
	
	
	@RequestMapping("")
	public String orc(Model m) {
		m.addAttribute("center", "/cfr/cfr");
		return "index";
	}
	


}
