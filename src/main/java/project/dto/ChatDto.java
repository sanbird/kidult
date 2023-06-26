package project.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatDto {
	private MessageType type;
	private String message;
	private String sender;
	private String createdDt;
	private List<ChatDto> history;
	
	
	
	public enum MessageType {
		JOIN, CHAT, LEAVE
	};
	
	private int directIdx;
	private String directName;
	private String directContents;	
	private String directImage;
	private int directPrice;
	private int directSeller;
	
	private int chatroomIdx;
	private int seller;
	private int buyer;
	

};
