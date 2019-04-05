package kr.or.dev.timeline.reply.model;

import java.util.Date;

public class ReplyVO {

	private int rep_no;				// 댓글번호(pk)
	private String rep_cont;		// 댓글내용
	private Date rep_time;			// 작성일시
	private String rep_del_chk;		// 삭제여부
	private String mem_id;			// 작성자ID
	private int schd_no;			// 일정글번호
	private int vote_no;			// 투표글번호
	private int todo_no;			// 할일번호
	private int basic_no;			// 일반글번호	
	private int task_no;			// 업무글번호
	private String mem_nick;		// 작성자Nick(vo에서만 사용)

	public int getRep_no() {
		return rep_no;
	}

	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}

	public String getRep_cont() {
		return rep_cont;
	}

	public void setRep_cont(String rep_cont) {
		this.rep_cont = rep_cont;
	}

	public Date getRep_time() {
		return rep_time;
	}

	public void setRep_time(Date rep_time) {
		this.rep_time = rep_time;
	}

	public String getRep_del_chk() {
		return rep_del_chk;
	}

	public void setRep_del_chk(String rep_del_chk) {
		this.rep_del_chk = rep_del_chk;
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

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	
	
}
