package kr.or.dev.board.post_reply.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.board.post_reply.model.PostReplyVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("postReplyDao")
public class PostReplyDao implements PostReplyDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : getPostRepSeq
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 김지수
	* 변경이력 :
	* @return
	* Method 설명 : 게시판 댓글 시퀀스 조회
	*/
	@Override
	public int getPostRepSeq() {
		return template.selectOne("postRep.getPostRepSeq");
	}
	
	/**
	 * Method : getPostRepList
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 댓글 리스트 반환 
	 */
	@Override
	public List<PostReplyVO> getPostRepList(int post_no) {
		return template.selectList("postRep.getPostRepList", post_no);
	}

	/**
	 * Method : insertPostRep
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param postRepVo
	 * @return
	 * Method 설명 : 게시글댓글의 객체를 매개변수로 받아 게시글댓글 등록
	 */
	@Override
	public int insertPostRep(PostReplyVO postRepVo) {
		return template.insert("postRep.insertPostRep", postRepVo);
	}

	/**
	 * Method : updatePostRep
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param postRepVo
	 * @return
	 * Method 설명 : 게시글댓글의 객체를 매개변수로 받아 게시글댓글 수정
	 */
	@Override
	public int updatePostRep(PostReplyVO postRepVo) {
		return template.update("postRep.updatePostRep", postRepVo);
	}
	
	/**
	 * Method : deletePostRep
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param post_rep_no
	 * @return
	 * Method 설명 : 게시글댓글의 번호를 매개변수로 받아 해당 게시글댓글 삭제
	 */
	@Override
	public int deletePostRep(int post_rep_no) {
		return template.delete("postRep.deletePostRep", post_rep_no);
	}

}
