package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.SchedulesBiz;
import com.multi.vo.SchedulesVO;

@RestController
public class AjaxController_jhj {
	@Autowired
	SchedulesBiz schedulesbiz;
	
	
	@RequestMapping("selectmovie")
	public String selectmovie(String mid) {
		String result = "";
		SchedulesVO sv = null;
		
		if(mid.equals("") || mid == null) {
			result =  "1";
			return result;
		}
		
		try {
			sv = schedulesbiz.get(null);
			if(sv == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
