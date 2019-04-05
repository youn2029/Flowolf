package kr.or.dev.timeline.task_user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.timeline.task_user.dao.TaskUserDaoInf;
import kr.or.dev.timeline.task_user.model.TaskUserVO;

@Service("taskUserService")
public class TaskUserService implements TaskUserServiceInf {
	
	@Resource(name="taskUserDao")
	private TaskUserDaoInf taskUserDao;

	/**
	* Method : insertTaskUser
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param taskUserVo
	* @return
	* Method 설명 : 업무지정자 등록
	*/
	@Override
	public int insertTaskUser(TaskUserVO taskUserVo) {
		return taskUserDao.insertTaskUser(taskUserVo);
	}

	/**
	* Method : deleteTaskUserR
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param task_user_no
	* @return
	* Method 설명 : 업무지정자 삭제
	*/
	@Override
	public int deleteTaskUserR(int task_user_no) {
		return taskUserDao.deleteTaskUserR(task_user_no);
	}

	/**
	* Method : getTaskUserList
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param task_no
	* @return
	* Method 설명 : 업무글의 지정자 목록 조회
	*/
	@Override
	public List<TaskUserVO> getTaskUserList(int task_no) {
		return taskUserDao.getTaskUserList(task_no);
	}

	/**
	* Method : getTaskUserMyList
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param tu_mem_id
	* @return
	* Method 설명 : 회원의 업무지정자 조회
	*/
	@Override
	public List<TaskUserVO> getTaskUserMyList(String tu_mem_id) {
		return taskUserDao.getTaskUserMyList(tu_mem_id);
	}

}
