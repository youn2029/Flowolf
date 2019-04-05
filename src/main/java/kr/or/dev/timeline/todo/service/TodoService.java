
package kr.or.dev.timeline.todo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.timeline.TimeLine;
import kr.or.dev.timeline.emoticon_user.model.EmoticonUserVO;
import kr.or.dev.timeline.emoticon_user.service.EmoticonUserServiceInf;
import kr.or.dev.timeline.reply.service.ReplyServiceInf;
import kr.or.dev.timeline.todo.dao.TodoDaoInf;
import kr.or.dev.timeline.todo.model.TodoVO;
import kr.or.dev.timeline.todo_item.dao.TodoItemDaoInf;
import kr.or.dev.timeline.todo_item.model.TodoItemVO;

import org.springframework.stereotype.Service;

@Service("todoService")
public class TodoService implements TodoServiceInf {
	
	// 할일
	@Resource(name="todoDao")
	private TodoDaoInf todoDao;
	
	// 할일 항목
	@Resource(name="todoItemDao")
	private TodoItemDaoInf tiDao;
	
	// 댓글
	@Resource(name="repService")
	private ReplyServiceInf repService;
	
	// 이모티콘 사용자
	@Resource(name="emoUserService")
	private EmoticonUserServiceInf emoUserService;

	/**
	* Method : getTodoSeq
	* 최초작성일 : 2018. 9. 30.
	* 작성자 : 김지수
	* 변경이력 :
	* @return
	* Method 설명 : todo_no의 시퀀스 조회
	*/
	@Override
	public int getTodoSeq() {
		return todoDao.getTodoSeq();
	}

	/**
	* Method : insertTodo
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : 할일 등록
	*/
	@Override
	public int insertTodo(TodoVO todoVo) {
		return todoDao.insertTodo(todoVo);
	}

	/**
	* Method : updateTodo
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todoVo
	* @return
	* Method 설명 : 할일 수정
	*/
	@Override
	public int updateTodo(TodoVO todoVo) {
		return todoDao.updateTodo(todoVo);
	}

	/**
	* Method : deleteTodo
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todo_no
	* @return
	* Method 설명 : 할일 삭제 처리
	*/
	@Override
	public int deleteTodo(int todo_no) {
		return todoDao.deleteTodo(todo_no);
	}

	/**
	* Method : getTodoDetail
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param todo_no
	* @return
	* Method 설명 : 할일 상세 조회
	*/
	@Override
	public TodoVO getTodoDetail(int todo_no) {
		return todoDao.getTodoDetail(todo_no);
	}

	/**
	* Method : getTodoProList
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트의 할일 조회
	*/
	@Override
	public List<TimeLine> getTodoProList(Map<String, Object> paramMap) {
		
		// timeLine List
		List<TimeLine> tlTodoList = new ArrayList<TimeLine>();
		
		// 할일 List
		List<TodoVO> todoList = todoDao.getTodoProList(paramMap);
		
		for (TodoVO todoVo : todoList) {
			
			TimeLine tl = new TimeLine();			
			
			// 할일 목록 List
			List<TodoItemVO> tiList = tiDao.getTiList(todoVo.getTodo_no());
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "todo_no");
			paraMap.put("timeline_no", todoVo.getTodo_no());
			
			// 해당 글의 댓글 List
			List<Map<String, Object>> repList = repService.getRepList(paraMap);
			
			// 해당 글의 이모티콘 유저 List
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
						
			tl.setTodoVo(todoVo);						// 할일 Vo
			tl.setTiList(tiList);						// 할일 항목 List
			tl.setMem_id(todoVo.getMem_id());			// 작성자ID
			tl.setMem_nick(todoVo.getMem_nick());		// 작성자Nick
			tl.setTime(todoVo.getTodo_time());			// 작성일
			tl.setFix_chk(todoVo.getTodo_fix_chk());	// 상단고정 유무
			tl.setColl_chk(todoVo.getColl_chk());		// 담아두기 유무
			tl.setRepList(repList);						// 댓글 List
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlTodoList.add(tl);
		}
		
		return tlTodoList;
	}

	/**
	* Method : getTodoSearchList
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 할일 검색 조회
	*/
	@Override
	public List<TodoVO> getTodoSearchList(Map<String, String> searchMap) {
		return todoDao.getTodoSearchList(searchMap);
	}

	@Override
	public List<TimeLine> getTodoCollList(String mem_id) {
		
		// timeLine List
		List<TimeLine> tlTodoList = new ArrayList<TimeLine>();
		
		// 할일 List
		List<TodoVO> todoCollList = todoDao.getTodoCollList(mem_id);
		
		for (TodoVO todoVo : todoCollList) {
			
			TimeLine tl = new TimeLine();			
			
			// 할일 목록 List
			List<TodoItemVO> tiList = tiDao.getTiList(todoVo.getTodo_no());
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "todo_no");
			paraMap.put("timeline_no", todoVo.getTodo_no());
			
			// 해당 글의 이모티콘 유저 List
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
						
			tl.setTodoVo(todoVo);						// 할일 Vo
			tl.setTiList(tiList);						// 할일 항목 List
			tl.setMem_id(todoVo.getMem_id());			// 작성자ID
			tl.setMem_nick(todoVo.getMem_nick());		// 작성자Nick
			tl.setTime(todoVo.getTodo_time());			// 작성일
			tl.setColl_chk(todoVo.getColl_chk());		// 담아두기 유무
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlTodoList.add(tl);
		}
		
		return tlTodoList;
	}

	@Override
	public List<TimeLine> getMyTodoList(String mem_id) {
		
		// timeLine List
		List<TimeLine> tlTodoList = new ArrayList<TimeLine>();
		
		// 할일 List
		List<TodoVO> myTodoList = todoDao.getMyTodoList(mem_id);
		
		for (TodoVO todoVo : myTodoList) {
			
			TimeLine tl = new TimeLine();			
			
			// 할일 목록 List
			List<TodoItemVO> tiList = tiDao.getTiList(todoVo.getTodo_no());
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "todo_no");
			paraMap.put("timeline_no", todoVo.getTodo_no());
			
			// 해당 글의 이모티콘 유저 List
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
						
			tl.setTodoVo(todoVo);						// 할일 Vo
			tl.setTiList(tiList);						// 할일 항목 List
			tl.setMem_id(todoVo.getMem_id());			// 작성자ID
			tl.setMem_nick(todoVo.getMem_nick());		// 작성자Nick
			tl.setTime(todoVo.getTodo_time());			// 작성일
			tl.setColl_chk(todoVo.getColl_chk());		// 담아두기 유무
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlTodoList.add(tl);
		}
		
		return tlTodoList;
	}

}
