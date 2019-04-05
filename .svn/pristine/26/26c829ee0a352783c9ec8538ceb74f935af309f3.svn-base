package kr.or.dev.talk.facechat_user.service;

import javax.annotation.Resource;

import kr.or.dev.talk.facechat_user.dao.FaceChatUserDaoInf;
import kr.or.dev.talk.facechat_user.model.FaceChatUserVO;

import org.springframework.stereotype.Service;

@Service(value="fcuService")
public class FaceChatUserService implements FaceChatUserServiceInf{
	
	@Resource(name="fcuDao")
	private FaceChatUserDaoInf fcuDao;

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
		return fcuDao.getFaceChatUser(fc_no);
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
		return fcuDao.insertFaceChatUser(faceChatUserVo);
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
		return fcuDao.deleteFaceChatUserR(faceChatUserVo);
	}

}
