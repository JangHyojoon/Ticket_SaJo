package com.multi.frame;

import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile mf) {
		System.out.println("saveFile 시작 ... ");
		String filename = mf.getOriginalFilename();// 파일 이름 출력 
		//String dir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static","images","receipt",filename).toString();//이미지 저장 경로

		String dir = "/root/apache-tomcat-8.5.27/webapps/ROOT/WEB-INF/classes/static/images/receipt/" + filename;// ncp 서버경로로 변경 
		// /root/apache-tomcat-8.5.27/webapps/ROOT/WEB-INF/classes/static/images/receipt


		System.out.println("이미지 저장할 path : " + dir);

		byte [] data;
		
		try {
			System.out.println("이미지 저장 시작 ...");
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(dir);//receipt 파일밑에 이미지 저장 
			fo.write(data);
			fo.close();
		}catch(Exception e) {
			
		}
		
	}
	public static void saveFile2(MultipartFile mf) {
		String filename = mf.getOriginalFilename();// 파일 이름 출력 
		//String dir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static","images","cfr",filename).toString();//이미지 저장 경로 내컴퓨터에서
		String dir = "/root/apache-tomcat-8.5.27/webapps/ROOT/WEB-INF/classes/static/images/cfr/" + filename;// ncp 서버경로로 변경 
		byte [] data;
		
		try {
			System.out.println("이미지 저장 시작 ...");
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(dir);
			fo.write(data);
			fo.close();
		}catch(Exception e) {
			
		}
		
	}
	
}