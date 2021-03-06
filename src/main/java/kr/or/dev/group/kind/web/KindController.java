package kr.or.dev.group.kind.web;

import javax.annotation.Resource;

import kr.or.dev.group.kind.model.KindVO;
import kr.or.dev.group.kind.service.KindServiceInf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@RequestMapping("/kind")
@Controller
public class KindController {
	
	// json 데이터로 응답을 보내기 위한 
	@Autowired
	MappingJackson2JsonView jsonView;

	// 분류
	@Resource(name="kindService")
	private KindServiceInf kindService;
	
	@RequestMapping("/insert")
	public String insertKind(KindVO kindVo){
		int cnt = kindService.insertKind(kindVo);
		if(cnt > 0){
			System.out.println("분류명 등록 성공");
		}else{
			System.out.println("분류명 등록 실패");
		}
		return "redirect:/adm/proEdit";
	}
	
	@RequestMapping("/kindDelChk")
	public ModelAndView kindDelChk(KindVO kindVo){
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		
		int cnt = kindService.deleteKind(kindVo);
		if(cnt > 0){
			System.out.println("프로젝트 분류 수정 성공");
		}else{
			System.out.println("프로젝트 분류 수정 실패");
		}
		
		
		return mav;
	}
	
}
