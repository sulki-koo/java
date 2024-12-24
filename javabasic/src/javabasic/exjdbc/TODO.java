package javabasic.exjdbc;

import java.io.Serializable;
import java.sql.Timestamp;

public class TODO implements Serializable {

	private int tdno; // 연번
	private Timestamp tddate; // 작성일시
	private String tdwriter; // 작성자
	private String tdcontent; // 내용
	private String tdyn; // 완료여부

	public TODO() {
		// TODO Auto-generated constructor stub
	}

	public TODO(int tdno, Timestamp tddate, String tdwriter, String tdcontent, String tdyn) {
		this.tdno = tdno;
		this.tddate = tddate;
		this.tdwriter = tdwriter;
		this.tdcontent = tdcontent;
		this.tdyn = tdyn;
	}

	public int getTdno() {
		return tdno;
	}

	public void setTdno(int tdno) {
		this.tdno = tdno;
	}

	public Timestamp getTddate() {
		return tddate;
	}

	public void setTddate(Timestamp tddate) {
		this.tddate = tddate;
	}

	public String getTdwriter() {
		return tdwriter;
	}

	public void setTdwriter(String tdwriter) {
		this.tdwriter = tdwriter;
	}

	public String getTdcontent() {
		return tdcontent;
	}

	public void setTdcontent(String tdcontent) {
		this.tdcontent = tdcontent;
	}

	public String getTdyn() {
		return tdyn;
	}

	public void setTdyn(String tdyn) {
		this.tdyn = tdyn;
	}

	@Override
	public String toString() {
		return "번호:"+ getTdno()
		+", 등록일시:"+getTddate()
		+", 작성자:"+getTdwriter()
		+", 내용:"+getTdcontent()
		+", 완료여부:"+ (getTdyn().equals("N") ? "미완료" : "완료");
	}

} // class
