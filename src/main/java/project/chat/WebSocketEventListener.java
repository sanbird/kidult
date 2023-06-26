package project.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.extern.slf4j.Slf4j;
import project.dto.ChatDto;
import project.service.ChatService;

@Slf4j
@Component
public class WebSocketEventListener {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@Autowired
	private ChatService chatService;

	// #1
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		log.info("Received a new web socket connection");
	}

	// #2
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) throws Exception {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

		String username = (String) headerAccessor.getSessionAttributes().get("username");
		String chatroomIdx = (String) headerAccessor.getSessionAttributes().get("chatroomIdx");
		

		ChatDto chatMessage = new ChatDto();
		chatMessage.setType(ChatDto.MessageType.LEAVE);
		chatMessage.setSender(username);
		chatMessage.setMessage(username + "님이 퇴장하셨습니다.");
		
		if (username != null && chatroomIdx != null) {
			log.info("User Disconnected : " + username);
			
			chatService.insertMessage(chatMessage);
			messagingTemplate.convertAndSend("/topic/chatting/" + chatroomIdx, chatMessage);
		}
	}
}