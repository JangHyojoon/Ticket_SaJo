package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.ncp.ORCAPI;

@RestController
public class AjaxController_awy {
	
	@Autowired
	ORCAPI orcapi;
	
	@RequestMapping("/orcresult")//ORC 영수증 인식 이용 
	public Object orcresult(String txt) {
		Object obj = null;
		obj = orcapi.orcresult(txt); 
		

		return obj;
	}
}
