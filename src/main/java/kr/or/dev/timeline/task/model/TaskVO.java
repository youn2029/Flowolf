package kr.or.dev.timeline.task.model;

import java.util.Date;

public class TaskVO {
	
	private int task_no;				// 업무글번호
	private String task_title;			// 제목
	private String task_state;			// 업무상태
	private String task_cont;			// 내용
	private String task_start_date;		// 시작일
	private String task_end_date;		// 종료일
	private int task_rate;				// 진행률
	private String task_priority;		// 우선순위
	private String task_del_chk;		// 삭제여부
	private String task_fix_chk;		// 고정유무
	private Date task_fix_date;			// 고정일
	private Date task_time;				// 작성일시
	private int pro_no;					// 프로젝트번호	
	private String mem_id;				// 작성자ID
	private String mem_nick;			// 작성자Nick(vo에서만 사용)
	private int coll_chk;				// 담아두기 유무(vo에서만 사용)
	private String pro_name;			// 프로젝트명(vo에서만 사용)

	public int getTask_no() {
		return task_no;
	}

	public void setTask_no(int task_no) {
		this.task_no = task_no;
	}

	public String getTask_title() {
		return task_title;
	}

	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}

	public String getTask_state() {
		return task_state;
	}

	public void setTask_state(String task_state) {
		this.task_state = task_state;
	}

	public String getTask_cont() {
		return task_cont;
	}

	public void setTask_cont(String task_cont) {
		this.task_cont = task_cont;
	}

	public String getTask_start_date() {
		return task_start_date;
	}

	public void setTask_start_date(String task_start_date) {
		this.task_start_date = task_start_date;
	}

	// Date
	public String getTask_end_date() {
		return task_end_date;
	}

	public void setTask_end_date(String task_end_date) {
		this.task_end_date = task_end_date;
	}

	public int getTask_rate() {
		return task_rate;
	}

	public void setTask_rate(int task_rate) {
		this.task_rate = task_rate;
	}

	public String getTask_priority() {
		return task_priority;
	}

	public void setTask_priority(String task_priority) {
		this.task_priority = task_priority;
	}

	public String getTask_del_chk() {
		return task_del_chk;
	}

	public void setTask_del_chk(String task_del_chk) {
		this.task_del_chk = task_del_chk;
	}

	public String getTask_fix_chk() {
		return task_fix_chk;
	}

	public void setTask_fix_chk(String task_fix_chk) {
		this.task_fix_chk = task_fix_chk;
	}

	public Date getTask_fix_date() {
		return task_fix_date;
	}

	public void setTask_fix_date(Date task_fix_date) {
		this.task_fix_date = task_fix_date;
	}

	public Date getTask_time() {
		return task_time;
	}

	public void setTask_time(Date task_time) {
		this.task_time = task_time;
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

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	
}
