package kr.or.dev.timeline.todo.dao;

import java.util.List;
import java.util.Map;

import kr.or.dev.timeline.todo.model.TodoVO;

public interface TodoDaoInf {
	
	/**
	* Method : getTodoSeq
	* 최초작성일 : 2018. 9. 30.
	* 작성자 : 김지수
	* 변경이력 :
	* @return
	* Method 설명 : todo_no의 시퀸스 조회
	*/
	int getTodoSeq();
	
	/**
	* Method : insertTodo
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : 할일 등록
	*/
	int insertTodo(TodoVO todoVo);
	
	/**
	* Method : updateTodo
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : 할일 수정
	*/
	int updateTodo(TodoVO todoVo);
	
	/**
	* Method : deleteTodo
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param todo_no
	* @return
	* Method 설명 : 할일 삭제처리
	*/
	int deleteTodo(int todo_no);
	
	/**
	* Method : getTodoDetail
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param todo_no
	* @return
	* Method 설명 : 할일 상세 조회
	*/
	TodoVO getTodoDetail(int todo_no);
	
	/**
	* Method : getTodoProList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트의 할일 조회
	*/
	List<TodoVO> getTodoProList(Map<String, Object> paramMap);
	
	/**
	* Method : getTodoSearchList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 할일 검색 조회
	*/
	List<TodoVO> getTodoSearchList(Map<String, String> searchMap);
	
	/**
	* Method : getTodoCollList
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원의 담아둔 할일글 리스트 조회
	*/
	List<TodoVO> getTodoCollList(String mem_id);
	
	/**
	* Method : getMyTodoList
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원이 작성한 할일글 리스트 조회
	*/
	List<TodoVO> getMyTodoList(String mem_id);
}
