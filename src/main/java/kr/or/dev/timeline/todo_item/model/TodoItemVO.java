package kr.or.dev.timeline.todo_item.model;

import java.util.Date;

public class TodoItemVO {
	
	private int ti_no;			// 할일항목번호
	private String ti_cont;		// 할일내용
	private String ti_date;		// 할일일자
	private String ti_chk;		// 완료유무
	private int todo_no;		// 할일번호	
	private String ti_mem_id;	// 지정담당자ID
	private String mem_nick;	// 작성자Nick

	public int getTi_no() {
		return ti_no;
	}

	public void setTi_no(int ti_no) {
		this.ti_no = ti_no;
	}

	public String getTi_cont() {
		return ti_cont;
	}

	public void setTi_cont(String ti_cont) {
		this.ti_cont = ti_cont;
	}
	
	public String getTi_date() {
		return ti_date;
	}

	public void setTi_date(String ti_date) {
		this.ti_date = ti_date;
	}

	public String getTi_chk() {
		return ti_chk;
	}

	public void setTi_chk(String ti_chk) {
		this.ti_chk = ti_chk;
	}

	public int getTodo_no() {
		return todo_no;
	}

	public void setTodo_no(int todo_no) {
		this.todo_no = todo_no;
	}
	
	public String getTi_mem_id() {
		return ti_mem_id;
	}

	public void setTi_mem_id(String ti_mem_id) {
		this.ti_mem_id = ti_mem_id;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	

}
