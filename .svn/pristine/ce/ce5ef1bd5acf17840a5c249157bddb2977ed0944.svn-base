package kr.or.dev.talk.chat_file.dao;

import java.util.List;

import kr.or.dev.talk.chat_file.model.ChatFileVO;

public interface ChatFileDaoInf {

	/**
	* Method : getChatFileList
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅방 번호를 매개변수로 받아 해당 채팅방의 첨부파일 리스트 반환
	*/
	List<ChatFileVO> getChatFileList(int chat_no);
	
	/**
	* Method : insertChatFile
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatFileVo
	* @return
	* Method 설명 : 채팅방 객체를 매개변수로 받아 첨부파일 등록
	*/
	int insertChatFile(ChatFileVO chatFileVo);
	
	/**
	* Method : getChatFileDetail
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : OWNER
	* 변경이력 :
	* @param chat_file_no
	* @return
	* Method 설명 : 채팅방 첨부파일 번호를 매개변수로 받아 해당 파일 상세정보 반환
	*/
	ChatFileVO getChatFileDetail(int chat_file_no);
	
	/**
	* Method : getChatFileSeq
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : OWNER
	* 변경이력 :
	* @return
	* Method 설명 : 채팅 파일의 시퀀스 반환
	*/
	int getChatFileSeq();
}
