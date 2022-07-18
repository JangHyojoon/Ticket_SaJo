package com.multi.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.Detail_SchedulesBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.SchedulesVO;

@RestController
public class AjaxController_jhj {
	@Autowired
	SchedulesBiz schedulesbiz;
	@Autowired
	Detail_SchedulesBiz detail_schedulesbiz;
	
	@RequestMapping("selectmovie")

	public Object selectmovie(int mid, String date) {
		List<SchedulesVO> slist = null;
		List<Detail_SchedulesVO> dslist = null;
		JSONArray ja = new JSONArray();
		
		try {
			slist= schedulesbiz.selectmiddate(mid, date);
		
			for (SchedulesVO sv : slist) {
				JSONObject jo = new JSONObject();
				jo.put("id", sv.getId());
				jo.put("tid", sv.getTid());
				jo.put("mid", sv.getMid());
				jo.put("sdate", sv.getSdate());
				jo.put("title", sv.getTitle());
				jo.put("posterimg1", sv.getPosterimg1());
				jo.put("posterimg2", sv.getPosterimg2());
				jo.put("runningtime", sv.getRunningtime());
				
				ja.add(jo);
				
				
			}
		System.out.println("스케쥴"+ja.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  ja;
	}
	@RequestMapping("selecttime")
	public Object selecttime(int tid,int mid,String sdate) {
		
		List<Detail_SchedulesVO> dslist = null;
		JSONArray ja = new JSONArray();
		
		try {
			dslist= detail_schedulesbiz.selecttidmiddate(tid,mid,sdate);
		
			for (Detail_SchedulesVO dsv : dslist) {
				JSONObject jo = new JSONObject();
				jo.put("sid", dsv.getSid());
				jo.put("mcnt", dsv.getMcnt());
				jo.put("starttime", dsv.getStarttime());
				jo.put("endtime", dsv.getEndtime());
				jo.put("tid", dsv.getTid());
				jo.put("mid", dsv.getMid());
				jo.put("sdate", dsv.getSdate());
				jo.put("booked", dsv.getBooked());
				ja.add(jo);
				
				
			}
		System.out.println("디테일 스케줄"+ja.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return  ja;
	}
	
}
