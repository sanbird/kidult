package project.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.dto.ChatDto;
import project.mapper.ChatMapper;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	ChatMapper chatMapper;
	
	@Value("${application.upload-path}")
	private String uploadPath;
	
    // 한번에 가져올 이전 대화의 개수
    private final int CONST_MAX_MESSAGE_COUNT = 10;
	
    @Override
	public List<ChatDto> selectMessages(int chatroomIdx) throws Exception {
		return chatMapper.selectMessages(chatroomIdx);
	}

	@Override
	public void insertMessage(ChatDto chatDto) throws Exception {
        // 현재 시간을 설정해서 대화 내용을 저장
		LocalDateTime now = LocalDateTime.now();
		chatDto.setCreatedDt(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		chatMapper.insertMessage(chatDto);
	}	

	@Override
	public int createChat(ChatDto chatDto) throws Exception {
		return chatMapper.createChat(chatDto);
	}

	@Override
	public List<ChatDto> selectChatBySeller(int seller) throws Exception {		
		return chatMapper.selectChatBySeller(seller);
	}

	@Override
	public List<ChatDto> selectChatByBuyer(int buyer) throws Exception {
		return chatMapper.selectChatByBuyer(buyer);
	}

	@Override
	public List<ChatDto> selectDirectList() throws Exception {		
		return chatMapper.selectDirectList();
	}

	@Override
	public ChatDto selectDirectByDirectIdx(int directIdx) throws Exception {		
		return chatMapper.selectDirectByDirectIdx(directIdx);
	}

	@Override
	public int registDirect(ChatDto chatDto, MultipartFile[] files) throws Exception {		
		
		if (files != null) {
			for (MultipartFile mf : files) {
				String originFileName = mf.getOriginalFilename();
//				String savedFileName = UUID.randomUUID().toString();
				File f = new File(uploadPath + originFileName);
				mf.transferTo(f);
				chatDto.setDirectImage(uploadPath + originFileName);
			}
		}
		
		return chatMapper.registDirect(chatDto);
	}

	@Override
	public List<ChatDto> selectChat(ChatDto chatDto) throws Exception {
		return chatMapper.selectChat(chatDto);
	}

	@Override
	public int deleteDirect(int directIdx) throws Exception {		
		return chatMapper.deleteDirect(directIdx);
	}
}
