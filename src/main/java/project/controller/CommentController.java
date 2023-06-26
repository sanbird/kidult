package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.dto.CommentDto;
import project.service.CommentService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
//@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
    // 댓글 목록 조회 API
    @GetMapping("/comment/{boardIdx}")
    public ResponseEntity<List<CommentDto>> selectCommentList(@PathVariable int boardIdx) throws Exception {
        List<CommentDto> commentList = commentService.selectCommentList(boardIdx);
        return new ResponseEntity<List<CommentDto>>(commentList, HttpStatus.OK);
    }

    // 댓글 작성 API
    @PostMapping("/insertcomment/{boardIdx}")
    public ResponseEntity<Integer> insertComment(@PathVariable int boardIdx, @RequestBody CommentDto commentDto) throws Exception {
        int insertComment = commentService.insertComment(commentDto);
        return ResponseEntity.status(HttpStatus.OK).body(insertComment);
    }
    
    
	// 댓글 상세 조회 API
    @GetMapping("/comment/detail/{commentIdx}")
    public ResponseEntity<Integer> selectCommentDetail(@PathVariable int commentIdx) throws Exception {
        int result = commentService.selectCommentDetail(commentIdx);
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    // 댓글 수정 API
    @PutMapping("/comment/{commentIdx}")
    public ResponseEntity<String> updateComment(@PathVariable int commentIdx, @RequestBody CommentDto commentDto) throws Exception {
        commentDto.setCommentIdx(commentIdx);
        commentService.updateComment(commentDto);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    // 댓글 삭제 API
    @PutMapping("/deletecomment/{commentIdx}")
    public ResponseEntity<String> deleteComment(@PathVariable int commentIdx) throws Exception {
        commentService.deleteComment(commentIdx);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
    
    
}
