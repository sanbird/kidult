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
import project.dto.NoticeDto;
import project.service.NoticeService;

// 	@Controller와 @ResponseBody 어노테이션을 결합한 형태
//	해당 API의 응답 결과를 JSON 형태로 변환해서 응답 본문으로 전송
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//공지리스트
	@ApiOperation(value="공지 목록 조회", notes="등록된 공지 목록을 조회합니다.")
	@GetMapping("/notice")
	public List<NoticeDto> openNoticeList() throws Exception {
		return noticeService.selectNoticeList();
	}
	
	//공지작성
	@PostMapping("/noticeWrite")
	public void insertNotice(@RequestBody NoticeDto noticeDto) throws Exception {
		noticeService.insertNotice(noticeDto);
	}
	
	//공지조회
	@GetMapping("/noticeDetail/{noticeIdx}")
	public NoticeDto showNoticeDetail(@PathVariable("noticeIdx") int noticeIdx) throws Exception {
		return noticeService.selectNoticeDetail(noticeIdx);
	}
	
	//공지수정
	@PutMapping("/noticeModify/{noticeIdx}")
	public ResponseEntity<Integer> updateNotice(@PathVariable("noticeIdx") int noticeIdx, @RequestBody NoticeDto noticeDto) throws Exception {
		noticeDto.setNoticeIdx(noticeIdx);
		int updatedCount = noticeService.updateNotice(noticeDto);
		if (updatedCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updatedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(updatedCount);
		}
	}
	
	//공지삭제
	@DeleteMapping("/noticeDelete/{noticeIdx}")
	public void deleteNotice(@PathVariable("noticeIdx") int noticeIdx) throws Exception {
		noticeService.deleteNotice(noticeIdx);
	}
	
	

}
