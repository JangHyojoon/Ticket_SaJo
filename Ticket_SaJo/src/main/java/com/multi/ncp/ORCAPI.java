package com.multi.ncp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ORCAPI {
	String apiURL = "https://xtwbhr7su2.apigw.ntruss.com/custom/v1/17243/fb64d737a4729e5285737905a977c2703f72e819a7824771b610a8f612e9f6c4/infer";
	String secretKey = "d2NVcFRPemZUYnloZkVxekpPSExyYnVxSXZwQmJHY3A=";// 

	public Object orcresult(String imgname) {
		System.out.println("orcresult API 실행 ...");
		StringBuffer response = null;
		Object obj = null;
		System.out.println("imgname : " + imgname);
		
		
		String imgpath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static","images","receipt").toString();//이미지 저장 경로 
		String imageFile = imgpath +"\\" + imgname;//이미지 이름 
		// server 주소 : /root/apache-tomcat-8.5.27/webapps/ROOT/WEB-INF/classes/static/img

		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);
			

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();
			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);// 서버에 사진 저장되었을 경우 사용
			
			System.out.println("1 success..");
			System.out.println("----------"+file.getName());
			System.out.println("----------"+file.getPath());
			System.out.println("----------"+file.getAbsolutePath());
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println("REsult:");
			System.out.println("imgae result JSON : " + response);
			
			JSONParser parser = new JSONParser();
			obj = parser.parse(response.toString());
			file.delete();// 파일 삭제 


		} catch (Exception e) {
			System.out.println("ORC API Error 발생 ... ");
			System.out.println(e);
		}
		
		System.out.println("end ORC...");
		return obj;
	}

	private void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
	IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("--").append(boundary).append("\r\n");
		sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
		sb.append(jsonMessage);
		sb.append("\r\n");

		out.write(sb.toString().getBytes("UTF-8"));
		out.flush();

		if (file != null && file.isFile()) {
			System.out.println("file isFile True... ");
			out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
			StringBuilder fileString = new StringBuilder();
			fileString
			.append("Content-Disposition:form-data; name=\"file\"; filename=");
			fileString.append("\"" + file.getName() + "\"\r\n");
			fileString.append("Content-Type: application/octet-stream\r\n\r\n");
			out.write(fileString.toString().getBytes("UTF-8"));
			out.flush();

			try (FileInputStream fis = new FileInputStream(file)) {
				byte[] buffer = new byte[8192];
				int count;
				while ((count = fis.read(buffer)) != -1) {
					out.write(buffer, 0, count);
				}
				out.write("\r\n".getBytes());
			}

			out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
		}
		out.flush();
	}	

}
