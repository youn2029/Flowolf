package kr.or.dev.timeline;

import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.dev.files.model.FilesVO;
import kr.or.dev.timeline.basic.model.BasicVO;
import kr.or.dev.timeline.emoticon_user.model.EmoticonUserVO;
import kr.or.dev.timeline.schedule.model.ScheduleVO;
import kr.or.dev.timeline.task.model.TaskVO;
import kr.or.dev.timeline.task_user.model.TaskUserVO;
import kr.or.dev.timeline.todo.model.TodoVO;
import kr.or.dev.timeline.todo_item.model.TodoItemVO;
import kr.or.dev.timeline.vote.model.VoteVO;
import kr.or.dev.timeline.vote_item.model.VoteItemVO;

public class TimeLine implements Comparable<TimeLine> {
	
	// 타임라인
	private BasicVO basicVo;					// 일반글
	
	private ScheduleVO schdVo;					// 일정
	
	private TaskVO taskVo;						// 업무
	private List<TaskUserVO> tuList;			// 업무지정자 List
	
	private TodoVO todoVo;						// 할일
	private List<TodoItemVO> tiList;			// 할일항목 List
	
	private VoteVO voteVo;						// 투표
	private List<VoteItemVO> viList;			// 투표항목 List	
	
	// 해당 타임라인의 정보 (공통)
	private List<FilesVO> filesList;			// 해당 글의 파일 리스트(일반, 업무)
	private List<Map<String, Object>> repList;	// 해당 글의 댓글 리스트
	private List<EmoticonUserVO> emoUserList;	// 해당 이모티콘 유저 리스트
	
	private String mem_id;						// 작성자ID
	private String mem_nick;					// 작성자Nick
	private Date time;							// 작성일
	private String fix_chk;						// 고정 유무
	private int coll_chk;						// 담아두기 유무

	// get, set
	public BasicVO getBasicVo() {
		return basicVo;
	}

	public void setBasicVo(BasicVO basicVo) {
		this.basicVo = basicVo;
	}

	public ScheduleVO getSchdVo() {
		return schdVo;
	}

	public void setSchdVo(ScheduleVO schdVo) {
		this.schdVo = schdVo;
	}

	public TaskVO getTaskVo() {
		return taskVo;
	}

	public void setTaskVo(TaskVO taskVo) {
		this.taskVo = taskVo;
	}

	public TodoVO getTodoVo() {
		return todoVo;
	}

	public void setTodoVo(TodoVO todoVo) {
		this.todoVo = todoVo;
	}

	public VoteVO getVoteVo() {
		return voteVo;
	}

	public void setVoteVo(VoteVO voteVo) {
		this.voteVo = voteVo;
	}

	public List<Map<String, Object>> getRepList() {
		return repList;
	}

	public void setRepList(List<Map<String, Object>> repList) {
		this.repList = repList;
	}

	public List<FilesVO> getFilesList() {
		return filesList;
	}

	public void setFilesList(List<FilesVO> filesList) {
		this.filesList = filesList;
	}

	public List<EmoticonUserVO> getEmoUserList() {
		return emoUserList;
	}

	public void setEmoUserList(List<EmoticonUserVO> emoUserList) {
		this.emoUserList = emoUserList;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<TaskUserVO> getTuList() {
		return tuList;
	}

	public void setTuList(List<TaskUserVO> tuList) {
		this.tuList = tuList;
	}

	public List<TodoItemVO> getTiList() {
		return tiList;
	}

	public void setTiList(List<TodoItemVO> tiList) {
		this.tiList = tiList;
	}

	public List<VoteItemVO> getViList() {
		return viList;
	}

	public void setViList(List<VoteItemVO> viList) {
		this.viList = viList;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_nick() {
		return mem_nick;
	}

	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}

	public String getFix_chk() {
		return fix_chk;
	}

	public void setFix_chk(String fix_chk) {
		this.fix_chk = fix_chk;
	}

	public int getColl_chk() {
		return coll_chk;
	}

	public void setColl_chk(int coll_chk) {
		this.coll_chk = coll_chk;
	}

	@Override
	public int compareTo(TimeLine timeLine) {
		return timeLine.getTime().compareTo(time);
	}	
}
