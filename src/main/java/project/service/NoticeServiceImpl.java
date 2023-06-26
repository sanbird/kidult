package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.NoticeDto;
import project.mapper.NoticeMapper;

@Service
//@Transactional
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeDto> selectNoticeList() throws Exception {
		return noticeMapper.selectNoticeList();
	}

	@Override
	public void insertNotice(NoticeDto noticeDto) throws Exception {
		noticeMapper.insertNotice(noticeDto);		
	}
	
	@Override
	public NoticeDto selectNoticeDetail(int noticeIdx) throws Exception {
		noticeMapper.updateHitCount(noticeIdx);			// 조회수를 증가
		return noticeMapper.selectNoticeDetail(noticeIdx);		// 게시판 상세 내용을 조회
	}
	
	@Override
	public int updateNotice(NoticeDto noticeDto) throws Exception {
		return noticeMapper.updateNotice(noticeDto);		
	}

	@Override
	public void deleteNotice(int noticeIdx) throws Exception {
		noticeMapper.deleteNotice(noticeIdx);
	}
	
	@Override
	public NoticeDto showNoticeDetail(int noticeIdx) throws Exception {
		return noticeMapper.selectNoticeDetail(noticeIdx);
	}
	

	
	
}
