package com.ssafy.safefood.dto;

public class DibFoodDTO {
	private String id;
	private int code;
	private int cnt;

	
	public DibFoodDTO() {
	}
	
	public DibFoodDTO(String id, int code, int cnt) {
		this.id = id;
		this.code = code;
		this.cnt = cnt;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	
	
}
