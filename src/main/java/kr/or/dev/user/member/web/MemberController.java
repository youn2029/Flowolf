package kr.or.dev.user.member.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dev.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.dev.user.member.model.MemberVO;
import kr.or.dev.user.member.service.MemberServiceInf;
import kr.or.dev.user.partner.model.PartnerVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller("memController")
@RequestMapping("/mem")
public class MemberController {
	
	@Resource(name="memService")
	private MemberServiceInf memService;
	
	// json 데이터로 응답을 보내기 위한 
	@Autowired
	MappingJackson2JsonView jsonView;
	
	/**
	* Method : memPic
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @param response
	* @throws IOException
	* Method 설명 : 회원 프로필 사진
	*/
	@RequestMapping("/pic")
	public void memPic(@RequestParam("mem_id")String mem_id, HttpServletResponse response) throws IOException{
		
		MemberVO memVo = memService.getMemDetail(mem_id);
			
		String file = memVo.getMem_pic_path()+ File.separator + memVo.getMem_pic_upload();
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+ memVo.getMem_pic_name() +"\"");
		response.setContentType("application/octet-stream");
		
		//file 입출력을 위한 준비
		ServletOutputStream sos = response.getOutputStream();			
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len;
		
		while ((len = fis.read(b)) != -1) {
			sos.write(b, 0, len);
		}
		
		sos.close();
		fis.close();		
	}
	
	/**
	* Method : getPhone
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 김지수
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 특정 회원의 폰넘버 가져오기
	*/
	@RequestMapping("/ptnChk")
	@ResponseBody
	public Map<String, String> getPhone(@RequestParam("mem_id") String mem_id, HttpSession session){
		
		// 회원정보 가져오기
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		String phoneNum = memVo.getMem_phone();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("phoneNum", phoneNum);
		
		// 동료 목록 가져오기
		List<PartnerVO> ptnList = (List<PartnerVO>) session.getAttribute("ptnMyList");
		for (PartnerVO ptnVo : ptnList) {
			if(ptnVo.getMem_id().equals(mem_id)){
				map.put("ptnResult", "true");
				break;
			} else {
				map.put("ptnResult", "false");
			}
		}
		
		return map;
	}
	
	/**
	* Method : memEdit
	* 최초작성일 : 2018. 10. 5.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 회원정보 수정 페이지로 이동
	*/
	@RequestMapping("/memEdit")
	public String memEdit(){
		return "memEdit";
	}
	
	/**
	* Method : adminEdit
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 김지수
	* 변경이력 :
	* @return
	* Method 설명 : 관리자 정보 수정 페이지로 이동
	*/
	@RequestMapping("/admEdit")
	public String adminEdit(){
		return "adminEdit";
	}
	
	/**
	* Method : memUpdate
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param memvo
	* @param file
	* @param session
	* @return
	* @throws IllegalStateException
	* @throws IOException
	* @throws ServletException
	* Method 설명 : memvo객체를 매개변수로 받아 회원정보 수정
	*/
	@RequestMapping("/memUpdate")
	public String memUpdate(MemberVO memvo, HttpSession session
							,@RequestParam("mem_pic") MultipartFile file) throws IllegalStateException, IOException, ServletException{
		MemberVO memVo = (MemberVO)session.getAttribute("memVo");
		memVo.setMem_name(memvo.getMem_name());
		memVo.setMem_nick(memvo.getMem_nick());
		
		if(file != null){
			String pic_path = "C:\\Flowolf\\profile";
			String pic_upload = UUID.randomUUID().toString();
			File file_upload = new File(pic_path + File.separator + pic_upload);
			file.transferTo(file_upload);
			
			memVo.setMem_pic_name(file.getOriginalFilename());
			memVo.setMem_pic_path(pic_path);
			memVo.setMem_pic_upload(pic_upload);
		}
		
		int cnt = memService.updateMem(memVo);
		
		if(cnt > 0){
			session.setAttribute("msg", "회원 정보가 수정되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		return "redirect:/mem/memEdit";
	}
	
	/**
	* Method : memPwChk
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param pw
	* @param newPw
	* @param newPwChk
	* @param session
	* @return
	* Method 설명 : 현재 비밀번호와 새 비밀번호를 매개변수로 받아 비밀번호가 일치하는지 확인
	*/
	@RequestMapping("/memPwChk")
	public ModelAndView memPwChk(@RequestParam("pw") String pw,
			  @RequestParam("newPw") String newPw,
			  @RequestParam("newPwChk") String newPwChk,
			  HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		MemberVO memVo = (MemberVO)session.getAttribute("memVo");
		if(KISA_SHA256.encrypt(pw).equals(memVo.getMem_pw())){
			if(newPw.equals(newPwChk)){
				if(newPw.equals("")){
					mav.addObject("result", "새 비밀번호를 입력해주세요.");
				}else{
					mav.addObject("result", "비밀번호가 변경되었습니다.");
					mav.addObject("upd", 1);
				}
			}else{
				mav.addObject("result", "새 비밀번호가 일치하지 않습니다.");
			}
		}else{
			if(pw.equals("")){
				mav.addObject("result", "현재 비밀번호를 입력해주세요.");
			}else{
				mav.addObject("result", "현재 비밀번호가 일치하지 않습니다.");
			}
		}
		
		return mav;
		
	}
	
	/**
	* Method : memPwUpdate
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param newPw
	* @param session
	* @return
	* Method 설명 : 새 비밀번호를 매개변수로 받아 회원정보 수정
	*/
	@RequestMapping("/memPwUpdate")
	public String memPwUpdate(@RequestParam("newPw") String newPw,
							  HttpSession session){
		MemberVO memVo = (MemberVO)session.getAttribute("memVo");
		memVo.setMem_pw(KISA_SHA256.encrypt(newPw));
		
		int cnt = memService.updateMem(memVo);
		if(cnt > 0){
			System.out.println("비밀번호 변경 성공");
		}else{
			System.out.println("비밀번호 변경 실패");
		}
		
		return "redirect:/mem/memEdit";
	}
	
	/**
	* Method : memPwChk
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param mem_pw
	* @param session
	* @return
	* Method 설명 : db의 비밀번호와 입력된 비밀번호를  비교하여 일치하는지 확인
	*/
	@RequestMapping("/memOutPwChk")
	public ModelAndView memPwChk(@RequestParam("mem_pw") String mem_pw,
			  HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setView(jsonView);
		MemberVO memVo = (MemberVO)session.getAttribute("memVo");
		if(KISA_SHA256.encrypt(mem_pw).equals(memVo.getMem_pw())){
			mav.addObject("result", "탈퇴되었습니다.");
			mav.addObject("del", 1);
		}else{
			mav.addObject("result", "비밀번호가 일치하지 않습니다.");
		}
		
		return mav;
		
	}
	
	/**
	* Method : memOut
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param session
	* @return
	* Method 설명 : 회원정보 탈퇴(비활성화)처리
	*/
	@RequestMapping("/memOut")
	public String memOut(HttpSession session){
		MemberVO memVo = (MemberVO)session.getAttribute("memVo");
		int cnt = memService.deleteMem(memVo.getMem_id());
		if(cnt > 0){
			System.out.println("회원 탈퇴 성공");
		}else{
			System.out.println("회원 탈퇴 실패");
		}
		return "login/login";
	}

}
