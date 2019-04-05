package kr.or.dev.talk.facechat.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.talk.facechat.model.FaceChatVO;


@Repository(value="fcDao")
public class FaceChatDao implements FaceChatDaoInf{

	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	* Method : getFaceChatDetail
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param pro_no
	* @return
	* Method 설명 : 화상회의 상세 조회
	*/
	@Override
	public FaceChatVO getFaceChatDetail(int pro_no) {
		return template.selectOne("fc.getFaceChatDetail", pro_no);
	}

	/**
	* Method : insertFaceChat
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param faceChatVo
	* @return
	* Method 설명 : 화상회의 등록
	*/
	@Override
	public int insertFaceChat(FaceChatVO faceChatVo) {
		return template.insert("fc.insertFaceChat", faceChatVo);
	}

	/**
	* Method : deleteFaceChatR
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param fc_no
	* @return
	* Method 설명 : 화상회의 삭제
	*/
	@Override
	public int deleteFaceChatR(int fc_no) {
		return template.delete("fc.deleteFaceChatR", fc_no);
	}

	/**
	* Method : getFaceChatSeq
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 화상회의 시퀀스 조회
	*/
	@Override
	public int getFaceChatSeq() {
		return template.selectOne("fc.getFaceChatSeq");
	}

}
