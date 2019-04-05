package kr.or.dev.board.post_reply.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.board.post_reply.dao.PostReplyDaoInf;
import kr.or.dev.board.post_reply.model.PostReplyVO;

import org.springframework.stereotype.Service;

@Service("postReplyService")
public class PostReplyService implements PostReplyServiceInf {
	
	@Resource(name="postReplyDao")
	private PostReplyDaoInf postReplyDao;

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
		return postReplyDao.getPostRepSeq();
	}

	/**
	* Method : getPostRepList
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 김지수
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시판 댓글 조회
	*/
	@Override
	public List<PostReplyVO> getPostRepList(int post_no) {
		return postReplyDao.getPostRepList(post_no);
	}

	/**
	* Method : insertPostRep
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 김지수
	* 변경이력 :
	* @param postRepVo
	* @return
	* Method 설명 : 게시판 댓글 등록
	*/
	@Override
	public int insertPostRep(PostReplyVO postRepVo) {
		return postReplyDao.insertPostRep(postRepVo);
	}

	/**
	* Method : updatePostRep
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 김지수
	* 변경이력 :
	* @param postRepVo
	* @return
	* Method 설명 : 게시판 댓글 수정
	*/
	@Override
	public int updatePostRep(PostReplyVO postRepVo) {
		return postReplyDao.updatePostRep(postRepVo);
	}

	/**
	* Method : deletePostRep
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 김지수
	* 변경이력 :
	* @param post_rep_no
	* @return
	* Method 설명 : 게시판 댓글 삭제 처리
	*/
	@Override
	public int deletePostRep(int post_rep_no) {
		return postReplyDao.deletePostRep(post_rep_no);
	}
	
}
