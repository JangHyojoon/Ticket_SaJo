package com.multi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.CustBiz;
import com.multi.vo.CustVO;


@Controller
public class MainController_jsy {
	
	@Autowired
	CustBiz custbiz;
	
	@RequestMapping("/signin")
	public String signin(Model m, String msg, HttpServletRequest request) {
		if(msg !=null && msg.equals("f")) {
			m.addAttribute("msg", "아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
		}
		// ********** 0722 - 안원영 수정 **********
		String uri = request.getHeader("Referer");
//		System.out.println("이전 url : " + uri);
	    if (uri != null && !uri.contains("/signinimpl")){// 이전페이지가 있으면 실행 
	        request.getSession().setAttribute("prevPage", uri);// session에 prevPage 변수에 이전페이지 url 기억 
	    }
		
	    // ********** 0722 - 안원영 수정 **********
	    
		m.addAttribute("center", "signin");
		return "index";
	}
	
	@RequestMapping("/signout")
	public String signout(Model m, HttpSession session) {
		if(session !=null ) {
			session.invalidate();			
		}
		return "redirect:/";
	}

	@RequestMapping("/signinimpl")
	public String signinimpl(Model m, String id, String pwd, HttpSession session) {
		String next = "";
		CustVO cust = null;

		try {
			cust = custbiz.get(id);
			if(cust !=null) {
				if(cust.getPwd().equals(pwd)) {
					session.setAttribute("user",cust);
					m.addAttribute("user", cust);
					// ********** 0722 - 안원영 수정 **********
					if(session.getAttribute("prevPage") != null) {
						String prevPage;
						String pageArr[];
						prevPage = (String) session.getAttribute("prevPage");
						pageArr = prevPage.split("/",4);// / 4개까지만 나눈다.
						
//						System.out.println("signinimpl prevPage : " + session.getAttribute("prevPage"));
//				        for(int i=0 ; i<pageArr.length ; i++)
//				        {
//				        	System.out.println("pageArr["+i+"] : " + pageArr[i]);
//				        }

						return "redirect:/"+pageArr[pageArr.length-1];
					}
					// ********** 0722 - 안원영 수정 **********
					
				}else {
					throw new Exception(); 
				}
				
			}else {
				throw new Exception();
			}
		} catch (Exception e) {	
			return "redirect:signin?msg=f";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("center", "signup");
		return "index";
	}
	
	@RequestMapping("/signupimpl")
	public String signupimpl(Model m, CustVO cust, HttpSession session) {
		try {
			System.out.println(cust);
			custbiz.register(cust);
			session.setAttribute("user", cust);
			m.addAttribute("center", "/signupok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/mypage")
	public String mypage(Model m) {
		m.addAttribute("center", "mypage");
		return "index";
	}
	
	@RequestMapping("custdelete")
		public String custdelete(Model m, HttpSession session) {
			m.addAttribute("center", "custdelete");
			return "index";
		}
	}