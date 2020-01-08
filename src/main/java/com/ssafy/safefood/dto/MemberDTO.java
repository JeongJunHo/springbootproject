package com.ssafy.safefood.dto;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String addr;
	private String tel;
	private String allergy;

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String id) {
		this.id = id;
	}
	public MemberDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public MemberDTO(String id, String pw, String name, String addr, String tel, String allergy) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.addr = addr;
		this.tel = tel;
		this.allergy = allergy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", addr=" + addr + ", tel=" + tel
				+ ", allergy=" + allergy + "]";
	}
}
