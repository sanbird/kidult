package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.BoardDto;
import project.mapper.BoardMapper;

@Service
//@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}

	@Override
	public void insertBoard(BoardDto boardDto) throws Exception {
		boardMapper.insertBoard(boardDto);		
	}
	
	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);			// 조회수를 증가
		return boardMapper.selectBoardDetail(boardIdx);		// 게시판 상세 내용을 조회
	}
	
	@Override
	public int updateBoard(BoardDto boardDto) throws Exception {
		return boardMapper.updateBoard(boardDto);		
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
	}
	
	@Override
	public BoardDto showBoardDetail(int boardIdx) throws Exception {
		return boardMapper.selectBoardDetail(boardIdx);
	}
	

	
	
}
