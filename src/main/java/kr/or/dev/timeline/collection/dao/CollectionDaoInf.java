package kr.or.dev.timeline.collection.dao;

import java.util.List;
import java.util.Map;

import kr.or.dev.timeline.collection.model.CollectionVO;

public interface CollectionDaoInf {
	
	/**
	* Method : getCollSeq
	* 최초작성일 : 2018. 9. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 담아두기 시퀸스 조회
	*/
	int getCollSeq();
	
	/**
	* Method : insertColl
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 담아두기 등록
	*/
	int insertColl(Map<String, Object> paramMap);
	
	/**
	* Method : deleteCollR
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param coll_no
	* @return
	* Method 설명 : 담아두기 삭제
	*/
	int deleteCollR(int coll_no);
	
	/**
	* Method : getCollMyList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원의 담아두기 글 조회
	*/
	List<CollectionVO> getCollMyList(String mem_id);	
	

}
