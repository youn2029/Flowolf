package kr.or.dev.group.box.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.group.box.model.BoxVO;
import kr.or.dev.group.box.service.BoxServiceInf;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/box")
@Controller("boxController")
public class BoxController {
	
	@Resource(name="boxService")
	private BoxServiceInf boxService;
	
	/**
	* Method : insertBox
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param boxVo
	* @param session
	* @return
	* Method 설명 : 보관함 등록
	*/
	@RequestMapping("/insert")
	public String insertBox(BoxVO boxVo, HttpSession session){
		
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
				
		boxVo.setMem_id(memVo.getMem_id());		
		
		int resultCnt = boxService.insertBox(boxVo);
		
		if (resultCnt == 1) {
			
			session.setAttribute("msg", "보관함이 추가되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		return "redirect:/pro/main";
	}
	
	/**
	* Method : updateBox
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param box_no
	* @param box_name
	* @return
	* Method 설명 : 보관함 수정
	*/
	@RequestMapping("/update")
	public String updateBox(@RequestParam("box_no")int box_no
						  , @RequestParam("box_name")String box_name
						  , HttpSession session){
		
		BoxVO boxVo = boxService.getBoxDetail(box_no);
		boxVo.setBox_name(box_name);
		
		int resultCnt = boxService.updateBox(boxVo);
		
		if (resultCnt == 1) {
			
			session.setAttribute("msg", "보관함이 수정되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		return "redirect:/pro/main";
	}
	
	/**
	* Method : deleteBox
	* 최초작성일 : 2018. 9. 16.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param box_no
	* @return
	* Method 설명 : 보관함 삭제
	*/
	@RequestMapping("/delete")
	public String deleteBox(@RequestParam("box_no")int box_no, HttpSession session){
		
		int resultCnt = boxService.deleteBox(box_no);
		
		if (resultCnt == 1) {
			
			session.setAttribute("msg", "보관함이 삭제되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		return "redirect:/pro/main";
	}
	
}
