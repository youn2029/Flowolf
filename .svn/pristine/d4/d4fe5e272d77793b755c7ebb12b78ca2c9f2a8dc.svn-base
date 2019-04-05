package kr.or.dev.user.partner.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.user.member.model.MemberVO;
import kr.or.dev.user.partner.dao.PartnerDaoInf;
import kr.or.dev.user.partner.model.PartnerVO;

@Service("ptnService")
public class PartnerService implements PartnerServiceInf {
	
	@Resource(name="ptnDao")
	private PartnerDaoInf ptnDao;

	/**
	* Method : insertPtn
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param ptnVo
	* @return
	* Method 설명 : 동료 신청
	*/
	@Override
	public int insertPtn(PartnerVO ptnVo) {
		return ptnDao.insertPtn(ptnVo);
	}

	/**
	* Method : updatePtn
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param ptnVo
	* @return
	* Method 설명 : 동료 수락
	*/
	@Override
	public int updatePtn(PartnerVO ptnVo) {
		return ptnDao.updatePtn(ptnVo);
	}

	/**
	* Method : getPtnMyList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 동료 목록 반환
	*/
	@Override
	public List<PartnerVO> getPtnMyList(String mem_id) {
		return ptnDao.getPtnMyList(mem_id);
	}

	/**
	* Method : getPtnSeq
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 동료 시퀀스 조회
	*/
	@Override
	public int getPtnSeq() {
		return ptnDao.getPtnSeq();
	}

}
