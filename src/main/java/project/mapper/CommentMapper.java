package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.dto.CommentDto;

@Mapper
public interface CommentMapper {
	public List<CommentDto> selectCommentList(int boardIdx) throws Exception;
//	public int insertComment(CommentDto commentDto) throws Exception;
	int insertComment(CommentDto commentDto) throws Exception;
	public int selectCommentDetail(int commentIdx) throws Exception;
	void updateComment(CommentDto commentDto) throws Exception;
	public int deleteComment(int commentIdx) throws Exception;
	

}
