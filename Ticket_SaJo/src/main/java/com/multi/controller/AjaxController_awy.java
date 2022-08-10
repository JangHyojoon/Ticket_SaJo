package com.multi.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.multi.biz.MycouponBiz;
import com.multi.biz.ReceiptBiz;
import com.multi.biz.VisitBiz;
import com.multi.frame.Util;
import com.multi.ncp.ORCAPI;
import com.multi.vo.CustVO;
import com.multi.vo.MycouponVO;
import com.multi.vo.ReceiptVO;
import com.multi.vo.VisitVO;

@RestController
public class AjaxController_awy {

	@Autowired
	ORCAPI orcapi;


	@Autowired
	MycouponBiz mcbiz;

	@Autowired
	ReceiptBiz rebiz;

	@Autowired
	VisitBiz vbiz;

	@RequestMapping("/orcresult")//ORC 영수증 인식 이용 
	public Object orcresult(MultipartHttpServletRequest filelist) {
		Object obj = null;
		String fieldName = "";
		MultipartFile mfile = null; 
		System.out.println("orcresult 실행 ... ");


		//filelist --> 넘어온 파일 리스트
		//MultipartFile로 이름을 주어서 따로 받을 수 있다. ajax로 file1로 보냈으니 받을 때 MultipartFile file1 이런식으로도 가능하다.
		//MultipartHttpServletRequest로 받으면 한번에 객체를 통째로 받아서 나름 편하다.
		Iterator<String> iter = filelist.getFileNames(); 
		while (iter.hasNext()) { 
			fieldName = (String) iter.next(); //파일이름, 위에서 file1과 file2로 보냈으니 file1, file2로 나온다.
			mfile = filelist.getFile(fieldName);  //저장된 파일 객체

			//	        System.out.println(mfile);
			//	        System.out.println(fieldName);
			//	        System.out.println(mfile.getOriginalFilename());


			Util.saveFile(mfile);//서버에 파일을 저장하는 모듈 

		}
		obj = orcapi.orcresult(mfile.getOriginalFilename());// ORC 판독 진행 
		return obj;
	}

	@RequestMapping("/userCouponCheck")//유저가 쿠폰 가지고 있는지 체크
	public String userCouponCheck(HttpSession session, int couponid) {
		String result = "0";
		CustVO cust = (CustVO) session.getAttribute("user");
		List<MycouponVO> mycouponList = null;
		MycouponVO mycoupon = null;
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("userId", cust.getId());
		map.put("couponid", couponid);

		try {
			mycouponList = mcbiz.selectKeepCoupon(map);
			System.out.println("쿠폰 유무 확인 : " + mycouponList);

			if(mycouponList.isEmpty()) {//비어있으면 로그인한 아이디에 해당 쿠폰 없다는 것임. 발급 받아도 됨
				mycoupon = new MycouponVO(cust.getId(),couponid,true);
				mcbiz.register(mycoupon);// 쿠폰 추가 
				result = "1"; // 발급 성공 
			}else {// 발급 취소시켜야함 
				result = "0";// 발급 취소 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@RequestMapping("/orcBarcodeCheck")//영수증이 중복 사용되었는지 체크
	public boolean orcBarcodeCheck(HttpSession session, String barcode) {
		boolean result = false;
		ReceiptVO receipt = null;

		try {
			receipt = rebiz.get(barcode);
			System.out.println("가져온 receipt : " + receipt);

			if(receipt != null) {// 만약 있다면 중복사용했다는 뜻임
				result = false;
			}else {// 적립 가능한 영수증 바코드일 경우 실행
				//				rebiz.register(new ReceiptVO(barcode,null,"영수증 적립 이벤트 : "));// 해당 영수증 바코드 저장 후 적립 가능으로 변경 
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	@RequestMapping("/addvisit")
	public int addvisit(HttpSession session) {
		CustVO cust = (CustVO) session.getAttribute("user");
		int todayVisitPepleAll = 0; //오늘 방문한 사람 수 
		VisitVO today_visit;
		VisitVO unknown_visit;
		
//		System.out.println("ajax cust : " + cust);
		try {

			if(cust == null) { //로그인 안한 경우  
//				System.out.println("로그인 안한 경우 ajax");
				unknown_visit = vbiz.get("Unknown"); // 데이터베이스에 Unknown 으로 방문한 사람있는지 체크 
				if(unknown_visit != null) {// Unkown으로 방문한 사람 있을 경우 
					// Unknown 에 카운드 1증가 
					vbiz.updateCount("Unknown");// unknown으로 카운트 1 증가 
				}else {// Unknown이 처음일 경우 테이블에 Unkown 값 추가 
					vbiz.register(new VisitVO("Unknown",1));// 새로 Unknown 생성 
				}
				
				
			}else {// 로그인 한 경우 
//				System.out.println("로그인 한 경우 ajax");
				today_visit = vbiz.get(cust.getId());// 오늘 방문한 사람인지 체크하는 변수 
				
				if(today_visit != null) { // 오늘 방문했을 경우 
					vbiz.updateCount(cust.getId());// 기존 방문횟수에서 1증가 
				}else {// 오늘 처음 방문한 경우
					vbiz.register(new VisitVO(cust.getId(),1));// 테이블에 로그인한 ID로 새로 추가 
				}
			}
			
			// 총 방문자 수 체크 
			todayVisitPepleAll = vbiz.SumCount();
//			System.out.println("오늘 방문한 사람 : " + todayVisitPepleAll);

		}

		catch (Exception e) {
			e.printStackTrace();
		} 
		
		return todayVisitPepleAll;

	}
}
