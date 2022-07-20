package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.biz.PointlistBiz;
import com.multi.vo.CustVO;
import com.multi.vo.PointlistVO;

@Controller
@RequestMapping("/orc")
public class ORCController {
	
	
	@Autowired
	CustBiz cbiz;
	
	@Autowired
	PointlistBiz pbiz;
	
	@RequestMapping("")
	public String orc(Model m) {
		m.addAttribute("center", "/orc/orc");
		return "index";
	}
	
	@RequestMapping("/orcimpl")
	public String orcimpl(Model m, HttpSession session) {
		String msg = "";
		PointlistVO pl = null;
		try {
	//		CustVO cust = (CustVO) session.getAttribute("user"); // ======> login 기능 구현시 추가 
			CustVO cust = cbiz.get("awy");
			
			cust.setPoint(cust.getPoint() + 500);// 영수증 적립금 500원 적립
			cbiz.modify(cust);// 적립금 수정 
			
			pl = new PointlistVO(cust.getId(), 500, "영수증 이벤트 ");// 적립금 내역에 추가 
			pbiz.register(pl);
			
			msg = "영수증 적립이 완료되었습니다. 이벤트에 참여해 주셔서 감사합니다!";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "영수증 적립에 실패했습니다. ";
		}

		m.addAttribute("msg", msg);

		m.addAttribute("center", "/orc/orc");
		return "index";
	}
	


}
