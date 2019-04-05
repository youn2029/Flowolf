package kr.or.dev.group.important.model;

import java.util.Date;

public class ImportantVO {
	
	private int pro_no;		// 프로젝트 번호
	private String mem_id;	// 회원ID	
	private Date imp_date;	// 등록일

	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public Date getImp_date() {
		return imp_date;
	}

	public void setImp_date(Date imp_date) {
		this.imp_date = imp_date;
	}
	
	
}
