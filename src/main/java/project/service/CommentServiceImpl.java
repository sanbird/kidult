package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.CommentDto;
import project.mapper.CommentMapper;

@Service
//@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<CommentDto> selectCommentList(int boardIdx) throws Exception {
		return commentMapper.selectCommentList(boardIdx);
	}
		
	
	@Override
	public int insertComment(CommentDto commentDto) throws Exception {
		return commentMapper.insertComment(commentDto);		
	}
	
	@Override
	public void updateComment(CommentDto commentDto) throws Exception {
		commentMapper.updateComment(commentDto);		
	}

	@Override
	public int deleteComment(int commentIdx) throws Exception {
		return commentMapper.deleteComment(commentIdx);
	}

	@Override
	public int selectCommentDetail(int commentIdx) throws Exception {
		return commentMapper.selectCommentDetail(commentIdx);
	}


	@Override
	public void updateReplyCount(int boardIdx) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
