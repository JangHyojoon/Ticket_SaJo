package com.multi.controller;

import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.multi.biz.MovieBiz;
import com.multi.biz.ReviewBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.frame.Util;
import com.multi.ncp.CFRAPI;
import com.multi.vo.MovieVO;
import com.multi.vo.ReviewVO;
import com.multi.vo.SchedulesVO;

@RestController
public class AjaxController_kms {

	@Autowired
	MovieBiz mbiz;
	@Autowired
	ReviewBiz rbiz;
	@Autowired
	CFRAPI cfrapi;
	@Autowired
	SchedulesBiz sbiz;
	
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
		 //{'sex':['남','녀'],'rcnt':[1,2,3]}
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
	@RequestMapping("/cfrresult")
	public Object cfrresult(MultipartHttpServletRequest file) {
		Object obj = null;
		String fieldName = "";
		MultipartFile mfile = null; 
		Iterator<String> iter = file.getFileNames(); 
	    while (iter.hasNext()) { 
	        fieldName = (String) iter.next(); 
	        mfile = file.getFile(fieldName);  //저장된 파일 객체
	        Util.saveFile2(mfile);//서버에 파일을 저장하는 모듈 
	    }
		obj = cfrapi.cfrapi(mfile.getOriginalFilename());// CFR 판독 진행 
		return obj;
	}
	@RequestMapping("/selectschedule")
	public Object cfrresult(int mid,String date) {
		List<SchedulesVO> ja1 = new JSONArray();
		try {
			ja1 = sbiz.movielistschedule(mid, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ja1;
	}
	@RequestMapping("/selectreivew")
	public Object selectreivew(int mid) {
		List<ReviewVO> ja1 = new JSONArray();
		try {
			ja1 = rbiz.selectmreviews(mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ja1;
	}
}
