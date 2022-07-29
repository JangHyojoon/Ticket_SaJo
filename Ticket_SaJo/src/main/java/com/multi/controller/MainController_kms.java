package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController_kms {

	@RequestMapping("/index")
	public String book1(Model m) {	
		return "/movielist/index";
	}
}