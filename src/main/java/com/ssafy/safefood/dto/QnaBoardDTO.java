package com.ssafy.safefood.dto;

public class QnaBoardDTO {
	private int qnum;
	private String id;
	private String title;
	private String content;
	private int hit;
	private String regdate;
	
	public QnaBoardDTO(int qnum, String id, String title, String content, int hit, String regdate) {
		super();
		this.qnum = qnum;
		this.id = id;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regdate = regdate;
	}
	
	public QnaBoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getQnum() {
		return qnum;
	}

	public void setQnum(int qnum) {
		this.qnum = qnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
