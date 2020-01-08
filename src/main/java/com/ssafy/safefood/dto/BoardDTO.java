package com.ssafy.safefood.dto;

public class BoardDTO {
	private int num;
	private String id;
	private String title;
	private String document;
	private int hit;

	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(int num, String id, String title, String document, int hit) {
		this.num = num;
		this.id = id;
		this.title = title;
		this.document = document;
		this.hit = hit;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", id=" + id + ", title=" + title + ", document=" + document + ", hit=" + hit
				+ "]";
	}

}
