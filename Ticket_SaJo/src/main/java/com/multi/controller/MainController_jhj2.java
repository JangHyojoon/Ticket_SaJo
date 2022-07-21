package com.multi.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.BookedBiz;
import com.multi.biz.Detail_SchedulesBiz;
import com.multi.biz.MovieBiz;
import com.multi.biz.ReservationBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.biz.TheaterBiz;
import com.multi.biz.TicketBiz;
import com.multi.vo.Detail_SchedulesVO;
import com.multi.vo.MovieVO;
import com.multi.vo.ReservationVO;
import com.multi.vo.TicketVO;

@Controller
public class MainController_jhj2 {
	@Autowired
	BookedBiz seatbiz;
	@Autowired
	TheaterBiz theaterbiz;
	@Autowired
	MovieBiz moviebiz;
	@Autowired
	SchedulesBiz schedulesbiz;
	@Autowired
	Detail_SchedulesBiz detail_schedulesbiz;
	@Autowired
	ReservationBiz reservationbiz;
	@Autowired
	TicketBiz ticketbiz;
	@Autowired
	BookedBiz bookedbiz;
	
	
	@RequestMapping("/book3impl11")
	public String book3mpl11(Model m, String sid, String mcnt, String title, String price,String sdate, String seatlist) {
		//선택좌석 리스트

		seatlist =seatlist.substring(0,seatlist.length() -1);  
		String sseatlist =seatlist.substring(1,seatlist.length()); 
		String[] bookedarr =sseatlist.split(", ");
		HashSet<String> hashset = new HashSet<>(Arrays.asList(bookedarr));	//중복값 삭제
		String[] choosensit = hashset.toArray(new String[0]);
		Arrays.sort(choosensit);

		
		try {
			bookedbiz.insertseat(Integer.parseInt(sid),Integer.parseInt(mcnt), seatlist);
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		
		
		
	
		ReservationVO rv = new ReservationVO("jhj",choosensit.length,Integer.parseInt(price),Integer.parseInt(price));	
		try {
			reservationbiz.register(rv);
	
		} catch (Exception e) {

		}
		int rid = rv.getRid();
		//티켓테이블 인서트와 booked의 좌석 추가
		for (int i = 0; i < choosensit.length; i++) {
			TicketVO tv = new TicketVO(Integer.parseInt(sid),rid,sdate,Integer.parseInt(mcnt),choosensit[i]);
			try {
				ticketbiz.register(tv);
				Detail_SchedulesVO dsv = new Detail_SchedulesVO(Integer.parseInt(sid),Integer.parseInt(mcnt),choosensit[i]);
				detail_schedulesbiz.updatebooked(dsv);
				
			} catch (Exception e) {		
				e.printStackTrace();
			}			
		}
		//티켓을 만들기 위한 테이블들 정보
		try {
			List<TicketVO> tlist = ticketbiz.selectrid(rid);
			ReservationVO rrv = reservationbiz.get(rid);
			Detail_SchedulesVO ddsv = detail_schedulesbiz.get(Integer.parseInt(sid), Integer.parseInt(mcnt));
			int mid = ddsv.getMid();
			MovieVO mv = moviebiz.get(mid);
			//개봉년도
			Date date = mv.getReleasedate();
			SimpleDateFormat getyear = new SimpleDateFormat("yyyy");
			String ryear = getyear.format(date);
			
			m.addAttribute("tlist", tlist);
			m.addAttribute("rrv", rrv);
			m.addAttribute("ddsv", ddsv);
			m.addAttribute("sdate", sdate);
			m.addAttribute("ryear", ryear);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		m.addAttribute("center", "book4");
		m.addAttribute("header", "header");
		m.addAttribute("footer", "footer");
		return "index";
		

	}
	
	



}