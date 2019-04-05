package kr.or.dev.timeline.vote_item_user.service;

import kr.or.dev.timeline.vote_item_user.model.VoteItemUserVO;

public interface VoteItemUserServiceInf {

	/**
	* Method : insertViu
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param viuVo
	* @return
	* Method 설명 : 투표한 회원 등록
	*/
	int insertViu(VoteItemUserVO viuVo);
	
	/**
	* Method : deleteViu
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param viuVo
	* @return
	* Method 설명 : 투표한 회원 삭제
	*/
	int deleteViu(VoteItemUserVO viuVo);	
}
