package kr.or.dev.timeline.basic.dao;

import java.util.List;
import java.util.Map;

import kr.or.dev.timeline.basic.model.BasicVO;

public interface BasicDaoInf {
	
	/**
	* Method : getBasicSeq
	* 최초작성일 : 2018. 10. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 일반글 시퀀스 조회
	*/
	int getBasicSeq();
	
	/**
	* Method : insertBasic
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param basicVo
	* @return
	* Method 설명 : 일반글 등록
	*/
	int insertBasic(BasicVO basicVo);
	
	/**
	* Method : updateBasic
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param basicVo
	* @return
	* Method 설명 : 일반글 수정
	*/
	int updateBasic(BasicVO basicVo);
	
	/**
	* Method : deleteBasic
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param basic_no
	* @return
	* Method 설명 : 일반글 삭제처리
	*/
	int deleteBasic(int basic_no);
	
	/**
	* Method : getBasicDetail
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param basic_no
	* @return
	* Method 설명 : 일반글 상세 조회
	*/
	BasicVO getBasicDetail(int basic_no);
	
	/**
	* Method : getBasicProList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트의 일반글 조회
	*/
	List<BasicVO> getBasicProList(Map<String, Object> paramMap);
	
	/**
	* Method : getBasicSearchList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 일반글 검색 조회
	*/
	List<BasicVO> getBasicSearchList(Map<String, String> searchMap);
	
	/**
	* Method : getBasicCollList
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원의 담아둔 일반글 리스트 조회
	*/
	List<BasicVO> getBasicCollList(String mem_id);
	
	/**
	* Method : getMyBasicList
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원이 작성한 일반글 리스트 조회
	*/
	List<BasicVO> getMyBasicList(String mem_id);

}
