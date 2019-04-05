package kr.or.dev.talk.facechat.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.talk.facechat.dao.FaceChatDaoInf;
import kr.or.dev.talk.facechat.model.FaceChatVO;

@Service(value="fcService")
public class FaceChatService implements FaceChatServiceInf{
	
	@Resource(name="fcDao")
	private FaceChatDaoInf fcDao;

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
		return fcDao.getFaceChatDetail(pro_no);
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
		return fcDao.insertFaceChat(faceChatVo);
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
		return fcDao.deleteFaceChatR(fc_no);
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
		return fcDao.getFaceChatSeq();
	}

}
