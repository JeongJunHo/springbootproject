package com.ssafy.safefood.dto;

public class AllergyDTO {
	int num;
	String name;
	
	public AllergyDTO() {
		super();
	}
	public AllergyDTO(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
