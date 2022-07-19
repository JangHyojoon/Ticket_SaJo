package com.multi.frame;

import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static void saveFile(MultipartFile mf) {
		System.out.println("saveFile 시작 ... ");
		String filename = mf.getOriginalFilename();// 파일 이름 출력 
		String dir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static","images","receipt",filename).toString();//이미지 저장 경로
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
	
}




