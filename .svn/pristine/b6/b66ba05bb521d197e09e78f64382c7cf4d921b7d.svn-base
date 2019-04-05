package kr.or.dev.talk.chat_con.service;

import java.util.List;

import kr.or.dev.talk.chat_con.model.ChatConVO;

public interface ChatConServiceInf {

	/**
	* Method : getChatConList
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅방 번호를 매개변수로 받아 채팅내용 리스트 반환
	*/
	List<ChatConVO> getChatConList(int chat_no);
	
	/**
	* Method : insertChatCon
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatConVo
	* @return
	* Method 설명 : 채팅방 객체를 매개변수로 받아 채팅내용 등록
	*/
	int insertChatCon(ChatConVO chatConVo);
	
	/**
	* Method : getChatConSeq
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 채팅방내용 등록에 사용되는 채팅방내용 번호 반환
	*/
	int getChatConSeq();
	

	/**
	* Method : getChatCon
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 한송희
	* 변경이력 :
	* @param chat_con_no
	* @return
	* Method 설명 : 채팅방내용 번호를 매개변수로 받아 채팅내용을 반환
	*/
	ChatConVO getChatCon(int chat_con_no);
	
}
