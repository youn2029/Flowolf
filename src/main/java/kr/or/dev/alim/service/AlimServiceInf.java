package kr.or.dev.alim.service;

import java.util.List;
import java.util.Map;

import kr.or.dev.alim.model.AlimVO;

public interface AlimServiceInf {

	/**
	* Method : getAlimList
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 : 
	* @return
	* Method 설명 : 회원 아이디를 매개변수로 받아 해당 회원의 알림 리스트 반환
	*/
	List<AlimVO> getAlimList(String mem_id);
	
	/**
	* Method : getAlimDetail
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 알림번호를 매개변수로 받아 해당 알림의 상세정보 반환
	*/
	AlimVO getAlimDetail(int alim_no);
	
	/**
	* Method : insertAlim
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : map 객체를 매개변수로 받아 알림 등록
	*/
	int insertAlim(Map<String, Object> map);
	
	/**
	* Method : updateAlim
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param alimVo
	* @return
	* Method 설명 : 알림 번호를 매개변수로 받아 알림 수정
	*/
	int updateAlim(int alim_no);
	
	/**
	* Method : deleteAlim
	* 최초작성일 : 2018. 10. 11.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param alim_no
	* @return
	* Method 설명 : 알림 번호를 매개변수로 받아 알림 삭제
	*/
	int deleteAlim(int alim_no);
	
}
