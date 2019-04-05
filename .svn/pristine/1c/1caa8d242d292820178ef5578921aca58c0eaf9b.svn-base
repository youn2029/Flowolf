package kr.or.dev.group.box.service;

import java.util.List;
import java.util.Map;

import kr.or.dev.group.box.model.BoxVO;

public interface BoxServiceInf {

	/**
	* Method : getBoxList
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원별 보관함 조회
	*/	
	List<BoxVO> getBoxMyList(String mem_id);
	
	/**
	* Method : insertBox
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param boxVo
	* @return
	* Method 설명 : 보관함 등록
	*/
	int insertBox(BoxVO boxVo);
	
	/**
	* Method : updateBox
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param boxVo
	* @return
	* Method 설명 : 보관함 수정
	*/
	int updateBox(BoxVO boxVo);
	
	/**
	* Method : deleteBox
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param box_no
	* @return
	* Method 설명 : 보관함 삭제처리
	*/
	int deleteBox(int box_no);
	
	/**
	* Method : getBoxDetail
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param box_no
	* @return
	* Method 설명 : 보관함 상세 조회
	*/
	BoxVO getBoxDetail(int box_no);
	
	/**
	* Method : getBoxMaxIndex
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 보관함순번 최대수 조회
	*/
	int getBoxMaxIndex(String mem_id);
	
	/**
	* Method : getProBoxList
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트가 보관되었는지 확인체크 할 수 있는 보관함 리스트
	*/
	List<BoxVO> getProBoxList(Map<String, Object> paramMap);
}
