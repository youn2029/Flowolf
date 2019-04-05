package kr.or.dev.talk.chat_con.model;

import java.util.Date;

import kr.or.dev.talk.chat_file.model.ChatFileVO;

public class ChatConFileVO implements Comparable<ChatConFileVO>{
	
	private ChatConVO chatConVo;
	private ChatFileVO chatFileVo;
	private Date time;
	
	public ChatConVO getChatConVo() {
		return chatConVo;
	}
	public void setChatConVo(ChatConVO chatConVo) {
		this.chatConVo = chatConVo;
	}
	public ChatFileVO getChatFileVo() {
		return chatFileVo;
	}
	public void setChatFileVo(ChatFileVO chatFileVo) {
		this.chatFileVo = chatFileVo;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public int compareTo(ChatConFileVO o) {
		return time.compareTo(o.time);
	}
	
	
}


