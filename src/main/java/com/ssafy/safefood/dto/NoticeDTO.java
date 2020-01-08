package com.ssafy.safefood.dto;

public class NoticeDTO {
	private int num;
	private String id;
	private String from_id;
	private String title;
	private String content;
	private String img;
	private int read;
	private String regdate;
	
	public NoticeDTO() {
		super();
	}



	public NoticeDTO(int num, String id, String from_id,String title , String content, String img, int read, String regdate) {
		super();
		this.num = num;
		this.id = id;
		this.from_id = from_id;
		this.title = title;
		this.content = content;
		this.img = img;
		this.read = read;
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



	public String getFrom_id() {
		return from_id;
	}



	public void setFrom_id(String from_id) {
		this.from_id = from_id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public int getRead() {
		return read;
	}



	public void setRead(int read) {
		this.read = read;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	
}
