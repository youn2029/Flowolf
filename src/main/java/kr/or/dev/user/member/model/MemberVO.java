package kr.or.dev.user.member.model;

import java.util.Date;

public class MemberVO {

	private String mem_id;			// 이메일
	private String mem_name;		// 이름
	private String mem_nick;		// 닉네임
	private String mem_pw;			// 비밀번호
	private Date mem_date;			// 가입일
	private String mem_chk;			// 활성화유무
	private String mem_alim_kind;	// 알림구분
	private String mem_pic_name;	// 프로필사진명
	private String mem_pic_path;	// 프로필사진경로
	private String mem_pic_upload;	// 프로필업로드명	
	private String mem_phone;		// 핸드폰번호
	private String mem_howjoin;		// 가입방법
	private String rn;				// 순서(vo에서만 사용)	

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public Date getMem_date() {
		return mem_date;
	}

	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}

	public String getMem_chk() {
		return mem_chk;
	}

	public void setMem_chk(String mem_chk) {
		this.mem_chk = mem_chk;
	}

	public String getMem_alim_kind() {
		return mem_alim_kind;
	}

	public void setMem_alim_kind(String mem_alim_kind) {
		this.mem_alim_kind = mem_alim_kind;
	}

	public String getMem_pic_name() {
		return mem_pic_name;
	}

	public void setMem_pic_name(String mem_pic_name) {
		this.mem_pic_name = mem_pic_name;
	}

	public String getMem_pic_path() {
		return mem_pic_path;
	}

	public void setMem_pic_path(String mem_pic_path) {
		this.mem_pic_path = mem_pic_path;
	}

	public String getMem_pic_upload() {
		return mem_pic_upload;
	}

	public void setMem_pic_upload(String mem_pic_upload) {
		this.mem_pic_upload = mem_pic_upload;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_howjoin() {
		return mem_howjoin;
	}

	public void setMem_howjoin(String mem_howjoin) {
		this.mem_howjoin = mem_howjoin;
	}
	
}
