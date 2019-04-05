package kr.or.dev.board.post_reply.model;

import java.util.Date;

public class PostReplyVO {
	
	private int post_rep_no;			// 게시글댓글번호
	private String post_rep_cont;		// 내용
	private String post_rep_del_chk;	// 삭제여부
	private Date post_rep_date;			// 작성일
	private int post_no;				// 게시글번호	
	private String mem_id;				// 작성자ID
	private String mem_nick;			// 작성자Nick(vo에서만 사용)

	public int getPost_rep_no() {
		return post_rep_no;
	}

	public void setPost_rep_no(int post_rep_no) {
		this.post_rep_no = post_rep_no;
	}

	public String getPost_rep_cont() {
		return post_rep_cont;
	}

	public void setPost_rep_cont(String post_rep_cont) {
		this.post_rep_cont = post_rep_cont;
	}

	public String getPost_rep_del_chk() {
		return post_rep_del_chk;
	}

	public void setPost_rep_del_chk(String post_rep_del_chk) {
		this.post_rep_del_chk = post_rep_del_chk;
	}

	public Date getPost_rep_date() {
		return post_rep_date;
	}

	public void setPost_rep_date(Date post_rep_date) {
		this.post_rep_date = post_rep_date;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
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
	

}
