package kr.or.dev.group.kind.service;

import java.util.List;

import kr.or.dev.group.kind.model.KindVO;

public interface KindServiceInf {
	
	/**
	* Method : insertKind
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param kindVo
	* @return
	* Method 설명 : 분류 등록
	*/
	int insertKind(KindVO kindVo);
	
	/**
	* Method : updateKind
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param kindVo
	* @return
	* Method 설명 : 분류 수정
	*/
	int updateKind(KindVO kindVo);
	
	/**
	* Method : deleteKind
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param kindVo
	* @return
	* Method 설명 : 분류 삭제처리
	*/
	int deleteKind(KindVO kindVo);
	
	/**
	* Method : getKindAllList
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 분류 전체 조회
	*/
	List<KindVO> getKindAllList();	

}
