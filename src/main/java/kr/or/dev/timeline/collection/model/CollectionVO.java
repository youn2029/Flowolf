package kr.or.dev.timeline.collection.model;

import java.util.Date;

public class CollectionVO {
	
	private int coll_no;		// 담아둔글번호
	private Date coll_date;		// 등록일
	private String mem_id;		// 회원ID
	private int schd_no;		// 일정글번호
	private int vote_no;		// 투표글번호
	private int todo_no;		// 할일번호
	private int basic_no;		// 일반글번호	
	private int task_no;		// 업무글번호

	public int getColl_no() {
		return coll_no;
	}

	public void setColl_no(int coll_no) {
		this.coll_no = coll_no;
	}

	public Date getColl_date() {
		return coll_date;
	}

	public void setColl_date(Date coll_date) {
		this.coll_date = coll_date;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getSchd_no() {
		return schd_no;
	}

	public void setSchd_no(int schd_no) {
		this.schd_no = schd_no;
	}

	public int getVote_no() {
		return vote_no;
	}

	public void setVote_no(int vote_no) {
		this.vote_no = vote_no;
	}

	public int getTodo_no() {
		return todo_no;
	}

	public void setTodo_no(int todo_no) {
		this.todo_no = todo_no;
	}

	public int getBasic_no() {
		return basic_no;
	}

	public void setBasic_no(int basic_no) {
		this.basic_no = basic_no;
	}

	public int getTask_no() {
		return task_no;
	}

	public void setTask_no(int task_no) {
		this.task_no = task_no;
	}
	
}
