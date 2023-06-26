package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.dto.ChatDto;

@Mapper
public interface ChatMapper {
	
	List<ChatDto> selectMessages(int chatroomIdx) throws Exception;
	void insertMessage(ChatDto chatDto) throws Exception;
	
	public int createChat(ChatDto chatDto) throws Exception;
	
	List<ChatDto> selectChat(ChatDto chatDto) throws Exception;
	List<ChatDto> selectChatBySeller(int seller) throws Exception;
	List<ChatDto> selectChatByBuyer(int buyer) throws Exception;
	
	List<ChatDto> selectDirectList() throws Exception;
	public ChatDto selectDirectByDirectIdx(int directIdx) throws Exception;
	public int registDirect(ChatDto chatDto) throws Exception;
	public int deleteDirect(int directIdx) throws Exception;

}
