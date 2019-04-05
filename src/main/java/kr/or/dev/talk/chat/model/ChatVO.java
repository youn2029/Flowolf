package kr.or.dev.talk.chat.model;

import java.util.Date;

public class ChatVO implements Comparable<ChatVO>{
	
	private int chat_no;			// 채팅방번호
	private String chat_title;		// 채팅방제목
	private Date chat_time;			// 개설일시
	private String chat_del_chk;	// 삭제여부	
	private String mem_id;			// 개설자ID
	private String chat_ip;			// ip주소
	private int chat_port;			// port번호
	
	private String chat_cont;		// 채팅내용
	private String chat_con_time;	// 채팅일시
	private int in_mem_num;			// 참여인원
	private String ptn_id;			// 파트너
	private Date time;				// 채팅 내용 및 파일 등록 시간
	
	
	
	
	

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getPtn_id() {
		return ptn_id;
	}

	public void setPtn_id(String ptn_id) {
		this.ptn_id = ptn_id;
	}

	public int getIn_mem_num() {
		return in_mem_num;
	}

	public void setIn_mem_num(int in_mem_num) {
		this.in_mem_num = in_mem_num;
	}

	public int getChat_no() {
		return chat_no;
	}

	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}

	public String getChat_title() {
		return chat_title;
	}

	public void setChat_title(String chat_title) {
		this.chat_title = chat_title;
	}

	public Date getChat_time() {
		return chat_time;
	}

	public void setChat_time(Date chat_time) {
		this.chat_time = chat_time;
	}

	public String getChat_del_chk() {
		return chat_del_chk;
	}

	public void setChat_del_chk(String chat_del_chk) {
		this.chat_del_chk = chat_del_chk;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getChat_cont() {
		return chat_cont;
	}

	public void setChat_cont(String chat_cont) {
		this.chat_cont = chat_cont;
	}

	public String getChat_con_time() {
		return chat_con_time;
	}

	public void setChat_con_time(String chat_con_time) {
		this.chat_con_time = chat_con_time;
	}

	public String getChat_ip() {
		return chat_ip;
	}

	public void setChat_ip(String chat_ip) {
		this.chat_ip = chat_ip;
	}

	public int getChat_port() {
		return chat_port;
	}

	public void setChat_port(int chat_port) {
		this.chat_port = chat_port;
	}

	@Override
	public int compareTo(ChatVO chatVo) {
		return time.compareTo(chatVo.time);
	}

	
}
