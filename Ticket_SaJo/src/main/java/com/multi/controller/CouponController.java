package com.multi.controller;

import java.lang.reflect.Array;
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
import com.multi.vo.CouponVO;
import com.multi.vo.CustVO;
import com.multi.vo.MycouponVO;


@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	
	@Autowired
	CustBiz cbiz;
	
	@Autowired
	PointlistBiz pbiz;
	
	@Autowired
	CouponBiz cobiz;
	@Autowired
	MycouponBiz mycobiz;
	
	@RequestMapping("")
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
		
		m.addAttribute("center", "/coupon/coupon");
		return "index";
	}

}
