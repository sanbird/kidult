package project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.dto.BoardDto;

@Service
public interface BoardService {
	public List<BoardDto> selectBoardList() throws Exception;
	public void insertBoard(BoardDto boardDto) throws Exception;
	public BoardDto selectBoardDetail(int boardIdx) throws Exception;
	public BoardDto showBoardDetail(int boardIdx) throws Exception; //상세페이지
	int updateBoard(BoardDto boardDto) throws Exception;
	void deleteBoard(int boardIdx) throws Exception;
	
}

