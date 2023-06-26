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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import project.dto.ShopDto;
import project.service.ShopService;

@Slf4j
@RestController
public class ShopController {

	@Autowired
	private ShopService shopService;

	// 물품 목록 조회
	@GetMapping("/shopList")
	public ResponseEntity<List<ShopDto>> shopList() throws Exception {
		List<ShopDto> list = shopService.selectShopList();
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// 물품 상세 조회
	@GetMapping("/shopDetail/{shopIdx}")
	public ResponseEntity<ShopDto> shopDetail(@PathVariable("shopIdx") int shopIdx) throws Exception {
		log.debug(">>>>>>>>>" + shopIdx);
		ShopDto shopDto = shopService.selectShopByShopIdx(shopIdx);
		if (shopDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(shopDto);
		}
	}

	// 물품 등록
	@PostMapping("/registShop")
	public ResponseEntity<Integer> registShop(@RequestPart(value = "files", required = false) MultipartFile[] files,
			@RequestPart(value = "data", required = false) ShopDto shopDto) throws Exception {

		int registedShop = shopService.registShop(shopDto, files);
		if (registedShop > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(registedShop);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(registedShop);
		}
	}

	// 물품 삭제
	@DeleteMapping("/deleteShop/{shopIdx}")
	public ResponseEntity<Integer> deleteShop(@PathVariable("shopIdx") int shopIdx) throws Exception {

		int deleteShop = shopService.deleteShop(shopIdx);
		if (deleteShop > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(deleteShop);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(deleteShop);
		}
	}

	// 카테고리 조회
	@GetMapping("/shopCategory")
	public ResponseEntity<List<ShopDto>> shopCategory() throws Exception {
		List<ShopDto> list = shopService.selectShopCategory();
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// 사진 다운로드
	@GetMapping("/download")
	public void downloadFile(@RequestParam String shopImage, HttpServletResponse response) throws Exception {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		try {
			response.setHeader("Content-Disposition", "inline;");

			byte[] buf = new byte[1024];

			fis = new FileInputStream(shopImage);
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

}
