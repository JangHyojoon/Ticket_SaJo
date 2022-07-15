package com.multi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/ouath")
public class MainController_jsy {
	
	//@ResponseBody
//	@GetMapping("/kakao") 
	
//	public void kakaologin(@RequestParam String code) {
	//	System.out.println(code);
//	}
	
	@RequestMapping("naver")
	public String naver() {
		return "/naver";
	}
}