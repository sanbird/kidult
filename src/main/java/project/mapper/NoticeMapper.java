package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.dto.NoticeDto;

@Mapper
public interface NoticeMapper {
	List<NoticeDto> selectNoticeList() throws Exception;
	void insertNotice(NoticeDto noticeDto) throws Exception;
	void updateHitCount(int noticeIdx) throws Exception;
	NoticeDto selectNoticeDetail(int noticeIdx) throws Exception;
	int updateNotice(NoticeDto noticeDto) throws Exception;
	void deleteNotice(int noticeIdx) throws Exception;
	NoticeDto showNoticeDetail(int noticeIdx) throws Exception;


}
