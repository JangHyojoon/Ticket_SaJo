package com.multi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.multi.ncp.Chatbot;
import com.multi.vo.Msg;



@Controller
public class MsgController {
	
	@Autowired
	SimpMessagingTemplate template;
	
	@Autowired
	Chatbot chatbot;
	
	
	@MessageMapping("/receiveme") // 나에게만 전송 ex)Chatbot
	public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
		String id = msg.getSendid();
		String result = "";
		try {
			result = chatbot.getMessage(msg.getContent1());
		} catch (IOException e) {
			e.printStackTrace();
		}
		msg.setContent2(result);
		template.convertAndSend("/sends/"+id,msg);
	}
	
}
