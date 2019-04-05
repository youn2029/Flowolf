package kr.or.dev.talk.facechat_user.dao;

import javax.annotation.Resource;

import kr.or.dev.talk.facechat_user.model.FaceChatUserVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository(value="fcuDao")
public class FaceChatUserDao implements FaceChatUserDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : getFaceChatUser
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param fc_no
	* @return
	* Method 설명 : 화상회의 유저 반환
	*/
	@Override
	public FaceChatUserVO getFaceChatUser(int fc_no) {
		return template.selectOne("fcUser.getFaceChatUser", fc_no);
	}

	/**
	* Method : insertFaceChatUser
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param faceChatUserVo
	* @return
	* Method 설명 : 화상회의 유저 등록
	*/
	@Override
	public int insertFaceChatUser(FaceChatUserVO faceChatUserVo) {
		return template.insert("fcUser.insertFaceChatUser", faceChatUserVo);
	}

	/**
	* Method : deleteFaceChatUserR
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param faceChatUserVo
	* @return
	* Method 설명 : 화상회의 유저 삭제
	*/
	@Override
	public int deleteFaceChatUserR(FaceChatUserVO faceChatUserVo) {
		return template.delete("fcUser.deleteFaceChatUserR", faceChatUserVo);
	}

}
