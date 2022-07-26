package com.multi.ncp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;

import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
public class CFRAPI {
	 StringBuffer reqStr = new StringBuffer();
     String clientId = "xip09ymf3b";// 애플리케이션 클라이언트 아이디값";
 	 String clientSecret = "5D8Q8uZffMeO4tqndjAaSOIscimr6QC9YOxRygiL";// 애플리케이션 클라이언트 시크릿값";
 	 
 	 public Object cfrapi (String imgname) {
 		String imgpath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static","images","cfr").toString(); //내 컴퓨터
 		//String imgpath = "/root/apache-tomcat-8.5.27/webapps/ROOT/WEB-INF/classes/static/images/cfr"; //ncp
 		Object obj = null;
      
        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = imgpath+"/"+imgname;
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
                String result = response.toString();
                JSONParser parser =new JSONParser();
                obj = parser.parse(result);
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		return obj;
 	 }

}
