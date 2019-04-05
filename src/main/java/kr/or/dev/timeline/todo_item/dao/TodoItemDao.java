package kr.or.dev.timeline.todo_item.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.todo_item.model.TodoItemVO;

@Repository("todoItemDao")
public class TodoItemDao implements TodoItemDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : insertTi
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param tiVo
	* @return
	* Method 설명 : 할일 항목 등록
	*/
	@Override
	public int insertTi(TodoItemVO tiVo) {
		return template.insert("todoItem.insertTi", tiVo);
	}

	/**
	* Method : updateTi
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param tiVo
	* @return
	* Method 설명 : 할일 항목 수정
	*/
	@Override
	public int updateTi(TodoItemVO tiVo) {
		return template.update("todoItem.updateTi", tiVo);
	}

	/**
	* Method : deleteTiR
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param ti_no
	* @return
	* Method 설명 : 할일 항목 삭제
	*/
	@Override
	public int deleteTiR(int ti_no) {
		return template.delete("todoItem.deleteTiR", ti_no);
	}

	/**
	* Method : getTiList
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todo_no
	* @return
	* Method 설명 : 할일의 항목 조회
	*/
	@Override
	public List<TodoItemVO> getTiList(int todo_no) {
		return template.selectList("todoItem.getTiList", todo_no);
	}

}
