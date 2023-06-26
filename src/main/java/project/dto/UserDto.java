package project.dto;

import lombok.Data;

@Data
public class UserDto {
	private int userIdx;
	private String userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String kakao;
	private int cash;	
	private int exp;
	private int mileage;
	
	private int classIdx;
	private String className;
	
	private int basketIdx;
	private int basketPrice;
	
	private int couponIdx;
	private String couponName;
	private int couponValue;
	
}
