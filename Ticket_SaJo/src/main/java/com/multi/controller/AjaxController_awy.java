package com.multi.controller;

import java.io.IOException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.multi.frame.Util;
import com.multi.ncp.ORCAPI;

@RestController
public class AjaxController_awy {
	
	@Autowired
	ORCAPI orcapi;
	
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
	
	
	
	
}
