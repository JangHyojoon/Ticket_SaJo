package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CouponBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.MycouponBiz;
import com.multi.biz.PointlistBiz;
import com.multi.biz.ReceiptBiz;
import com.multi.vo.CouponVO;
import com.multi.vo.CustVO;
import com.multi.vo.MycouponVO;
import com.multi.vo.PointlistVO;
import com.multi.vo.ReceiptVO;

@Controller
public class EventController {
	@Autowired
	CustBiz cbiz;
	
	@Autowired
	PointlistBiz pbiz;
	
	@Autowired
	ReceiptBiz recbiz;
	
	@Autowired
	CouponBiz cobiz;
	
	@Autowired
	MycouponBiz mycobiz;
	
	String msg;
	
	@RequestMapping("/cfr")
	public String cfr(Model m) {
		m.addAttribute("center", "/event/cfr");
		return "index";
	}
	
	@RequestMapping("/orc")
	public String orc(Model m) {
		m.addAttribute("center", "/event/orc");
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
	@RequestMapping("/coupon")
	public String coupon(Model m, HttpSession session ) {
		List<CouponVO> couponList = null;
		CustVO cust = (CustVO) session.getAttribute("user");
		List<MycouponVO> mycouponlist = null;
		

		try {
			if(cust != null) {// 로그인 했을 경우
				mycouponlist = mycobiz.selectuserall(cust.getId());
				System.out.println(mycouponlist);
				couponList = cobiz.selectsortall();
			
				for(MycouponVO mc : mycouponlist) {
					for(CouponVO c : couponList) {
						if(mc.getCid() == c.getId()) {
							System.out.println("가지고 있는 쿠폰 : " + mc.getCid());
							System.out.println("쿠폰 리스트  : " + c.getId());
							c.setHascoupon("1");
						}
					}

				}
				
				m.addAttribute("couponList", couponList);
			}else {// 로그인 안했을 경우 
				System.out.println("cust 없음  ");
				couponList = cobiz.selectsortall();
				m.addAttribute("couponList", couponList);
			}
			
			System.out.println("couponList : " + couponList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "/event/coupon");
		return "index";
	}
}
