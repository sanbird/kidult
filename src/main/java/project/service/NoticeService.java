package project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.dto.NoticeDto;

@Service
public interface NoticeService {
	
	public List<NoticeDto> selectNoticeList() throws Exception;
	public void insertNotice(NoticeDto noticeDto) throws Exception;
	public NoticeDto selectNoticeDetail(int noticeIdx) throws Exception;
	public NoticeDto showNoticeDetail(int noticeIdx) throws Exception; //상세페이지
	int updateNotice(NoticeDto noticeDto) throws Exception;
	void deleteNotice(int noticeIdx) throws Exception;
	
}

