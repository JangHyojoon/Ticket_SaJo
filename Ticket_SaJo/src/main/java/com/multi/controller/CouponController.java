package com.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CouponBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.PointlistBiz;
import com.multi.vo.CouponVO;


@Controller
@RequestMapping("/coupon")
public class CouponController {
	
	
	@Autowired
	CustBiz cbiz;
	
	@Autowired
	PointlistBiz pbiz;
	
	@Autowired
	CouponBiz cobiz;
	
	@RequestMapping("")
	public String coupon(Model m) {
		List<CouponVO> couponList = null;
		try {
			couponList = cobiz.get();
			m.addAttribute("couponList", couponList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		m.addAttribute("center", "/coupon/coupon");
		return "index";
	}

}
