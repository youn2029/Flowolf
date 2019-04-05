package kr.or.dev.talk.chat_con.model;

import java.util.Date;

public class ChatConVO {
	
	private int chat_con_no;		// 채팅내용번호
	private String chat_cont;		// 채팅내용
	private Date chat_con_time;		// 채팅일시	
	private int chat_no;			// 채팅방번호
	private String mem_id;			// 참여자id
	private String mem_nick;		// 참여자닉네임  : VO에서만 사용함
	private String time;			// 채팅시간 : VO에서만 사용함
	private String chat_title;		// 채팅제목 : vo에서만 사용
	private String in_mem_num;		// 채팅참여자수 : vo에서만 사용
	private String chat_ip;			// 채팅아이피 : vo에서만 사

	public String getChat_ip() {
		return chat_ip;
	}

	public void setChat_ip(String chat_ip) {
		this.chat_ip = chat_ip;
	}

	public String getChat_title() {
		return chat_title;
	}

	public void setChat_title(String chat_title) {
		this.chat_title = chat_title;
	}

	public String getIn_mem_num() {
		return in_mem_num;
	}

	public void setIn_mem_num(String in_mem_num) {
		this.in_mem_num = in_mem_num;
	}

	public int getChat_con_no() {
		return chat_con_no;
	}

	public void setChat_con_no(int chat_con_no) {
		this.chat_con_no = chat_con_no;
	}
	
	public String getChat_cont() {		
		return chat_cont;
	}

	public void setChat_cont(String chat_cont) {
		this.chat_cont = chat_cont;
	}

	public Date getChat_con_time() {
		return chat_con_time;
	}

	public void setChat_con_time(Date chat_con_time) {
		this.chat_con_time = chat_con_time;
	}

	public int getChat_no() {
		return chat_no;
	}

	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
