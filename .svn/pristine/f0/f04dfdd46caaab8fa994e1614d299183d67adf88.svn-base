package kr.or.dev.group.box_project.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.group.box_project.model.BoxProjectVO;
import kr.or.dev.group.box_project.service.BoxProjectServiceInf;
import kr.or.dev.group.project.model.ProjectVO;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/boxPro")
@Controller("boxProController")
public class BoxProjectController {

	@Resource(name="boxProService")
	private BoxProjectServiceInf boxProService;
	
	/**
	* Method : boxProList
	* 최초작성일 : 2018. 9. 18.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param session
	* @param model
	* @param box_no
	* @param box_name
	* @return
	* Method 설명 : 보관함 프로젝트 참여자 list
	*/
	@RequestMapping("/list")
	public String boxProList(HttpSession session
						   , Model model
						   , @RequestParam("box_no")int box_no
						   , @RequestParam("box_name")String box_name){		
		
		model.addAttribute("what", box_name+" 보관함");
		
		// 회원정보
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", memVo.getMem_id());
		paramMap.put("box_no", box_no);
		
		List<Map<String, Object>> myProList = boxProService.getBoxProList(paramMap);
		model.addAttribute("myProList", myProList);
		
		return "projectList";
	}
	
	/**
	* Method : boxProInsert
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param session
	* @param box_no
	* @return
	* Method 설명 : 보관함 프로젝트 등록
	*/
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	@ResponseBody
	public int boxProInsert(HttpSession session, @RequestParam("box_no")int box_no){
		
		// 프로젝트 정보
		ProjectVO proVo = (ProjectVO) session.getAttribute("proVo");
		
		BoxProjectVO boxProVo = new BoxProjectVO();
		boxProVo.setPro_no(proVo.getPro_no());
		boxProVo.setBox_no(box_no);
		
		return boxProService.insertBoxPro(boxProVo);
	}
	
	/**
	* Method : boxProDeleteR
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param session
	* @param box_no
	* @return
	* Method 설명 : 보관함 프로젝트 삭제
	*/
	@RequestMapping(value="/deleteR", method=RequestMethod.GET)
	@ResponseBody
	public int boxProDeleteR(HttpSession session, @RequestParam("box_no")int box_no){
		
		// 프로젝트 정보
		ProjectVO proVo = (ProjectVO) session.getAttribute("proVo");
		
		BoxProjectVO boxProVo = new BoxProjectVO();
		boxProVo.setPro_no(proVo.getPro_no());
		boxProVo.setBox_no(box_no);
		
		return boxProService.deleteBoxProR(boxProVo);
	}
}
