package kr.or.dev.group.important.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.group.important.model.ImportantVO;
import kr.or.dev.group.important.service.ImportantServiceInf;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/imp")
@Controller("impController")
public class ImportantController {

	// importantService
	@Resource(name="impService")
	private ImportantServiceInf impService;
	
	/**
	* Method : impProList
	* 최초작성일 : 2018. 9. 18.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param session
	* @param model
	* @return
	* Method 설명 : 중요 프로젝트 list
	*/
	@RequestMapping("/list")
	public String impProList(HttpSession session, Model model){
		
		model.addAttribute("what", "중요");
		
		// 회원정보
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		
		List<Map<String, Object>> myProList = impService.getImpProList(memVo.getMem_id());
		model.addAttribute("myProList", myProList);
		
		return "projectList";
	}	
	
	/**
	* Method : insertImp
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param impVo
	* @param session
	* @return
	* Method 설명 : 중요 프로젝트 등록
	*/
	@RequestMapping("/insert")
	@ResponseBody
	public int insertImp(ImportantVO impVo, HttpSession session){
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");		
		impVo.setMem_id(memVo.getMem_id());		
		return impService.insertImp(impVo);
	}	
	
	/**
	* Method : deleteImp
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param impVo
	* @param session
	* @return
	* Method 설명 : 중요 프로젝트 삭제
	*/
	@RequestMapping("/delete")
	@ResponseBody
	public int deleteImp(ImportantVO impVo, HttpSession session){
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");		
		impVo.setMem_id(memVo.getMem_id());		
		return impService.deleteImpR(impVo);
	}
}
