package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ORCController {
	
	@RequestMapping("/orc")
	public String orc(Model m) {
		
		
		m.addAttribute("center", "/orc/orc");
		return "index";
	}

}
