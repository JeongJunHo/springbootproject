package com.ssafy.safefood.dto;

public class DibFoodNameImgListDTO extends DibFoodDTO {
	private String name;
	private String img;
	public DibFoodNameImgListDTO() {
		
	}
	public DibFoodNameImgListDTO(String id, int code,int cnt, String name, String img) {
		super( id,  code, cnt);
		this.name = name;
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
