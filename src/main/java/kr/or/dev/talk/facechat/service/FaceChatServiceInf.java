package kr.or.dev.talk.facechat.service;

import java.util.List;

import kr.or.dev.talk.facechat.model.FaceChatVO;

public interface FaceChatServiceInf {

	/**
	* Method : getFaceChatDetail
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param pro_no
	* @return
	* Method 설명 : 화상회의 번호를 매개변수로 받아 화상회의 상세정보 조회
	*/
	FaceChatVO getFaceChatDetail(int pro_no);
	
	/**
	* Method : insertFaceChat
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param faceChatVo
	* @return
	* Method 설명 : 화상회의 객체를 매개변수로 받아 화상회의 생성
	*/
	int insertFaceChat(FaceChatVO faceChatVo);
	
	/**
	* Method : deleteFaceChatR
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param fc_no
	* @return
	* Method 설명 : 화상회의 번호를 매개변수로 받아 화상회의 삭제
	*/
	int deleteFaceChatR(int fc_no);
	
	/**
	* Method : getFaceChatSeq
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 화상회의 등록에 사용되는 화상회의 번호 반환
	*/
	int getFaceChatSeq();
}
