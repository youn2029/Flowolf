package kr.or.dev.timeline.collection.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.timeline.TimeLine;
import kr.or.dev.timeline.basic.service.BasicServiceInf;
import kr.or.dev.timeline.collection.service.CollectionServiceInf;
import kr.or.dev.timeline.emoticon.model.EmoticonVO;
import kr.or.dev.timeline.emoticon.service.EmoticonServiceInf;
import kr.or.dev.timeline.schedule.service.ScheduleServiceInf;
import kr.or.dev.timeline.task.service.TaskServiceInf;
import kr.or.dev.timeline.todo.service.TodoServiceInf;
import kr.or.dev.timeline.vote.service.VoteServiceInf;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("collController")
@RequestMapping("/coll")
public class CollectionController {
	
	// 담아둔 글
	@Resource(name="collService")
	private CollectionServiceInf collService;
	
	// 일반
	@Resource(name="basicService")
	private BasicServiceInf basicService;
	
	// 업무
	@Resource(name="taskService")
	private TaskServiceInf taskService;
	
	// 일정
	@Resource(name="scheduleService")
	private ScheduleServiceInf schdService;
	
	// 할일
	@Resource(name="todoService")
	private TodoServiceInf todoService;
	
	// 투표
	@Resource(name="voteService")
	private VoteServiceInf voteService;
	
	// 이모티콘
	@Resource(name="emoService")
	private EmoticonServiceInf emoService;
	
	/**
	* Method : insertColl
	* 최초작성일 : 2018. 9. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param timeline_col
	* @param timeline_no
	* @param session
	* @return
	* Method 설명 : 담아두기 등록
	*/
	@RequestMapping("/insert")
	@ResponseBody
	public int insertColl(@RequestParam("timeline_col")String timeline_col
						, @RequestParam("timeline_no")int timeline_no
						, HttpSession session){
		
		// 회원 정보
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		
		int coll_no = collService.getCollSeq();
		
		// paramMap
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("coll_no", coll_no);
		paramMap.put("timeline_col", timeline_col);
		paramMap.put("timeline_no", timeline_no);
		paramMap.put("mem_id", memVo.getMem_id());
		
		collService.insertColl(paramMap);
		
		return coll_no;
	}
	
	/**
	* Method : deleteColl
	* 최초작성일 : 2018. 9. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param coll_no
	* @return
	* Method 설명 : 담아두기 삭제
	*/
	@RequestMapping("/delete")
	@ResponseBody
	public int deleteColl(@RequestParam("coll_no")int coll_no){
		return collService.deleteCollR(coll_no);
	}
	
	/**
	* Method : collectionArticle
	* 최초작성일 : 2018. 10. 13.
	* 작성자 : 김지수
	* 변경이력 :
	* @param session
	* @return
	* Method 설명 : 담아둔 글 페이지 이동
	*/
	@RequestMapping("/collArticle")
	public String collArticle(HttpSession session, Model model){
		
		// 회원정보
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		
		// 담아둔글 정보
		List<TimeLine> timeLineList = getCollTimeLineList(memVo.getMem_id());
		model.addAttribute("timeLineList", timeLineList);
		
		// 이모티콘 정보
		List<EmoticonVO> emoList = emoService.getEmoAllList();
		model.addAttribute("emoList", emoList);
		
		// 담아둔 글
		model.addAttribute("artKind", "coll");
		
		return "collArticle";
	}
	
	@RequestMapping("/myArticle")
	public String myArticle(HttpSession session, Model model){
		
		// 회원정보
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		
		// 담아둔글 정보
		List<TimeLine> timeLineList = getMyTimeLineList(memVo.getMem_id());
		model.addAttribute("timeLineList", timeLineList);
		
		// 이모티콘 정보
		List<EmoticonVO> emoList = emoService.getEmoAllList();
		model.addAttribute("emoList", emoList);
		
		// 내 게시글
		model.addAttribute("artKind", "my");
		
		return "collArticle";
	}
	
	/**
	* Method : getTimeLineList
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 해당 프로젝트의 타임라인 조회
	*/
	public List<TimeLine> getCollTimeLineList(String mem_id){
		
		// 타임라인 List
		List<TimeLine> timeLineList = new ArrayList<TimeLine>();
		
		timeLineList.addAll(basicService.getBasicCollList(mem_id));
		timeLineList.addAll(taskService.getTaskCollList(mem_id));
		timeLineList.addAll(schdService.getSchdCollList(mem_id));
		timeLineList.addAll(todoService.getTodoCollList(mem_id));
		timeLineList.addAll(voteService.getVoteCollList(mem_id));
		
		Collections.sort(timeLineList);
		
		return timeLineList;		
	}
	
	public List<TimeLine> getMyTimeLineList(String mem_id){
		
		// 타임라인 List
		List<TimeLine> timeLineList = new ArrayList<TimeLine>();
		
		timeLineList.addAll(basicService.getMyBasicList(mem_id));
		timeLineList.addAll(taskService.getTaskMyList(mem_id));
		timeLineList.addAll(schdService.getMySchdList(mem_id));
		timeLineList.addAll(todoService.getMyTodoList(mem_id));
		timeLineList.addAll(voteService.getMyVoteList(mem_id));
		
		Collections.sort(timeLineList);
		
		return timeLineList;		
	}
	
}
