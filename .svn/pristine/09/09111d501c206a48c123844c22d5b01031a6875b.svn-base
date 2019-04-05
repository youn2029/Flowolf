package kr.or.dev.board.post_reply.dao;

import java.util.List;

import kr.or.dev.board.post_reply.model.PostReplyVO;

public interface PostReplyDaoInf {
	
	/**
	* Method : getPostRepSeq
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 김지수
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 댓글 시퀀스 조회
	*/
	int getPostRepSeq();

	/**
	* Method : getPostRepList
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 댓글 리스트 반환 
	*/
	List<PostReplyVO> getPostRepList(int post_no); 
	
	/**
	* Method : insertPostRep
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param postRepVo
	* @return
	* Method 설명 : 게시글댓글의 객체를 매개변수로 받아 게시글댓글 등록
	*/
	int insertPostRep(PostReplyVO postRepVo);
	
	/**
	* Method : updatePostRep
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param postRepVo
	* @return
	* Method 설명 : 게시글댓글의 객체를 매개변수로 받아 게시글댓글 수정
	*/
	int updatePostRep(PostReplyVO postRepVo);
	
	/**
	* Method : deletePostRep
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param post_rep_no
	* @return
	* Method 설명 : 게시글댓글의 번호를 매개변수로 받아 해당 게시글댓글 삭제
	*/
	int deletePostRep(int post_rep_no);
}
