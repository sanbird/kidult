package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.dto.CartDto;
import project.dto.UserDto;
import project.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	// 카트 조회
	@GetMapping("/cartList/{userIdx}")
	public ResponseEntity<List<CartDto>> cartList(@PathVariable("userIdx") int userIdx) 
			throws Exception {
		
		List<CartDto> list = cartService.selectCartList(userIdx);
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	// 카트 결제
	@PutMapping("/updateCart/{cartIdx}")
	public ResponseEntity<Integer> updateCart(@PathVariable("cartIdx") int cartIdx, @RequestBody CartDto cartDto)
			throws Exception {
		
		cartDto.setCartIdx(cartIdx);
		int updateCart = cartService.updateCart(cartIdx);
		if (updateCart != 1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updateCart);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(updateCart);	
		}
	}

	// 카트 생성
	@PostMapping("/registCart")
	public ResponseEntity<Integer> registCart(@RequestBody CartDto cartDto) throws Exception {

		int registedCart = cartService.registCart(cartDto);
		if (registedCart > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(registedCart);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(registedCart);
		}
	}

	// 카트 삭제
	@DeleteMapping("/deleteCart/{userIdx}")
	public ResponseEntity<Integer> deleteCart(@PathVariable("userIdx") int userIdx) 
			throws Exception {

		int deleteCart = cartService.deleteCart(userIdx);
		if (deleteCart > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(deleteCart);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(deleteCart);
		}
	}

	// 결제 진행
	@PostMapping("/registPayment")
	public ResponseEntity<Integer> registPayment(@RequestBody CartDto cartDto) throws Exception {

		int registPayment = cartService.registPayment(cartDto);
		if (registPayment > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(registPayment);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(registPayment);
		}
	}
	
	//캐시 변경
	@PutMapping("/updateCash/{userIdx}")
	public ResponseEntity<Integer> updateCash(@PathVariable("userIdx") int userIdx, @RequestBody CartDto cartDto)
			throws Exception {		
		
		cartDto.setUserIdx(userIdx);
		int updateCash = cartService.updateCash(cartDto);
		if (updateCash != 1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updateCash);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(updateCash);
		}
	}

	// 결제 내역
	@GetMapping("/paymentList/{userIdx}")
	public ResponseEntity<List<CartDto>> paymentList(@PathVariable("userIdx") int userIdx) 
			throws Exception {
		List<CartDto> list = cartService.selectPaymentList(userIdx);
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// 쿠폰 등록 -> admin으로 이동
	@PostMapping("/coupon")
	public ResponseEntity<Integer> registCoupon(@RequestBody CartDto cartDto) throws Exception {
		
		

		int registCoupon = cartService.registCoupon(cartDto);
		if (registCoupon > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(registCoupon);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(registCoupon);
		}
	}

	// 쿠폰 목록 조회 -> admin으로 이동
	@GetMapping("/coupon")
	public ResponseEntity<List<CartDto>> selectCouponList() throws Exception {
		List<CartDto> list = cartService.selectCouponList();
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// 쿠폰 지급 -> admin으로 이동
	@PostMapping("/giveCoupon")
	public ResponseEntity<Integer> giveCoupon(@RequestBody CartDto cartDto) throws Exception {

		int giveCoupon = cartService.giveCoupon(cartDto);
		if (giveCoupon > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body(giveCoupon);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(giveCoupon);
		}
	}

	// 유저 쿠폰 조회
	@GetMapping("/coupon/{userIdx}")
	public ResponseEntity<List<CartDto>> selectCouponListByUserIdx(@PathVariable("userIdx") int userIdx) 
			throws Exception {
		List<CartDto> list = cartService.selectCouponListByUserIdx(userIdx);
		if (list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// 쿠폰 사용
	@PutMapping("/useCoupon/{ucIdx}")
	public ResponseEntity<Integer> useCoupon(@PathVariable("ucIdx") int ucIdx, @RequestBody CartDto cartDto)
			throws Exception {
		
		cartDto.setUcIdx(ucIdx);
		int useCoupon = cartService.useCoupon(ucIdx);
		if (useCoupon != 1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(useCoupon);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(useCoupon);
		}
	}
	

	// 마일리지 적립
	@PutMapping("/mileage/{userIdx}")
	public ResponseEntity<Integer> getMileage(@PathVariable("userIdx") int userIdx, @RequestBody CartDto cartDto)
			throws Exception {
		
		cartDto.setUserIdx(userIdx);
		int getMileage = cartService.updateMileage(cartDto);
		if (getMileage != 1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getMileage);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(getMileage);
		}
	}
	
	// 마일리지 사용
	@PutMapping("/useMileage/{userIdx}")
	public ResponseEntity<Integer> useMileage(@PathVariable("userIdx") int userIdx, @RequestBody CartDto cartDto)
			throws Exception {
		
		cartDto.setUserIdx(userIdx);
		int useMileage = cartService.useMileage(userIdx);
		if (useMileage != 1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(useMileage);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(useMileage);
		}
	}

}
