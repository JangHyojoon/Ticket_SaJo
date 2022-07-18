package com.multi.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.MovieBiz;
import com.multi.biz.ReviewBiz;
import com.multi.vo.MovieVO;
import com.multi.vo.ReviewVO;

@RestController
public class AjaxController_kms {

	@Autowired
	MovieBiz mbiz;
	@Autowired
	ReviewBiz rbiz;
	
	@RequestMapping("/movielist/chartimpl")
	public Object chartimpl(int id) {
		 //{'age':['20','30'],'rcnt':[1,2,3]}
		JSONObject jo = new JSONObject();
		JSONArray ja1 = new JSONArray();
		JSONArray ja2 = new JSONArray();
		List<ReviewVO> list =null;
		
		try {
			list = rbiz.selectbyage(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (ReviewVO p : list) {
			String age = Integer.toString(p.getAge())+'대';
			ja1.add(age);
			ja2.add(p.getRcnt());
		}
		jo.put("age", ja1);
		jo.put("rcnt", ja2);
		return jo;
	}
	@RequestMapping("/movielist/circlechartimpl")
	public Object circlechartimpl(int id) {
		 //{'age':['20','30'],'rcnt':[1,2,3]}
		JSONObject jo = new JSONObject();
		JSONArray ja1 = new JSONArray();
		JSONArray ja2 = new JSONArray();
		List<ReviewVO> list =null;
		try {
			list = rbiz.selectbysex(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (ReviewVO p : list) {
			ja1.add(p.getSex());
			ja2.add(p.getRpercent());

		}
		jo.put("sex", ja1);
		jo.put("rpercent", ja2);
		return jo;
	}
	
}
