package kr.or.dev.timeline.todo.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.group.project.model.ProjectVO;
import kr.or.dev.timeline.todo.model.TodoVO;
import kr.or.dev.timeline.todo.service.TodoServiceInf;
import kr.or.dev.timeline.todo_item.model.MultiTodo;
import kr.or.dev.timeline.todo_item.model.TodoItemVO;
import kr.or.dev.timeline.todo_item.service.TodoItemServiceInf;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("todoController")
@RequestMapping("/todo")
public class TodoController {

	// todo service
	@Resource(name="todoService")
	private TodoServiceInf todoService;
	
	// todo item service
	@Resource(name="todoItemService")
	private TodoItemServiceInf todoItemService;
	
	/**
	* Method : todoInsert
	* 최초작성일 : 2018. 10. 1.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todoVo
	* @param multiTodo
	* @param session
	* @return
	* Method 설명 : '할 일' 등록
	*/
	@RequestMapping("/insert")
	public String todoInsert(TodoVO todoVo, MultiTodo multiTodo, HttpSession session){
		
		// todo_no 가져오기
		int todo_no = todoService.getTodoSeq();
		todoVo.setTodo_no(todo_no);
		
		// 프로젝트 번호 가져오기
		ProjectVO proVo = (ProjectVO) session.getAttribute("proVo");
		todoVo.setPro_no(proVo.getPro_no());
		
		// 회원정보 가져오기
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		todoVo.setMem_id(memVo.getMem_id());
		
		// todo insert
		int insertCnt = todoService.insertTodo(todoVo);
		
		if(insertCnt == 1){
			
			List<TodoItemVO> tiList = multiTodo.getTiList();
			
			for (TodoItemVO tiVo : tiList) {
				tiVo.setTodo_no(todo_no);
				todoItemService.insertTi(tiVo);
			}
			
			session.setAttribute("msg", "글이 등록되었습니다.");
			session.setAttribute("className", "alert-warning");
			
		}
		
		return "redirect:/pro/detail?pro_no=" + proVo.getPro_no();
	}
	
	/**
	* Method : todoFix
	* 최초작성일 : 2018. 10. 9.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todo_no
	* @param todo_fix_chk
	* @param session
	* @return
	* Method 설명 : '할 일' 상단 고정
	*/
	@RequestMapping("/fix")
	public String todoFix(@RequestParam("timeline_no") int todo_no
						, @RequestParam("fix_chk") String todo_fix_chk
						, HttpSession session){
		
		// 할일 정보
		TodoVO todoVo = todoService.getTodoDetail(todo_no);
		todoVo.setTodo_fix_chk(todo_fix_chk);
		
		int resultCnt = todoService.updateTodo(todoVo);
		
		if (resultCnt == 1) {
			
			if (todo_fix_chk.equals("y")) {
				session.setAttribute("msg", "상단에 고정되었습니다.");
				session.setAttribute("className", "alert-warning");				
			}else{
				session.setAttribute("msg", "상단고정 해제되었습니다.");
				session.setAttribute("className", "alert-warning");
			}
		}
		
		return "redirect:/pro/detail?pro_no="+todoVo.getPro_no();
	}
	
	/**
	* Method : todoUpdate
	* 최초작성일 : 2018. 10. 9.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todo_no
	* @param todo_title
	* @param tinoList
	* @param multiTodo
	* @param session
	* @return
	* Method 설명 : '할 일' 수정
	*/
	@RequestMapping("/update")
	public String todoUpdate(@RequestParam("todo_no") int todo_no,
							 @RequestParam("todo_title") String todo_title,
							 @RequestParam(value="del_ti_no", required=false) List<Integer> tinoList,
							 MultiTodo multiTodo,
							 HttpSession session){
		
		// 할일 항목 삭제
		if (tinoList != null) {
			for (Integer ti_no : tinoList) {
				todoItemService.deleteTiR(ti_no);
			}
		}
		
		// 할일 상세 조회
		TodoVO todoVo = todoService.getTodoDetail(todo_no);
		todoVo.setTodo_title(todo_title);
		
		// 할일 update
		int updateCnt = todoService.updateTodo(todoVo);
		
		if(updateCnt == 1){
			
			// 할일 항목 등록 List
			List<TodoItemVO> tiList = multiTodo.getTiList();
			
			if(tiList != null){
				for (TodoItemVO tiVo : tiList) {
					
					if(tiVo.getTi_cont()!= null) {
						
						tiVo.setTodo_no(todo_no);
						todoItemService.insertTi(tiVo);
					}
					
				}
			}
			
			// 할일 항목 수정 List
			List<TodoItemVO> updateList = multiTodo.getTiUpdateList();
			
			for (TodoItemVO tiVo : updateList) {
				todoItemService.updateTi(tiVo);
			}
			
			session.setAttribute("msg", "글이 수정되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		return "redirect:/pro/detail?pro_no=" + todoVo.getPro_no();
	}
	
	/**
	* Method : todoDelete
	* 최초작성일 : 2018. 10. 8.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todo_no
	* @return
	* Method 설명 : '할 일' 삭제 처리
	*/
	@RequestMapping("/delete")
	public String todoDelete(@RequestParam("timeline_no") int todo_no, HttpSession session){
		
		// 할일 상세조회
		TodoVO todoVo = todoService.getTodoDetail(todo_no);
		
		// 할일 삭제처리
		int deleteCnt = todoService.deleteTodo(todo_no);
		
		if (deleteCnt == 1) {
			
			session.setAttribute("msg", "글이 삭제되었습니다.");
			session.setAttribute("className", "alert-warning");
			
		}
		
		return "redirect:/pro/detail?pro_no=" + todoVo.getPro_no();
	}
}
