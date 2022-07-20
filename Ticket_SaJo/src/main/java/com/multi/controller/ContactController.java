package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
	@RequestMapping("")
	public String movielist(Model m) {
		m.addAttribute("center", "contact/contact");
		return"index";
	}

	
}