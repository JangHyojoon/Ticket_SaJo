package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.multi.vo.Msg;



@Controller
public class MsgController {
	
	@Autowired
	SimpMessagingTemplate template;

	@MessageMapping("/receiveall") // 모두에게 전송
	public void receiveall(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
		System.out.println(msg);
		template.convertAndSend("/sends",msg);
	}
	@MessageMapping("/receiveme") // 나에게만 전송 ex)Chatbot
	public void receiveme(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
		String id = msg.getSendid();
		String result = "";
		msg.setContent2(result);
		template.convertAndSend("/sends/"+id,msg);
	}
	@MessageMapping("/receiveto") // 특정 Id에게 전송
	public void receiveto(Msg msg, SimpMessageHeaderAccessor headerAccessor) {
		String id = msg.getSendid();
		String target = msg.getReceiveid();
		template.convertAndSend("/sends/to/"+target,msg);
	}
}
