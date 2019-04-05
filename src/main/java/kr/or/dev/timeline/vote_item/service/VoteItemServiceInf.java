package kr.or.dev.timeline.vote_item.service;

import java.util.List;
import java.util.Map;

import kr.or.dev.timeline.vote_item.model.VoteItemVO;

public interface VoteItemServiceInf {
	
	/**
	* Method : insertVi
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param viVo
	* @return
	* Method 설명 : 투표 항목 등록
	*/
	int insertVi(VoteItemVO viVo);
	
	/**
	* Method : updateVi
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param viVo
	* @return
	* Method 설명 : 투표 항목 수정
	*/
	int updateVi(VoteItemVO viVo);
	
	/**
	* Method : deleteVi
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param vi_no
	* @return
	* Method 설명 : 투표 항목 삭제 처리
	*/
	int deleteVi(int vi_no);
	
	/**
	* Method : getViList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 투표의 항목과 투표자 조회
	*/
	List<VoteItemVO> getViList(Map<String, Object> paramMap);

}
