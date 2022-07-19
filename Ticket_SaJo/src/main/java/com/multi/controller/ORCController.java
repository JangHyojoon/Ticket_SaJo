package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ORCController {
	
	@RequestMapping("/orc")
	public String orc(Model m) {
		m.addAttribute("center", "/orc/orc");
		return "index";
	}
	
	@RequestMapping("/orcimpl")
	public String orcimpl(Model m,MultipartFile mf) {
		
		
		System.out.println(mf.toString());
		
		m.addAttribute("center", "/orc/orc");
		return "index";
	}
	

}
