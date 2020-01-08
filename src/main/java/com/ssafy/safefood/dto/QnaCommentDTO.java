package com.ssafy.safefood.dto;

public class QnaCommentDTO {
	private int anum;
	private int qnum;
	private String id;
	private String content;
	private String regdate;
	public QnaCommentDTO(int anum, int qnum, String id, String content, String regdate) {
		this.anum = anum;
		this.qnum = qnum;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
	}
	public QnaCommentDTO() {}
	
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
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
