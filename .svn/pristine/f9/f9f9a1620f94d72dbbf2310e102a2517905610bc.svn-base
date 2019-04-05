package kr.or.dev.timeline.todo_item.web;

import javax.annotation.Resource;

import kr.or.dev.timeline.todo.model.TodoVO;
import kr.or.dev.timeline.todo.service.TodoServiceInf;
import kr.or.dev.timeline.todo_item.model.TodoItemVO;
import kr.or.dev.timeline.todo_item.service.TodoItemServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/todoItem")
@Controller("todoItemController")
public class TodoItemController {

	@Resource(name="todoItemService")
	private TodoItemServiceInf todoItemService;
	
	@Resource(name="todoService")
	private TodoServiceInf todoService;

	/**
	* Method : todoItemUpdate
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김지수
	* 변경이력 :
	* @param ti_no
	* @param ti_chk
	* @param ti_cont
	* @param todo_rate
	* @return
	* Method 설명 : 할일 항목 수정
	*/
	@RequestMapping("/update")
	@ResponseBody
	public int todoItemUpdate(@RequestParam("ti_no") int ti_no, 
							  @RequestParam("ti_chk") String ti_chk,
							  @RequestParam("ti_cont") String ti_cont,
							  @RequestParam("todo_no") int todo_no,
							  @RequestParam("todo_rate") int todo_rate){
		
		TodoItemVO tiVo = new TodoItemVO();
		tiVo.setTi_no(ti_no);
		tiVo.setTi_chk(ti_chk);
		tiVo.setTi_cont(ti_cont);
		
		// 할일 상세 조회
		TodoVO todoVo = todoService.getTodoDetail(todo_no);
		todoVo.setTodo_rate(todo_rate);
		
		// 할일 update
		todoService.updateTodo(todoVo);
		
		int updateCnt = todoItemService.updateTi(tiVo);
		return updateCnt;
	}
	
}
