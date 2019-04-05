package kr.or.dev.files.service;

import java.util.List;
import java.util.Map;

import kr.or.dev.files.model.FilesVO;

public interface FilesServiceInf {
	
	/**
	* Method : insertFiles
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 첨부파일 추가
	*/
	int insertFiles(Map<String, Object> paramMap);
	
	/**
	* Method : deleteFilesR
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param files_no
	* @return
	* Method 설명 : 첨부파일 삭제
	*/
	int deleteFilesR(int files_no);
	
	/**
	* Method : getFilesDetail
	* 최초작성일 : 2018. 8. 29.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param files_no
	* @return
	* Method 설명 : 첨부파일 상세 조회
	*/
	FilesVO getFilesDetail(int files_no);
	
	/**
	* Method : getFilesList
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 해당 글의 첨부파일 조회
	*/
	List<FilesVO> getFilesList(Map<String, Object> paramMap);
		
	/**
	* Method : getFilesSearchList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 파일 검색 조회
	*/
	List<FilesVO> getFilesSearchList(Map<String, String> searchMap);
	
	/**
	* Method : getFilesBaTaAllList
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 회원이 참여중인 프로젝트의 (일반,업무)글의 파일 조회
	*/
	List<FilesVO> getFilesBaTaAllList(Map<String, String> paramMap); 
	
	/**
	* Method : getFilesReplyAllList
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 회원이 참여중인 프로젝트의 해당 타임라인의 댓글 파일 조회 
	*/
	List<FilesVO> getFilesRepAllList(Map<String, String> paramMap);
	
	/**
	* Method : getProFilesBaTaAllList
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트의 (일반, 업무)글의 파일 조회
	*/
	List<FilesVO> getProFilesBaTaAllList(Map<String, Object> paramMap);
	
	/**
	* Method : getProFilesRepAllList
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트의 해당 타임라인의 댓글 파일 조회 
	*/
	List<FilesVO> getProFilesRepAllList(Map<String, Object> paramMap);
}
