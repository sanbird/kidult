package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.CartDto;
import project.mapper.CartMapper;

@Service
public class CartSeviceImpl implements CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public List<CartDto> selectCartList(int userIdx) throws Exception {
		return cartMapper.selectCartList(userIdx);
	}

	@Override
	public int updateCart(int cartIdx) throws Exception {
		return cartMapper.updateCart(cartIdx);
	}

	@Override
	public int registCart(CartDto cartDto) throws Exception {
		return cartMapper.registCart(cartDto);
	}

	@Override
	public int deleteCart(int userIdx) throws Exception {
		return cartMapper.deleteCart(userIdx);
	}

	@Override
	public int registPayment(CartDto cartDto) throws Exception {
		return cartMapper.registPayment(cartDto);
	}

	@Override
	public List<CartDto> selectPaymentList(int userIdx) throws Exception {
		return cartMapper.selectPaymentList(userIdx);
	}

	@Override
	public int registCoupon(CartDto cartDto) throws Exception {
		return cartMapper.registCoupon(cartDto);
	}

	@Override
	public List<CartDto> selectCouponList() throws Exception {
		return cartMapper.selectCouponList();
	}

	@Override
	public int giveCoupon(CartDto cartDto) throws Exception {
		return cartMapper.giveCoupon(cartDto);
	}

	@Override
	public List<CartDto> selectCouponListByUserIdx(int userIdx) throws Exception {
		return cartMapper.selectCouponListByUserIdx(userIdx);
	}

	@Override
	public int useCoupon(int ucIdx) throws Exception {
		return cartMapper.useCoupon(ucIdx);
	}

	@Override
	public int updateMileage(CartDto cartDto) throws Exception {
		return cartMapper.updateMileage(cartDto);
	}
	
	@Override
	public int useMileage(int userIdx) throws Exception {
		return cartMapper.useMileage(userIdx);
	}

	@Override
	public int updateCash(CartDto cartDto) throws Exception {
		return cartMapper.updateCash(cartDto);
	}

}
