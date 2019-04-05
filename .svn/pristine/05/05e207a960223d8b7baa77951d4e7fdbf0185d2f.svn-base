package kr.or.dev.timeline.pick.dao;

import java.util.List;

import kr.or.dev.timeline.pick.model.PickVO;


public interface PickDaoInf {
	
	/**
	* Method : insertPick
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param pickVo
	* @return
	* Method 설명 : 지정한 글 등록
	*/
	int insertPick(PickVO pickVo);
	
	/**
	* Method : deletePickR
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param pick_no
	* @return
	* Method 설명 : 지정한 글 삭제
	*/
	int deletePickR(int pick_no);
	
	/**
	* Method : getPickMyList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원이 지정된 글 조회
	*/
	List<PickVO> getPickMyList(String mem_id);

}
