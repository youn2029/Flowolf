package kr.or.dev.group.important.dao;

import java.util.List;

import kr.or.dev.group.important.model.ImportantVO;
import kr.or.dev.group.project.model.ProjectVO;

public interface ImportantDaoInf {
	
	/**
	* Method : getImpProList
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 중요 프로젝트 정보 조회
	*/
	List<ProjectVO> getImpProList(String mem_id);
	
	/**
	* Method : insertImp
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param impVo
	* @return
	* Method 설명 : 중요 프로젝트 등록
	*/
	int insertImp(ImportantVO impVo);
	
	/**
	* Method : deleteImpR
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param impVo
	* @return
	* Method 설명 : 중요 프로젝트 삭제
	*/
	int deleteImpR(ImportantVO impVo);

}
