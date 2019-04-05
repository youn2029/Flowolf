package kr.or.dev.timeline.emoticon_user.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.timeline.emoticon_user.service.EmoticonUserServiceInf;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("emoUserController")
@RequestMapping("/emoUser")
public class EmoticonUserController {

	// 이모티콘 사용자
	@Resource(name="emoUserService")
	private EmoticonUserServiceInf emoUserService;
	
	/**
	* Method : emoUserInsert
	* 최초작성일 : 2018. 9. 27.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param session
	* @param emo_no
	* @param timeline_col
	* @param timeline_no
	* @return
	* Method 설명 : 이모티콘 사용자 등록
	*/
	@RequestMapping("/insert")
	@ResponseBody
	public int emoUserInsert(HttpSession session
						   , @RequestParam("emo_no")int emo_no
						   , @RequestParam("timeline_col")String timeline_col
						   , @RequestParam("timeline_no")int timeline_no){
		
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		
		int emo_user_no = emoUserService.getEmoUserSeq();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("emo_user_no", emo_user_no);
		paramMap.put("emo_no", emo_no);
		paramMap.put("timeline_col", timeline_col);
		paramMap.put("timeline_no", timeline_no);
		paramMap.put("mem_id", memVo.getMem_id());
		
		emoUserService.insertEmoUser(paramMap);
		
		return emo_user_no;
	}
	
	/**
	* Method : emoUserDeleteR
	* 최초작성일 : 2018. 9. 27.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param emo_user_no
	* @return
	* Method 설명 : 이모티콘 사용자 삭제
	*/
	@RequestMapping("/delete")
	@ResponseBody
	public int emoUserDeleteR(@RequestParam("emo_user_no")int emo_user_no){
		
		return emoUserService.deleteEmoUserR(emo_user_no);
	}
}
