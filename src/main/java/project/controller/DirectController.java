package project.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import project.dto.ChatDto;
import project.service.ChatService;

@Slf4j
@RestController
public class DirectController {

	@Autowired
	ChatService chatService;

	// 판매자 채팅방 조회
	@GetMapping("/chatSell/{userIdx}")
	public ResponseEntity<List<ChatDto>> selectChatBySeller(@PathVariable("userIdx") int userIdx) throws Exception {

		List<ChatDto> list = chatService.selectChatBySeller(userIdx);

		if (list != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}

	// 구매자 채팅방 조회
	@GetMapping("/chatBuy/{userIdx}")
	public ResponseEntity<List<ChatDto>> selectChatByBuyer(@PathVariable("userIdx") int userIdx) throws Exception {

		List<ChatDto> list = chatService.selectChatByBuyer(userIdx);

		if (list != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}

	//
	// 물품 목록 조회
	@GetMapping("/directList")
	public ResponseEntity<List<ChatDto>> directList() throws Exception {
		List<ChatDto> list = chatService.selectDirectList();
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// 물품 상세 조회
	@GetMapping("/directDetail/{directIdx}")
	public ResponseEntity<ChatDto> directDetail(@PathVariable("directIdx") int directIdx) throws Exception {
		log.debug(">>>>>>>>>" + directIdx);
		ChatDto chatDto = chatService.selectDirectByDirectIdx(directIdx);
		if (chatDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(chatDto);
		}
	}

	// 물품 등록
	@PostMapping("/registDirect")
	public ResponseEntity<Integer> registDirect(@RequestPart(value = "files", required = false) MultipartFile[] files,
			@RequestPart(value = "data", required = false) ChatDto chatDto) throws Exception {

		int registedDirect = chatService.registDirect(chatDto, files);
		if (registedDirect > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(registedDirect);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(registedDirect);
		}
	}

	// 물품 삭제
	@DeleteMapping("/deleteDirect/{directIdx}")
	public ResponseEntity<Integer> deleteDirect(@PathVariable("directIdx") int directIdx) throws Exception {

		int deleteDirect = chatService.deleteDirect(directIdx);
		if (deleteDirect > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(deleteDirect);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(deleteDirect);
		}
	}

	// 사진 다운로드
	@GetMapping("/downloadDirect")
	public void downloadDirectFile(@RequestParam String directImage, HttpServletResponse response) throws Exception {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		try {
			response.setHeader("Content-Disposition", "inline;");

			byte[] buf = new byte[1024];

			fis = new FileInputStream(directImage);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			int read;
			while ((read = bis.read(buf, 0, 1024)) != -1) {
				bos.write(buf, 0, read);
			}
		} finally {
			bos.close();
			bis.close();
			fis.close();

		}

	}

	// 채팅방 생성
	@PostMapping("/chatroom")
	public ResponseEntity<Integer> createChat(@RequestBody ChatDto chatDto) throws Exception {

		int createChat = chatService.createChat(chatDto);
		if (createChat > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createChat);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(createChat);
		}
	}

	// 전체 채팅방 조회
	@GetMapping("/chatroom")
	public ResponseEntity<List<ChatDto>> selectChat(@RequestBody ChatDto chatDto) throws Exception {

		List<ChatDto> list = chatService.selectChat(chatDto);

		if (list != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}

}
