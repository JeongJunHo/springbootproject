package com.ssafy.safefood.dto;

import java.sql.Date;

public class EatFoodInfoDTO extends EatFoodDTO {
	private String foodName;
	
	public EatFoodInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public EatFoodInfoDTO(int num, String id, int code, int cnt, String eatdate, String foodName) {
		super(num, id, code, cnt, eatdate);
		this.foodName = foodName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
}
