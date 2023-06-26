package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import project.dto.BoardDto;
import project.service.BoardService;

// 	@Controller와 @ResponseBody 어노테이션을 결합한 형태
//	해당 API의 응답 결과를 JSON 형태로 변환해서 응답 본문으로 전송
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/*
	 * @Autowired private CommentService commentService;
	 */
	
	@ApiOperation(value="게시판 목록 조회", notes="등록된 게시물 목록을 조회합니다.")
	@GetMapping("/boardList")
	public List<BoardDto> openBoardList() throws Exception {
		return boardService.selectBoardList();
	}
	
	/*	화면은 제공하지 않으므로 삭제
	@GetMapping("/api/board/write")
	public String openBoardWrite() throws Exception {
		return "/board/restBoardWrite";
	}
	*/ 
	
	@PostMapping("/boardWrite")
	public void insertBoard(@RequestBody BoardDto boardDto) throws Exception {
		boardService.insertBoard(boardDto);
	}
	
	@GetMapping("/boardDetail/{boardIdx}")
	public BoardDto showBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		return boardService.selectBoardDetail(boardIdx);
	}
	
	@GetMapping("/boardModify/{boardIdx}")
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		return boardService.selectBoardDetail(boardIdx);
	}
	
	@PutMapping("/boardModify/{boardIdx}")
	public ResponseEntity<Integer> updateBoard(@PathVariable("boardIdx") int boardIdx, @RequestBody BoardDto boardDto) throws Exception {
		boardDto.setBoardIdx(boardIdx);
		int updatedCount = boardService.updateBoard(boardDto);
		if (updatedCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updatedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(updatedCount);
		}
	}
	
	@DeleteMapping("/boardDelete/{boardIdx}")
	public void deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
	}
	
	

}
