package kr.or.dev.group.box_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dev.group.box_project.model.BoxProjectVO;
import kr.or.dev.group.project.model.ProjectVO;

public interface BoxProjectDaoInf {	

	/**
	* Method : insertBoxPro
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param boxProVo
	* @return
	* Method 설명 : 보관함에 프로젝트 등록
	*/
	int insertBoxPro(BoxProjectVO boxProVo);
	
	/**
	* Method : deleteBoxPro
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param boxProVo
	* @return
	* Method 설명 : 보관함에 프로젝트 삭제
	*/
	int deleteBoxProR(BoxProjectVO boxProVo);
	
	/**
	* Method : getBoxProList
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 보관함에 보관된 프로젝트 정보 조회
	*/
	List<ProjectVO> getBoxProList(Map<String, Object> paramMap);
	
}
