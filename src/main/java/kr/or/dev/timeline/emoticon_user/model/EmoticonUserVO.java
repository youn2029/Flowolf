package kr.or.dev.timeline.emoticon_user.model;

import java.util.Date;

public class EmoticonUserVO {

	private int emo_user_no;		// 이모티콘사용자번호(pk)
	private Date emo_user_date;		// 등록일
	private int emo_no;				// 이모티콘번호
	private String emo_name;		// 이모티콘명
	private int task_no;			// 업무글번호
	private int schd_no;			// 일정글번호
	private int vote_no;			// 투표글번호
	private int todo_no;			// 할일번호
	private int basic_no;			// 일반글번호	
	private String mem_id;			// 회원ID
	private String mem_nick;		// 작성자Nick(vo에서만 사용)

	public int getEmo_user_no() {
		return emo_user_no;
	}

	public void setEmo_user_no(int emo_user_no) {
		this.emo_user_no = emo_user_no;
	}

	public Date getEmo_user_date() {
		return emo_user_date;
	}

	public void setEmo_user_date(Date emo_user_date) {
		this.emo_user_date = emo_user_date;
	}

	public int getEmo_no() {
		return emo_no;
	}

	public void setEmo_no(int emo_no) {
		this.emo_no = emo_no;
	}

	public int getTask_no() {
		return task_no;
	}

	public void setTask_no(int task_no) {
		this.task_no = task_no;
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

	public String getEmo_name() {
		return emo_name;
	}

	public void setEmo_name(String emo_name) {
		this.emo_name = emo_name;
	}
	
	
}
