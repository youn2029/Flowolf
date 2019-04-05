package kr.or.dev.user.partner.service;

import java.util.List;

import kr.or.dev.user.member.model.MemberVO;
import kr.or.dev.user.partner.model.PartnerVO;

public interface PartnerServiceInf {

	/**
	* Method : insertPtn
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param ptnVo
	* @return
	* Method 설명 : 동료 신청 등록
	*/
	int insertPtn(PartnerVO ptnVo);
	
	/**
	* Method : updatePtn
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param ptnVo
	* @return
	* Method 설명 : 동료 신청 수정(수락/거절)
	*/
	int updatePtn(PartnerVO ptnVo);
	
	/**
	* Method : getPtnMyList
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 동료 조회
	*/
	List<PartnerVO> getPtnMyList(String mem_id);
	
	/**
	* Method : getPtnSeq
	* 최초작성일 : 2018. 10. 4.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 동료 추가를 위한 시퀀스 반환
	*/
	int getPtnSeq();
}
