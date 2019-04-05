package kr.or.dev.talk.chat.service;

import java.util.List;
import java.util.Map;

import kr.or.dev.talk.chat.model.ChatVO;

public interface ChatServiceInf {

	/**
	* Method : getChatList
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원 아이디를 매개변수로 받아 참여중인 채팅방 목록을 반환
	*/
	List<ChatVO> getChatList(String mem_id);
	
	/**
	* Method : getChatDetail
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅방 번호를 매개변수로 받아 해당 채팅방의 상세정보 반환
	*/
	ChatVO getChatDetail(int chat_no);
	
	/**
	* Method : insertChat
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatVo
	* @return
	* Method 설명 : 채팅방 객체를 매개변수로 받아 채팅방 생성
	*/
	int insertChat(ChatVO chatVo);
	
	/**
	* Method : updateChat
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatVo
	* @return
	* Method 설명 : 채팅방 객체를 매개변수로 받아 채팅방 수정
	*/
	int updateChat(ChatVO chatVo);
	
	/**
	* Method : deleteChat
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅방 번호를 매개변수로 받아 해당 채팅방 삭제
	*/
	int deleteChat(int chat_no);
	
	/**
	* Method : getChatSeq
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 채팅방 등록에 사용되는 채팅방 번호 반환
	*/
	int getChatSeq();
	
}
