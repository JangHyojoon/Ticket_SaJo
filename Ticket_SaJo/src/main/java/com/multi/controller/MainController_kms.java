package com.multi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.MovieVO;
import com.multi.vo.SchedulesVO;

@Controller
public class MainController_kms {

	@RequestMapping("/index")
	public String book1(Model m) {
		
		return "/movielist/index";
	}
}