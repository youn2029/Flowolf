package kr.or.dev.timeline.emoticon_user.dao;

import java.util.List;
import java.util.Map;

import kr.or.dev.timeline.emoticon_user.model.EmoticonUserVO;

public interface EmoticonUserDaoInf {
	
	/**
	* Method : getEmoUserSeq
	* 최초작성일 : 2018. 9. 27.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 이모티콘 사용자 시퀀스 조회
	*/
	int getEmoUserSeq();
	
	/**
	* Method : insertEmoUser
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 이모티콘 사용자 등록
	*/
	int insertEmoUser(Map<String, Object> paramMap);	
	
	/**
	* Method : deleteEmoUserR
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param emo_user_no
	* @return
	* Method 설명 : 이모티콘 사용자 삭제
	*/
	int deleteEmoUserR(int emo_user_no);
	
	/**
	* Method : getEmoUserList
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 이모티콘 사용자 List 조회
	*/
	List<EmoticonUserVO> getEmoUserList(Map<String, Object> paramMap);
	
}
