package kr.or.dev.timeline.task_user.model;

public class TaskUserVO {
	
	private int task_user_no;		// 업무담당자번호
	private int task_no;			// 업무글번호	
	private String tu_mem_id;		// 업무지정자id
	private String mem_nick;		// 작성자Nick(vo에서만 사용)

	public int getTask_user_no() {
		return task_user_no;
	}

	public void setTask_user_no(int task_user_no) {
		this.task_user_no = task_user_no;
	}

	public int getTask_no() {
		return task_no;
	}

	public void setTask_no(int task_no) {
		this.task_no = task_no;
	}
	
	public String getTu_mem_id() {
		return tu_mem_id;
	}

	public void setTu_mem_id(String tu_mem_id) {
		this.tu_mem_id = tu_mem_id;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	

}
