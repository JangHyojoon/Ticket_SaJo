package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.ReservationBiz;
import com.multi.biz.TicketBiz;
import com.multi.vo.ReservationVO;
import com.multi.vo.TicketVO;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationBiz rbiz;
	@Autowired
	TicketBiz tbiz;
	
	@RequestMapping("")
	public String list(Model m) {
		List<ReservationVO> rlist = null;
		try {
			rlist = rbiz.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "reservation/list");
		m.addAttribute("rlist", rlist);
		return "index";
	}
	@RequestMapping("/detail")
	public String detail(Model m, Integer id) {
		List<TicketVO> tlist = null;
		try {
			tlist = tbiz.selectrid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("center", "reservation/detail");
		m.addAttribute("tlist", tlist);
		return "index";
	}
}