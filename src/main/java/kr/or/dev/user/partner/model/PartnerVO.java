package kr.or.dev.user.partner.model;

import java.util.Date;

public class PartnerVO {
	
	private int ptn_no;					// 동료신청번호
	private Date ptn_apply_date;		// 신청일
	private Date ptn_accept_date;		// 수락일
	private String ptn_chk;				// 수락여부
	private String ptn_apply;			// 신청자ID	
	private String ptn_accept;			// 수락자ID
	private String ptn_apply_nick;		// 신청자Nick
	private String ptn_accept_nick;		// 수락자Nick

	private String mem_id;			// 이메일
	private String mem_nick;		// 닉네임
	
	public int getPtn_no() {
		return ptn_no;
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

	public void setPtn_no(int ptn_no) {
		this.ptn_no = ptn_no;
	}

	public Date getPtn_apply_date() {
		return ptn_apply_date;
	}

	public void setPtn_apply_date(Date ptn_apply_date) {
		this.ptn_apply_date = ptn_apply_date;
	}

	public Date getPtn_accept_date() {
		return ptn_accept_date;
	}

	public void setPtn_accept_date(Date ptn_accept_date) {
		this.ptn_accept_date = ptn_accept_date;
	}

	public String getPtn_chk() {
		return ptn_chk;
	}

	public void setPtn_chk(String ptn_chk) {
		this.ptn_chk = ptn_chk;
	}

	public String getPtn_apply() {
		return ptn_apply;
	}

	public void setPtn_apply(String ptn_apply) {
		this.ptn_apply = ptn_apply;
	}

	public String getPtn_accept() {
		return ptn_accept;
	}

	public void setPtn_accept(String ptn_accept) {
		this.ptn_accept = ptn_accept;
	}

	public String getPtn_apply_nick() {
		return ptn_apply_nick;
	}

	public void setPtn_apply_nick(String ptn_apply_nick) {
		this.ptn_apply_nick = ptn_apply_nick;
	}

	public String getPtn_accept_nick() {
		return ptn_accept_nick;
	}

	public void setPtn_accept_nick(String ptn_accept_nick) {
		this.ptn_accept_nick = ptn_accept_nick;
	}
	
}
