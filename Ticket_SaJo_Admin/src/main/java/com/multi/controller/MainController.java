package com.multi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AdminBiz;
import com.multi.biz.CodeBiz;
import com.multi.biz.CustBiz;
import com.multi.biz.SchedulesBiz;
import com.multi.biz.TicketBiz;
import com.multi.biz.VisitBiz;
import com.multi.vo.AdminVO;
import com.multi.vo.CodeVO;
import com.multi.vo.VisitVO;

@Controller
public class MainController {

	@Autowired
	AdminBiz abiz;
	@Autowired
	CodeBiz cbiz;
	
	@Autowired
	VisitBiz vbiz;
	
	@Autowired
	SchedulesBiz sbiz;
	
	@Autowired
	CustBiz cubiz;
	
	@Autowired
	TicketBiz tbiz;
	


	@RequestMapping("/")
	public String main(Model m, HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");
		int today_visit = 0;
		int today_movie_cnt = 0;
		int today_ticketBuy_cnt = 0;
		int tomorrow_movie_cnt = 0;
		int custCnt = 0; // 누적 회원수 
		int custExitCnt = 0; // 탈퇴 회원수 
		List<VisitVO> visitList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(); // 오늘 상영할 영화에서 사용할 변수 
		cal.setTime(new Date());
		Date today = null;
		Date tomorrow = null;

		
		try {
			today = sdf.parse(sdf.format(cal.getTime()));// 오늘 날짜
			cal.add(Calendar.DATE, +1); //1일 더하기 
			tomorrow = sdf.parse(sdf.format(cal.getTime()));// 내일날짜 
//			System.out.println(today);
//			System.out.println(tomorrow);
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		

		if (admin==null) {// 로그인 안했을 경우 실행 
			return "/login";
		}else {// 로그인 했을경우 실행 
			try {
				// 방문자수 처리 
				visitList = vbiz.get();
//				System.out.println("visitList : " + visitList );
				if(visitList.isEmpty()) {// 아무 필드도 없을 경우 
					vbiz.register(new VisitVO("Unknown", 0,new Date()));// 필드 하나 추가 
				}
				today_visit = vbiz.SumCount();// 오늘 사이트 방문자 횟수
				m.addAttribute("today_visit", today_visit);
				
				
				// 현재 상영중인 영화 수 
				today_movie_cnt = sbiz.todayMovieCnt(today);
				tomorrow_movie_cnt = sbiz.todayMovieCnt(tomorrow);
				m.addAttribute("today_movie_cnt", today_movie_cnt);
				m.addAttribute("tomorrow_movie_cnt", tomorrow_movie_cnt);
				
				
				// 누적 회원 수 
				custCnt = cubiz.selectCustCnt();
				custExitCnt = cubiz.selectExitCnt();
				m.addAttribute("custCnt", custCnt);
				m.addAttribute("custExitCnt", custExitCnt);
				
				// 당일 예약 수 
				today_ticketBuy_cnt = tbiz.todayticketBuyCnt(today);
				m.addAttribute("today_ticketBuy_cnt", today_ticketBuy_cnt);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			


			m.addAttribute("center", "center");
			return "index";
		}
	}

	@RequestMapping("/login")
	public String login(Model m, String msg) {
		if(msg != null && msg.equals("f")) {
			m.addAttribute("msg", "아이디, 비밀번호를 확인하세요");
		}
		m.addAttribute("center", "login");
		return "login";
	}
	@RequestMapping("/loginimpl")
	public String loginimpl(Model m, String id, String pwd, HttpSession session) {
		AdminVO admin = null;
		try {
			admin = abiz.get(id);
			if(admin == null) {
				throw new Exception();
			}
			if(admin.getPwd().equals(pwd)) {
				session.setAttribute("loginadmin", admin);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return "redirect:/login?msg=f";
		}
		return "redirect:/";
	}
	@RequestMapping("/register")
	public String register(Model m,String msg) {
		if(msg != null && msg.equals("f")) {
			m.addAttribute("msg", "코드가 잘못되었습니다.");
		}
		return "register";
	}
	@RequestMapping("/registerimpl")
	public String registerimpl(Model m , String id, String pwd, String code, HttpSession session) {
		AdminVO admin = new AdminVO(id, pwd);
		try {
			CodeVO clist = cbiz.selectcode(code);
			if(clist == null) {
				throw new Exception();
			}else if(clist != null) {
				abiz.register(admin);
				session.setAttribute("loginadmin", admin);
			}
		} catch (Exception e) {
			return "redirect:/register?msg=f";
		}

		return "redirect:/";
	}
	@RequestMapping("/signout")
	public String signout(Model m, HttpSession session) {
		if(session !=null ) {
			session.invalidate();         
		}
		return "redirect:/";
	}
	@RequestMapping("/master")
	public String master(Model m, HttpSession session) {
		AdminVO admin = (AdminVO) session.getAttribute("loginadmin");

		CodeVO code1 = null;
		try {
			cbiz.autoupdate();
			code1 = cbiz.get(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (admin==null) {
			return "/login";
		}else {
			m.addAttribute("code", code1);
		}
		return "master";
	}

}