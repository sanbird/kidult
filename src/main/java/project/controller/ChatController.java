package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.dto.ChatDto;
import project.service.ChatService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
public class ChatController {

	@Autowired
	ChatService chatService;

	// 사용자 등록 처리
	// 세션에 사용자 이름을 저장(#1)하고 입장 메시지(#2)와 이전 대화 내용(#3)을 추가해서 토픽을 발행(#4)
	// 세션에 저장한 사용자 이름은 WebSocketEventListener에서 연결이 끊어졌을 때 사용자를 식별하기 위한 용도로 사용
	@MessageMapping("/chat.addUser/{chatroomIdx}")
	@SendTo("/topic/chatting/{chatroomIdx}") /* #4 */
	public ChatDto addUser(@Payload ChatDto chatDto, SimpMessageHeaderAccessor headerAccessor) throws Exception {

		headerAccessor.getSessionAttributes().put("username", chatDto.getSender()); /* #1 */

		chatDto.setMessage(chatDto.getSender() + "님이 입장하셨습니다."); /* #2 */

		List<ChatDto> list = chatService.selectMessages(chatDto.getChatroomIdx()); /* #3 */
		chatDto.setHistory(list);

		return chatDto;
	}

	// 채팅 메시지 전달 처리
	// 채팅 메시지를 DB에 저장(#5)하고 토픽을 발행(#6)
	@MessageMapping("/chat.sendMessage/{chatroomIdx}")
	@SendTo("/topic/chatting/{chatroomIdx}") /* #6 */
	public ChatDto sendMessage(@Payload ChatDto chatDto) throws Exception {
		chatService.insertMessage(chatDto); /* #5 */
		return chatDto;
	}

	

	
	

}