package test_0613;

import java.sql.Date;

public class MemberDTO {
	private int mno;
	private String bwriter;
	private String id;
	private String pw;
	private Date regidate;

	public MemberDTO() {
	}

	public MemberDTO(int mno, String bwriter, String id, String pw, Date regidate) {
		this.mno = mno;
		this.bwriter = bwriter;
		this.id = id;
		this.pw = pw;
		this.regidate = regidate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
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

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "[번호: " + mno + ", 이름: " + bwriter + ", ID: " + id + ", PW: " + pw + ", 가입일: " + regidate + "]";
	}
}
