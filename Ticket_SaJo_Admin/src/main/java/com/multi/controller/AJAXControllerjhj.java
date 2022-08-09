package com.multi.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.CustBiz;
import com.multi.biz.GenreBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.vo.CustVO;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.GenreVO;
import com.multi.vo.SchedulesVO;

@RestController
public class AJAXControllerjhj {
	
	@Autowired
	CustBiz cbiz;
	@Autowired
	GenreBiz gbiz;
	@Autowired
	SchedulesBiz sbiz;
	@Autowired
	ScheduleController sc;
	@RequestMapping("calendar")
	public Object checkid() {
		List<SchedulesVO> slist = null;
		List<Detail_SchedulesVO> dslist = null;
		JSONArray ja = new JSONArray();
		
		try {
			slist= sbiz.get();
		
			for (SchedulesVO sv : slist) {
				JSONObject jo = new JSONObject();
				jo.put("id", sv.getId());
				jo.put("start", sv.getSdate());
				jo.put("title", "("+sv.getTid()+"관) "+sv.getTitle());
				jo.put("url", "detail?sid="+sv.getId());
				
				ja.add(jo);
				
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  ja;
		

		
	}

}
