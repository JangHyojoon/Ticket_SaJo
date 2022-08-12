package com.multi.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.VisitListBiz;
import com.multi.vo.ReviewVO;
import com.multi.vo.VisitListVO;

@RestController
public class AjaxControllerChart {

	@Autowired
	VisitListBiz vlbiz;
	
	
	@RequestMapping("/visitChartimpl")
	public Object visitChartimpl() {
		System.out.println("visitChartimpl 시작 ");
		JSONObject jo = new JSONObject();
		JSONArray ja1 = new JSONArray();
		JSONArray ja2 = new JSONArray();
		JSONArray ja3 = new JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		List<VisitListVO> list = null;
		String date = "";
		int avg = 0;
		
		
		try {
			list = vlbiz.VisitList7Days();
			avg = vlbiz.VisitListAvg();
			System.out.println(list);
			System.out.println("avg" + avg);
			
			for(VisitListVO vl : list) {// 리스트 값을 각각 x, y축 에 들어갈 값으로 나누기 
				ja1.add(vl.getCount()); // 방문자수 
				
				date = sdf.format(vl.getDate());// 가져온 데이트 값을 String 형으로 변경 
				ja2.add(date); // 날짜 
				
				ja3.add(avg); // 7일간 방문자수 합 평균 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		jo.put("visitcnt", ja1);
		jo.put("date", ja2);
		jo.put("avg", ja3);// 평균 방문자 수 
		System.out.println("ja1 : " + ja1);
		System.out.println("ja2 : " + ja2);
		System.out.println("ja3 : " + ja3);
		System.out.println("avg : " + avg);
		
		
		return jo;

	}
//	@RequestMapping("/movielist/circlechartimpl")
//	public Object circlechartimpl(int id) {
//		 //{'sex':['남','녀'],'rcnt':[1,2,3]}
//		JSONObject jo = new JSONObject();
//		JSONArray ja1 = new JSONArray();
//		JSONArray ja2 = new JSONArray();
//		List<ReviewVO> list =null;
//		try {
//			list = rbiz.selectbysex(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		for (ReviewVO p : list) {
//			ja1.add(p.getSex());
//			ja2.add(p.getRpercent());
//
//		}
//		jo.put("sex", ja1);
//		jo.put("rpercent", ja2);
//		return jo;
//	}

}
