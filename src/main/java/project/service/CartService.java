package project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.dto.CartDto;

@Service
public interface CartService {
	
	List<CartDto> selectCartList(int userIdx) throws Exception;
	public int updateCart(int cartIdx) throws Exception;
	public int registCart(CartDto cartDto) throws Exception;
	public int deleteCart(int userIdx) throws Exception;
	
	public int registPayment(CartDto cartDto) throws Exception;
	List<CartDto> selectPaymentList(int userIdx) throws Exception;
	public int updateCash(CartDto cartDto) throws Exception;
	
	public int registCoupon(CartDto cartDto) throws Exception;
	List<CartDto> selectCouponList() throws Exception;
	public int giveCoupon(CartDto cartDto) throws Exception;
	public List<CartDto> selectCouponListByUserIdx(int userIdx) throws Exception;
	public int useCoupon(int ucIdx) throws Exception;
	public int updateMileage(CartDto cartDto) throws Exception;
	public int useMileage(int userIdx) throws Exception;

}
