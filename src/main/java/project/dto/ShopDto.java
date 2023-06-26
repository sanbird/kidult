package project.dto;

import lombok.Data;

@Data
public class ShopDto {
	private int shopIdx;
	private String shopName;
	private String shopContents;
	private String shopImage;
	private String shopPrice;	
	private int shopCount;
	
	private int shopCategoryIdx;
	private String shopCategoryName;
	
	private int cashIdx;
	private int cashValue;
	
	private int expIdx;
	private int expValue;
	
	private int basketIdx;
	private int basketPrice;
	
	private int couponIdx;
	private String couponName;
	private int couponValue;
	
	private int mileageIdx;
	private int mileageValue;
}
