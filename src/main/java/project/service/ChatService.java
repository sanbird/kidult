package project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.dto.ChatDto;

@Service
public interface ChatService {

	List<ChatDto> selectMessages(int chatroomIdx) throws Exception;
	void insertMessage(ChatDto chatDto) throws Exception;
	
	public int createChat(ChatDto chatDto) throws Exception;
	
	List<ChatDto> selectChat(ChatDto chatDto) throws Exception;
	List<ChatDto> selectChatBySeller(int seller) throws Exception;
	List<ChatDto> selectChatByBuyer(int buyer) throws Exception;
	
	List<ChatDto> selectDirectList() throws Exception;
	public ChatDto selectDirectByDirectIdx(int directIdx) throws Exception;
	public int registDirect(ChatDto chatDto, MultipartFile[] files) throws Exception;
	public int deleteDirect(int directIdx) throws Exception;

}
