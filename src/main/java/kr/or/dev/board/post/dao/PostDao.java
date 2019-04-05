package kr.or.dev.board.post.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.board.post.model.PostVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("postDao")
public class PostDao implements PostDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : getPostPageList
	* 최초작성일 : 2018. 10. 1.
	* 작성자 : 김지수
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 게시글 페이징 조회
	*/
	@Override
	public List<PostVO> getPostPageList(Map<String, Object> paramMap) {
		return template.selectList("post.getPostPageList", paramMap);
	}
	
	/**
	 * Method : getPostSearchList
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 검색 분류와 검색 내용을 map객체로 받아 검색된 리스트 반환
	 */
	@Override
	public List<PostVO> getPostSearchList(Map<String, Object> map) {
		return template.selectList("post.getPostSearchList", map);
	}

	/**
	 * Method : getPostDetail
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : 게시글의 번호를 매개변수로 받아 해당 게시글의 상세정보 반환
	 */
	@Override
	public PostVO getPostDetail(int post_no) {
		return template.selectOne("post.getPostDetail", post_no);
	}

	/**
	 * Method : insertPost
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 객체를 매개변수로 받아 게시글 등록
	 */
	@Override
	public int insertPost(PostVO postVo) {
		int cnt = template.insert("post.insertPost", postVo);
		return cnt;
	}

	/**
	 * Method : updatePost
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 객체를 매개변수로 받아 게시글 수정
	 */
	@Override
	public int updatePost(PostVO postVo) {
		int cnt = template.update("post.updatePost", postVo);
		return cnt;
	}

	/**
	 * Method : deletePost
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param post_no
	 * @return
	 * Method 설명 : 게시글 번호를 매개변수로 받아 게시글 삭제(활성화 유무)
	 */
	@Override
	public int deletePost(int post_no) {
		int cnt = template.update("post.deletePost", post_no);
		return cnt;
	}

	/**
	 * Method : getPostSeq
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시글 저장에 사용되는 게시글 번호 반환
	 */
	@Override
	public int getPostSeq() {
		return template.selectOne("post.getPostSeq");
	}

	/**
	 * Method : getPostTotCnt
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param post_kind
	 * @return
	 * Method 설명 : 게시판 번호를 매개변수로 받아 해당 게시판의 게시물 갯수 반환
	 */
	@Override
	public int getPostTotCnt(String post_kind) {
		int cnt = template.selectOne("post.getPostTotCnt", post_kind);
		return cnt;
	}

}
