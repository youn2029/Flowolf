package kr.or.dev.group.kind.model;

import java.util.Date;

public class KindVO {
	
	private int kind_no;			// 분류코드
	private String kind_name;		// 분류명
	private Date kind_date;			// 등록일	
	private String kind_del_chk;	// 삭제여부

	public int getKind_no() {
		return kind_no;
	}

	public void setKind_no(int kind_no) {
		this.kind_no = kind_no;
	}

	public String getKind_name() {
		return kind_name;
	}

	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}

	public Date getKind_date() {
		return kind_date;
	}

	public void setKind_date(Date kind_date) {
		this.kind_date = kind_date;
	}

	public String getKind_del_chk() {
		return kind_del_chk;
	}

	public void setKind_del_chk(String kind_del_chk) {
		this.kind_del_chk = kind_del_chk;
	}
	
	
	
}
