package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.biz.PointlistBiz;
import com.multi.biz.ReceiptBiz;
import com.multi.vo.CustVO;
import com.multi.vo.PointlistVO;
import com.multi.vo.ReceiptVO;

@Controller
@RequestMapping("/orc")
public class ORCController {
	
	
	@Autowired
	CustBiz cbiz;
	
	@Autowired
	PointlistBiz pbiz;
	
	@Autowired
	ReceiptBiz recbiz;
	
	String msg;
	
	@RequestMapping("")
	public String orc(Model m) {
		m.addAttribute("center", "/orc/orc");
		m.addAttribute("msg", msg);
		return "index";
	}
	
	@RequestMapping("/orcimpl")
	public String orcimpl(Model m, HttpSession session,int paymoney, String barcode) {
		msg = "";
		PointlistVO pl = null;
		CustVO cust = (CustVO) session.getAttribute("user"); // ======> login 기능 구현시 추가 
		System.out.println("orcimpl barcode : " + barcode);
		System.out.println("orcimpl paymoney : " + paymoney);
		
		try {
			
			cust.setPoint(cust.getPoint() + paymoney);// 영수증 적립금 500원 적립
			cbiz.modify(cust);// 적립금 수정 
			
			pl = new PointlistVO(cust.getId(), paymoney,"영수증 적립 이벤트로 " + paymoney + "원 적립");// 적립금 내역에 추가 
			pbiz.register(pl);
			
			recbiz.register(new ReceiptVO(barcode,null,"영수증 적립 이벤트로 " + paymoney + "원 적립"));// 사용한 영수증을 영수증 관리 테이블에 추가 
			
			msg = "영수증 적립이 완료되었습니다. 이벤트에 참여해 주셔서 감사합니다!";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "영수증 적립에 실패했습니다. ";
		}

		m.addAttribute("msg", msg);

		return "redirect:/orc";
	}
}
