package project.dto;

import lombok.Data;

@Data
public class CartDto {
	
	private int cartIdx;
	private int cartPrice;
	private int cartCount;
	private String cartDate;
	private String cartDeleted;
	
	private int userIdx;
	private int cash;
	private int mileage;
	
	private int shopIdx;
	private String shopName;
	private String shopImage;
	private int shopPrice;
	private int shopCount;
	
	private int couponIdx;
	private String couponName;
	private int couponValue;
	
	private int paymentIdx;
	private int paymentPrice;
	private String paymentName;
	private String paymentPhone;
	private String paymentAddress;
	private String paymentDate;
	
	private int ucIdx;
	private String ucDeleted;
	
	
	

}
