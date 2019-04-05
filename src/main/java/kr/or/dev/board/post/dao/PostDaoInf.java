package kr.or.dev.board.post.dao;

import java.util.List;
import java.util.Map;

import kr.or.dev.board.post.model.PostVO;

public interface PostDaoInf {
	
	/**
	* Method : getPostPageList
	* 최초작성일 : 2018. 10. 1.
	* 작성자 : 김지수
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 게시글 페이징 조회
	*/
	List<PostVO> getPostPageList(Map<String, Object> paramMap);

	/**
	* Method : getPostSearchList
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 검색 분류와 검색 내용을 map객체로 받아 검색된 리스트 반환
	*/
	List<PostVO> getPostSearchList(Map<String, Object> map);
	
	/**
	* Method : getPostDetail
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 상세정보 반환
	*/
	PostVO getPostDetail(int post_no);
	
	/**
	* Method : insertPost
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 객체를 매개변수로 받아 게시글 등록
	*/
	int insertPost(PostVO postVo);
	
	/**
	* Method : updatePost
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 객체를 매개변수로 받아 게시글 수정
	*/
	int updatePost(PostVO postVo);
	
	/**
	* Method : deletePost
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 번호를 매개변수로 받아 게시글 삭제
	*/
	int deletePost(int post_no);
	
	/**
	* Method : getPostSeq
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 저장에 사용되는 게시글 번호 반환
	*/
	int getPostSeq();

	/**
	 * Method : getPostTotCnt
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param post_kind
	 * @return
	 * Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 게시물 갯수 반환
	 */
	int getPostTotCnt(String post_kind);
	
}
