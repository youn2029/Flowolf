package kr.or.dev.timeline.vote.service;

import java.util.List;
import java.util.Map;

import kr.or.dev.timeline.TimeLine;
import kr.or.dev.timeline.vote.model.VoteVO;

public interface VoteServiceInf {
	
	/**
	* Method : getVoteSeq
	* 최초작성일 : 2018. 9. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 투표 시퀸스 조회
	*/
	int getVoteSeq();
	
	/**
	* Method : insertVote
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param voteVo
	* @return
	* Method 설명 : 투표글 등록
	*/
	int insertVote(VoteVO voteVo);
	
	/**
	* Method : updateVote
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param voteVo
	* @return
	* Method 설명 : 투표글 수정
	*/
	int updateVote(VoteVO voteVo);
	
	/**
	* Method : deleteVote
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param vote_no
	* @return
	* Method 설명 : 투표글 삭제처리
	*/
	int deleteVote(int vote_no);
	
	/**
	* Method : getVoteDetail
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param vote_no
	* @return
	* Method 설명 : 투표글 상세 조회
	*/
	VoteVO getVoteDetail(int vote_no);
	
	/**
	* Method : getVoteProList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트의 투표글 조회
	*/
	List<TimeLine> getVoteProList(Map<String, Object> paramMap);
	
	/**
	* Method : getVoteSearchList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 투표글 검색 조회
	*/
	List<VoteVO> getVoteSearchList(Map<String, String> searchMap);
	
	/**
	* Method : getVoteCollList
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원의 담아둔 투표글 리스트 조회
	*/
	List<TimeLine> getVoteCollList(String mem_id);
	
	/**
	* Method : getMyVoteList
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원이 작성한 투표글 리스트 조회
	*/
	List<TimeLine> getMyVoteList(String mem_id);
}
