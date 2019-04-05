package kr.or.dev.timeline.task_user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.task_user.model.TaskUserVO;

@Repository("taskUserDao")
public class TaskUserDao implements TaskUserDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : insertTaskUser
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param taskUserVo
	* @return
	* Method 설명 : 업무 지정자 등록
	*/
	@Override
	public int insertTaskUser(TaskUserVO taskUserVo) {
		return template.insert("taskUser.insertTaskUser", taskUserVo);
	}

	/**
	* Method : deleteTaskUserR
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param task_user_no
	* @return
	* Method 설명 : 업무 지정자 삭제
	*/
	@Override
	public int deleteTaskUserR(int task_user_no) {
		return template.delete("taskUser.deleteTaskUserR", task_user_no);
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
		return template.selectList("taskUser.getTaskUserList", task_no);
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
		return template.selectList("taskUser.getTaskUserMyList", tu_mem_id);
	}

}
