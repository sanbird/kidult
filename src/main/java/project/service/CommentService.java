package project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.dto.CommentDto;

@Service
public interface CommentService {
	public List<CommentDto> selectCommentList(int boardIdx) throws Exception;
	public int insertComment(CommentDto commentDto) throws Exception;
	public int selectCommentDetail(int commentIdx) throws Exception;
	void updateComment(CommentDto commentDto) throws Exception;
	public int deleteComment(int commentIdx) throws Exception;
	void updateReplyCount(int boardIdx) throws Exception;
	
}