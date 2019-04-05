package kr.or.dev.timeline.vote.model;

import java.util.Date;

public class VoteVO {
	
	private int vote_no;			// 투표글번호(pk)
	private String vote_title;		// 제목
	private Date vote_time;			// 작성일시
	private String vote_del_chk;	// 삭제여부
	private String vote_fix_chk;	// 고정유무
	private Date vote_fix_date;		// 고정일
	private int pro_no;				// 프로젝트번호
	private String mem_id;			// 작성자ID	
	private String vote_end_time;	// 투표종료일
	private String mem_nick;		// 작성자Nick(vo에서만 사용)
	private int coll_chk;			// 담아두기 유무(vo에서만 사용)
	private String pro_name;		// 프로젝트명(vo에서만 사용)

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getVote_no() {
		return vote_no;
	}

	public void setVote_no(int vote_no) {
		this.vote_no = vote_no;
	}

	public String getVote_title() {
		return vote_title;
	}

	public void setVote_title(String vote_title) {
		this.vote_title = vote_title;
	}

	public Date getVote_time() {
		return vote_time;
	}

	public void setVote_time(Date vote_time) {
		this.vote_time = vote_time;
	}

	public String getVote_del_chk() {
		return vote_del_chk;
	}

	public void setVote_del_chk(String vote_del_chk) {
		this.vote_del_chk = vote_del_chk;
	}

	public String getVote_fix_chk() {
		return vote_fix_chk;
	}

	public void setVote_fix_chk(String vote_fix_chk) {
		this.vote_fix_chk = vote_fix_chk;
	}

	public Date getVote_fix_date() {
		return vote_fix_date;
	}

	public void setVote_fix_date(Date vote_fix_date) {
		this.vote_fix_date = vote_fix_date;
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

	// Date
	public String getVote_end_time() {
		return vote_end_time;
	}

	public void setVote_end_time(String vote_end_time) {
		this.vote_end_time = vote_end_time;
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
