package com.multi.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.MovieBiz;
import com.multi.vo.MovieVO;

@RestController
public class AjaxController_kms {

	@Autowired
	MovieBiz mbiz;
	
	@RequestMapping("/chartimpl")
	public Object chartimpl() {
		 //{'cate':['p1','p2','p3','p4','p5'],'data':[10000,30000,20000,50000,60000]}
		JSONObject jo = new JSONObject();
		JSONArray ja1 = new JSONArray();
		JSONArray ja2 = new JSONArray();
		List<MovieVO> list =null;
		
		try {
			list = mbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (MovieVO p : list) {
			
		}
//		data = {  연령, 숫자 만 뽑아오는 예
//			    2016: [
//			        ['South Korea', 0],
//			        ['Japan', 0],
//			        ['Australia', 0],
//			        ['Germany', 17],
//			        ['Russia', 19],
//			        ['China', 26],
//			        ['Great Britain', 27],
//			        ['United States', 46]
//			    ],
		jo.put("cate", ja1);
		jo.put("data", ja2);
		return jo;
	}
	
}
