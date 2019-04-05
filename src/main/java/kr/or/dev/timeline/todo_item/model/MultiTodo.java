package kr.or.dev.timeline.todo_item.model;

import java.util.List;

import kr.or.dev.timeline.todo.model.TodoVO;

public class MultiTodo {
	
	public List<TodoItemVO> tiList;
	
	public List<TodoItemVO> tiUpdateList;
	
	public List<TodoItemVO> getTiList() {
		return tiList;
	}

	public void setTiList(List<TodoItemVO> tiList) {
		this.tiList = tiList;
	}

	public List<TodoItemVO> getTiUpdateList() {
		return tiUpdateList;
	}

	public void setTiUpdateList(List<TodoItemVO> tiUpdateList) {
		this.tiUpdateList = tiUpdateList;
	}
	
}
