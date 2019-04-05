package kr.or.dev.group.project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dev.group.project.model.ProjectVO;

public interface ProjectDaoInf {
	
	/**
	* Method : getPostSeq
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : post_no의 시퀸스 조회
	*/
	int getProSeq();
	
	/**
	* Method : insertPro
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param proVo
	* @return
	* Method 설명 : 프로젝트 생성
	*/
	int insertPro(ProjectVO proVo);	
	
	/**
	* Method : updatePro
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param proVo
	* @return
	* Method 설명 : 프로젝트 수정
	*/
	int updatePro(ProjectVO proVo);	
	
	/**
	* Method : deletePro
	* 최초작성일 : 2018. 8. 28.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param pro_no
	* @return
	* Method 설명 : 프로젝트 삭제처리
	*/
	int deletePro(int pro_no);	
	
	/**
	* Method : getPro
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 : 2018. 9. 14.
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트 상세 조회
	*/
	ProjectVO getProDetail(Map<String, Object> paramMap);	
	
	/**
	* Method : getProPageAllList
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 전체 프로젝트 조회
	*/
	List<ProjectVO> getProPageAllList(Map<String, Object> paramMap);
	
	/**
	* Method : getProKindCnt
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param kind_no
	* @return
	* Method 설명 : 분류별 프로젝트 갯수 조회
	*/
	int getProKindCnt(int kind_no);
	
	/**
	* Method : getProSearchList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 프로젝트 검색 조회
	*/
	List<ProjectVO> getProSearchList(Map<String, String> searchMap);
	
	/**
	* Method : getProAllList
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 전체 프로젝트 조회
	*/
	List<ProjectVO> getProAllList();
	
	/**
	* Method : getProMonthCnt
	* 최초작성일 : 2018. 10. 16.
	* 작성자 : 김지수
	* 변경이력 :
	* @param pro_date
	* @return
	* Method 설명 : 월별 프로젝트 갯수 조회
	*/
	int getProMonthCnt(String pro_date);
	
}
