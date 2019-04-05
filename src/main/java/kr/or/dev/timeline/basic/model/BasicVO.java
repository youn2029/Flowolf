package kr.or.dev.timeline.basic.model;

import java.util.Date;

public class BasicVO {
	private int basic_no;			// 일반글번호
	private String basic_cont;		// 내용
	private Date basic_time;		// 작성일시
	private String basic_del_chk;	// 삭제여부
	private String basic_fix_chk;	// 고정유무
	private Date basic_fix_date;	// 고정일
	private int pro_no;				// 프로젝트번호	
	private String mem_id;			// 작성자ID
	private int coll_chk;			// 담아두기 유무(vo에서만 사용)
	private String mem_nick;		// 작성자Nick(vo에서만 사용)
	private String pro_name;		// 프로젝트명(vo에서만 사용)

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getBasic_no() {
		return basic_no;
	}

	public void setBasic_no(int basic_no) {
		this.basic_no = basic_no;
	}

	public String getBasic_cont() {
		return basic_cont;
	}

	public void setBasic_cont(String basic_cont) {
		this.basic_cont = basic_cont;
	}

	public Date getBasic_time() {
		return basic_time;
	}

	public void setBasic_time(Date basic_time) {
		this.basic_time = basic_time;
	}

	public String getBasic_del_chk() {
		return basic_del_chk;
	}

	public void setBasic_del_chk(String basic_del_chk) {
		this.basic_del_chk = basic_del_chk;
	}

	public String getBasic_fix_chk() {
		return basic_fix_chk;
	}

	public void setBasic_fix_chk(String basic_fix_chk) {
		this.basic_fix_chk = basic_fix_chk;
	}

	public Date getBasic_fix_date() {
		return basic_fix_date;
	}

	public void setBasic_fix_date(Date basic_fix_date) {
		this.basic_fix_date = basic_fix_date;
	}

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

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public int getColl_chk() {
		return coll_chk;
	}

	public void setColl_chk(int coll_chk) {
		this.coll_chk = coll_chk;
	}	
}
