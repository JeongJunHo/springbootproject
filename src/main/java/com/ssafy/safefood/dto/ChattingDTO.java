package com.ssafy.safefood.dto;

public class ChattingDTO {
	private int num;
	private String id;
	private String content;
	private String regdate;
	public ChattingDTO() {
		super();
	}
	public ChattingDTO(int num, String id, String content, String regdate) {
		super();
		this.num = num;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
