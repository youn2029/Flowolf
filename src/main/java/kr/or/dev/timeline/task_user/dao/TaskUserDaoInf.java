package kr.or.dev.timeline.task_user.dao;

import java.util.List;

import kr.or.dev.timeline.task_user.model.TaskUserVO;

public interface TaskUserDaoInf {
	
	/**
	* Method : insertTaskUser
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param taskUserVo
	* @return
	* Method 설명 : 업무지정자 등록
	*/
	int insertTaskUser(TaskUserVO taskUserVo);
	
	/**
	* Method : deleteTaskUserR
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param task_user_no
	* @return
	* Method 설명 : 업무지정자 삭제
	*/
	int deleteTaskUserR(int task_user_no);
	
	/**
	* Method : getTaskUserList
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param task_no
	* @return
	* Method 설명 : 업무글의 지정자 목록 조회
	*/
	List<TaskUserVO> getTaskUserList(int task_no);
	
	/**
	* Method : getTaskUserMyList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param tu_mem_id
	* @return
	* Method 설명 : 회원의 업무지정자 조회
	*/
	List<TaskUserVO> getTaskUserMyList(String tu_mem_id);
	
}
