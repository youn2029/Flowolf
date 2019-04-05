package kr.or.dev.timeline.task.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.files.model.FilesVO;
import kr.or.dev.files.service.FilesServiceInf;
import kr.or.dev.timeline.TimeLine;
import kr.or.dev.timeline.emoticon_user.model.EmoticonUserVO;
import kr.or.dev.timeline.emoticon_user.service.EmoticonUserServiceInf;
import kr.or.dev.timeline.reply.service.ReplyServiceInf;
import kr.or.dev.timeline.task.dao.TaskDaoInf;
import kr.or.dev.timeline.task.model.TaskVO;
import kr.or.dev.timeline.task_user.dao.TaskUserDaoInf;
import kr.or.dev.timeline.task_user.model.TaskUserVO;

import org.springframework.stereotype.Service;

@Service("taskService")
public class TaskService implements TaskServiceInf {
	
	// 업무
	@Resource(name="taskDao")
	private TaskDaoInf taskDao;
	
	// 업무지정자
	@Resource(name="taskUserDao")
	private TaskUserDaoInf tuDao;
	
	// 파일
	@Resource(name="filesService")
	private FilesServiceInf filesService;
	
	// 댓글
	@Resource(name="repService")
	private ReplyServiceInf repService;
	
	// 이모티콘 사용자
	@Resource(name="emoUserService")
	private EmoticonUserServiceInf emoUserService;
	
	/**
	* Method : getTaskSeq
	* 최초작성일 : 2018. 9. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 업무 시퀸스 조회
	*/
	@Override
	public int getTaskSeq(){
		return taskDao.getTaskSeq(); 
	};
	
	/**
	* Method : insertTask
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param taskVo
	* @return
	* Method 설명 : 업무글 등록
	*/
	@Override
	public int insertTask(TaskVO taskVo) {
		return taskDao.insertTask(taskVo);
	}

	/**
	* Method : updateTask
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param taskVo
	* @return
	* Method 설명 : 업무글 수정
	*/
	@Override
	public int updateTask(TaskVO taskVo) {
		return taskDao.updateTask(taskVo);
	}

	/**
	* Method : deleteTask
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param task_no
	* @return
	* Method 설명 : 업무글 삭제처리
	*/
	@Override
	public int deleteTask(int task_no) {
		return taskDao.deleteTask(task_no);
	}

	/**
	* Method : getTaskProList
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트의 업무글 조회
	*/
	@Override
	public List<TimeLine> getTaskProList(Map<String, Object> paramMap) {
		
		// timeLine List
		List<TimeLine> tlTaskList = new ArrayList<TimeLine>();
		
		// 업무글 List
		List<TaskVO> taskList = taskDao.getTaskProList(paramMap);
		
		for (TaskVO taskVo : taskList) {
			
			TimeLine tl = new TimeLine();			
			
			// 업무 지정자 List
			List<TaskUserVO> tuList = tuDao.getTaskUserList(taskVo.getTask_no());
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "task_no");
			paraMap.put("timeline_no", taskVo.getTask_no());
			
			// 해당 글의 파일 List
			List<FilesVO> filesList = filesService.getFilesList(paraMap);
						
			// 해당 글의 댓글 List
			List<Map<String, Object>> repList = repService.getRepList(paraMap);
			
			// 해당 글의 이모티콘 유저 List				
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
						
			tl.setTaskVo(taskVo);						// 업무글 Vo
			tl.setTuList(tuList);						// 업무지정자 List
			tl.setMem_id(taskVo.getMem_id());			// 작성자ID
			tl.setMem_nick(taskVo.getMem_nick());		// 작성자Nick
			tl.setTime(taskVo.getTask_time());			// 작성일
			tl.setFix_chk(taskVo.getTask_fix_chk());	// 상단고정 유무
			tl.setColl_chk(taskVo.getColl_chk());		// 담아두기 유무
			tl.setFilesList(filesList);					// 첨부파일 List
			tl.setRepList(repList);						// 댓글 List
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlTaskList.add(tl);
		}
		
		return tlTaskList;
	}

	/**
	* Method : getTaskSearchList
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 업무글 검색 조회
	*/
	@Override
	public List<TaskVO> getTaskSearchList(Map<String, String> searchMap) {
		return taskDao.getTaskSearchList(searchMap);
	}

	/**
	* Method : getTaskDetail
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param task_no
	* @return
	* Method 설명 : 업무글 상세 조회
	*/
	@Override
	public TaskVO getTaskDetail(int task_no) {
		return taskDao.getTaskDetail(task_no);
	}

	/**
	* Method : getTaskMyList
	* 최초작성일 : 2018. 9. 20.
	* 작성자 : 김지수
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원이 요청한 업무글 조회
	*/
	@Override
	public List<TimeLine> getTaskMyList(String mem_id) {
		
		// timeLine List
		List<TimeLine> tlTaskList = new ArrayList<TimeLine>();
		
		// 업무글 List
		List<TaskVO> taskCollList = taskDao.getTaskMyList(mem_id);
		
		for (TaskVO taskVo : taskCollList) {
			
			TimeLine tl = new TimeLine();			
			
			// 업무 지정자 List
			List<TaskUserVO> tuList = tuDao.getTaskUserList(taskVo.getTask_no());
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "task_no");
			paraMap.put("timeline_no", taskVo.getTask_no());
			
			// 해당 글의 파일 List
			List<FilesVO> filesList = filesService.getFilesList(paraMap);
			
			// 해당 글의 이모티콘 유저 List				
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
						
			tl.setTaskVo(taskVo);						// 업무글 Vo
			tl.setTuList(tuList);						// 업무지정자 List
			tl.setMem_id(taskVo.getMem_id());			// 작성자ID
			tl.setMem_nick(taskVo.getMem_nick());		// 작성자Nick
			tl.setTime(taskVo.getTask_time());			// 작성일
			tl.setColl_chk(taskVo.getColl_chk());		// 담아두기 유무
			tl.setFilesList(filesList);					// 첨부파일 List
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlTaskList.add(tl);
		}
		
		return tlTaskList;
	}

	/**
	* Method : selectAllTask
	* 최초작성일 : 2018. 9. 30.
	* 작성자 : 김지수
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원이 참여하고 있는 프로젝트의 모든 업무 조회
	*/
	@Override
	public List<Map<String, Object>> selectAllTask(String mem_id) {
		
		// 반환값
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		
		// 업무글
		List<TaskVO> taskList = taskDao.selectAllTask(mem_id);
		
		for (TaskVO taskVo : taskList) {
			
			Map<String, Object> map = new HashMap<String, Object>();			
			
			map.put("taskVo", taskVo);
			map.put("taskUserList", tuDao.getTaskUserList(taskVo.getTask_no()));
			
			resultList.add(map);			
		}
		
		return resultList;
	}

	@Override
	public List<TimeLine> getTaskCollList(String mem_id) {
		
		// timeLine List
		List<TimeLine> tlTaskList = new ArrayList<TimeLine>();
		
		// 업무글 List
		List<TaskVO> myTaskList = taskDao.getTaskCollList(mem_id);
		
		for (TaskVO taskVo : myTaskList) {
			
			TimeLine tl = new TimeLine();			
			
			// 업무 지정자 List
			List<TaskUserVO> tuList = tuDao.getTaskUserList(taskVo.getTask_no());
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "task_no");
			paraMap.put("timeline_no", taskVo.getTask_no());
			
			// 해당 글의 파일 List
			List<FilesVO> filesList = filesService.getFilesList(paraMap);
			
			// 해당 글의 이모티콘 유저 List				
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
						
			tl.setTaskVo(taskVo);						// 업무글 Vo
			tl.setTuList(tuList);						// 업무지정자 List
			tl.setMem_id(taskVo.getMem_id());			// 작성자ID
			tl.setMem_nick(taskVo.getMem_nick());		// 작성자Nick
			tl.setTime(taskVo.getTask_time());			// 작성일
			tl.setColl_chk(taskVo.getColl_chk());		// 담아두기 유무
			tl.setFilesList(filesList);					// 첨부파일 List
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlTaskList.add(tl);
		}
		
		return tlTaskList;
	}

}
