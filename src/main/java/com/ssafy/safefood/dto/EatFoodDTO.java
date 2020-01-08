package com.ssafy.safefood.dto;

public class EatFoodDTO {
	private int num;
	private String id;
	private int code;
	private int cnt;
	private String eatdate;
	
	public EatFoodDTO(int num, String id, int code, int cnt, String eatdate) {
		super();
		this.num = num;
		this.id = id;
		this.code = code;
		this.cnt = cnt;
		this.eatdate = eatdate;
	}

	public EatFoodDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getEatdate() {
		return eatdate;
	}
	public void setEatdate(String eatdate) {
		this.eatdate = eatdate;
	}
	@Override
	public String toString() {
		return "EatFoodVO [num=" + num + ", id=" + id + ", code=" + code + ", cnt=" + cnt + ", eatdate=" + eatdate
				+ "]";
	}
}
