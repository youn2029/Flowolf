package kr.or.dev.user.member.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.alim.service.AlimServiceInf;
import kr.or.dev.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.dev.group.project_user.model.ProjectUserVO;
import kr.or.dev.group.project_user.service.ProjectUserServiceInf;
import kr.or.dev.user.member.model.MemberVO;
import kr.or.dev.user.member.service.MemberServiceInf;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller("loginController")
@RequestMapping("/login")
public class LoginController {
	
	// 회원
	@Resource(name="memService")
	private MemberServiceInf memService;
	
	// 프로젝트 유저
	@Resource(name="proUserService")
	private ProjectUserServiceInf proUserService;
	
	// 알림
	@Resource(name="alimService")
	private AlimServiceInf alimService;
	
	/**
	* Method : loginView
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 로그인 화면
	*/
	@RequestMapping("/view")
	public String loginView(@RequestParam(value="pro_no", defaultValue="0")int pro_no
						  , @RequestParam(value="mem_nick", required=false)String mem_nick
						  , Model model){
		
		if (pro_no != 0) {
			model.addAttribute("pro_no", pro_no);
			model.addAttribute("mem_nick", mem_nick);			
		}
		
		return "login/login";
	}
	
	/**
	* Method : loginProcess
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @param mem_pw
	* @param model
	* @param session
	* @return
	* Method 설명 : 로그인
	* @throws UnknownHostException 
	*/
	@RequestMapping("/login")
	@ResponseBody
	public int loginProcess(@RequestParam("mem_id") String mem_id
						  , @RequestParam("mem_pw") String mem_pw
						  , @RequestParam(value="pro_no", defaultValue="0") int pro_no
						  , @RequestParam(value="apply", required=false) String apply
						  , @RequestParam(value="mem_nick", required=false) String mem_nick
						  , HttpSession session) throws UnknownHostException{
		
		MemberVO memVo = memService.getMemDetail(mem_id);
		
		if (memVo.getMem_pw().equals(KISA_SHA256.encrypt(mem_pw))) {
			
			if(memVo.getMem_id().equals("admin")){
				// 회원정보
				session.setAttribute("memVo", memVo);
				return 2;
			}else if(memVo.getMem_chk().equals("n")) {
				
				return 3;
			}else {
				// 회원정보
				session.setAttribute("memVo", memVo);
				session.setAttribute("ip", InetAddress.getLocalHost().getHostAddress());
				
				// 프로젝트 초대 받았을 때
				if (pro_no != 0) {
					
					// 프로젝트 유저 Vo
					ProjectUserVO proUserVo = new ProjectUserVO();
					proUserVo.setMem_id(memVo.getMem_id());
					proUserVo.setPro_no(pro_no);
					proUserVo.setPro_user_man_chk("n");
					
					ProjectUserVO isProUserVo = proUserService.getProUserDetail(proUserVo);
					
					if (isProUserVo == null) {
						
						// 프로젝트 초대
						proUserService.insertProUser(proUserVo);
						
						// paramMap
						Map<String, Object> paramMap = new HashMap<String, Object>();
						paramMap.put("alim_cont", mem_nick+"님이 프로젝트에 초대했습니다.");
						paramMap.put("alim_col", "pro_no");
						paramMap.put("alim_col_no", pro_no);
						paramMap.put("mem_id", memVo.getMem_id());
						paramMap.put("apply", apply);
						
						// 알람 등록
						alimService.insertAlim(paramMap);
					}					
				}				
				// 로그인 성공
				return 1;				
			}		
			
		}else {			
			
			// 로그인 실패
			return 0;
		}		
	}
	
	/**
	* Method : idChk
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : ID(Email) 중복 체크
	*/
	@RequestMapping("/idChk")
	@ResponseBody
	public int idChk(@RequestParam("mem_id") String mem_id){
		return memService.chkMemId(mem_id);
	}
	
	
	/**
	* Method : nickChk
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_nick
	* @return
	* Method 설명 : Nick 중복 체크
	*/
	@RequestMapping("/nickChk")
	@ResponseBody
	public int nickChk(@RequestParam("mem_nick") String mem_nick){		
		return memService.chkMemNick(mem_nick);
	}
	
	
	/**
	* Method : signUp
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param req
	* @return
	* @throws IllegalStateException
	* @throws IOException
	* Method 설명 : 회원가입
	*/
	@RequestMapping("/signup")
	@ResponseBody
	public int signUp(MultipartHttpServletRequest req) throws IllegalStateException, IOException{	
		
		MultipartFile pic = req.getFile("mem_pic");
				
		// 사진 저장 경로 (임시)
		String pic_path = "C:\\Flowolf\\profile";
		String pic_name = "";
		String pic_upload = "";
		
		if (pic.isEmpty()) {
			pic_name = "user-pic-sample.png";
			pic_upload = "cf40302c-2204-4d02-99bc-a8276bf480e7";			
		}else {
			pic_name = pic.getOriginalFilename();
			pic_upload = UUID.randomUUID().toString();
			
			File uploadFile = new File(pic_path+File.separator+pic_upload);
			
			// 지정된 경로에 저장
			pic.transferTo(uploadFile);
		}
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(req.getParameter("mem_id"));
		memVo.setMem_pw(KISA_SHA256.encrypt(req.getParameter("mem_pw")));
		memVo.setMem_name(req.getParameter("mem_name"));
		memVo.setMem_nick(req.getParameter("mem_nick"));
		memVo.setMem_phone(req.getParameter("mem_phone"));		
		memVo.setMem_pic_name(pic_name);
		memVo.setMem_pic_path(pic_path);
		memVo.setMem_pic_upload(pic_upload);	
		
		return memService.insertMem(memVo);
		
	}
	
	/**
	* Method : findId
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_name
	* @param mem_phone
	* @return
	* Method 설명 : 아이디 찾기
	*/
	@RequestMapping("/findId")
	@ResponseBody
	public Map<String, String> findId(@RequestParam("mem_name") String mem_name, @RequestParam("mem_phone") String mem_phone){	
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mem_name", mem_name);
		paramMap.put("mem_phone", mem_phone);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("mem_id", memService.findId(paramMap));
		
		return result;
	}
	
	/**
	* Method : memChk
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_name
	* @param mem_id
	* @param mem_phone
	* @return
	* Method 설명 : Password 찾기를 할 때, 해당 회원 조회
	*/
	@RequestMapping("/memChk")
	@ResponseBody
	public Map<String, String> memChk(@RequestParam("mem_name") String mem_name
									, @RequestParam("mem_id") String mem_id
									, @RequestParam("mem_phone") String mem_phone){
		
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("mem_name", mem_name);
		paramMap.put("mem_phone", mem_phone);
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("mem_id", memService.getMemChk(paramMap));
		
		return result;
	}
	
	/**
	* Method : memPwSet
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @param mem_pw
	* @return
	* Method 설명 : 회원의 비밀번호 수정
	*/
	@RequestMapping("/memPwSet")
	@ResponseBody
	public int memPwSet(@RequestParam("mem_id") String mem_id
				   , @RequestParam("mem_pw") String mem_pw){
		
		MemberVO memVo = memService.getMemDetail(mem_id);
		
		String pw = KISA_SHA256.encrypt(mem_pw);
		memVo.setMem_pw(pw);
		
		return memService.updateMem(memVo);
	}
	
	/**
	* Method : msgSend
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_phone
	* @param phoneNum
	* @return
	* Method 설명 : 해당 핸드폰 번호에 인증번호 전송
	*/
	@RequestMapping("/msgSend")
	@ResponseBody
	public int msgSend(@RequestParam("mem_phone") String mem_phone
					 , @RequestParam("phoneNum") int phoneNum){
		
		System.out.println(mem_phone+", "+phoneNum);
		
		String msg = "[FlowolF 본인 확인] 인증 코드("+ phoneNum +")를 입력해주세요.";
		
		String api_key = "NCSAW4FAYIZKPMFA";
	    String api_secret = "MDLN1ZC5BX31NLM8X31541UBJ36J0WUH";
	    Message coolsms = new Message(api_key, api_secret);
	    
	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", mem_phone); // 수신번호
	    params.put("from", "01094217598"); // 발신번호
	    params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
	    params.put("text", msg); // 문자내용    
	    params.put("app_version", "JAVA SDK v1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	      return 1;
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	      return 0;
	    }	    
	    
	}
	
	/**
	* Method : googleLogin
	* 최초작성일 : 2018. 10. 11.
	* 작성자 : 김요섭, 윤성호
	* 변경이력 :
	* @param mem_id
	* @param mem_nick
	* @param mem_pic
	* @param session
	* @return
	 * @throws IOException 
	*/
	@RequestMapping("/google")
	@ResponseBody
	public int googleLogin(@RequestParam("mem_id")String mem_id
						 , @RequestParam("mem_nick")String mem_nick
						 , @RequestParam("mem_pic")String mem_pic
						 , @RequestParam(value="pro_no", defaultValue="0") int pro_no
						 , @RequestParam(value="apply", required=false) String apply
						 , @RequestParam(value="apply_nick", required=false) String apply_nick
						 , HttpSession session) throws IOException{		
		
		MemberVO memVo = memService.getMemDetail(mem_id);
		
		// 회원 유무 체크
		if(memVo == null){
			
			String pic_path = "C:\\Flowolf\\profile";
			String pic_upload = UUID.randomUUID().toString();
			String pic_name = pic_upload+".jpg";
			
			URL url = new URL(mem_pic);
			URLConnection uc = url.openConnection();
			
			
			InputStream is = uc.getInputStream();
			byte[] b = new byte[512];
			int len;		
			
			FileOutputStream fos =  new FileOutputStream(new File(pic_path+File.separator+pic_upload));
			
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			
			is.close();
			fos.close();
			
			// 회원가입 후 로그인
			memVo = new MemberVO();
			memVo.setMem_id(mem_id);				// ID
			memVo.setMem_name(mem_nick);			// name
			memVo.setMem_nick(mem_nick);			// nick
			memVo.setMem_pw(KISA_SHA256.encrypt("google"));		// pw
			memVo.setMem_pic_name(pic_name);	// profile_name
			memVo.setMem_pic_upload(pic_upload);	// profile_upload
			memVo.setMem_pic_path(pic_path);	// profile_path
			memVo.setMem_phone("-");		// phone
			memVo.setMem_howjoin("g");				// howjoin
			
			int cnt = memService.insertMem(memVo);
			if(cnt > 0){
				
				// 회원정보
				session.setAttribute("memVo", memVo);
				session.setAttribute("ip", InetAddress.getLocalHost().getHostAddress());
				
				return 1;				
			}			
		}else if(memVo != null && memVo.getMem_howjoin().equals("g")){
			
			// 로그인
			session.setAttribute("memVo", memVo);
			session.setAttribute("ip", InetAddress.getLocalHost().getHostAddress());
			
			// 프로젝트 초대 받았을 때
			if (pro_no != 0) {
				
				// 프로젝트 유저 Vo
				ProjectUserVO proUserVo = new ProjectUserVO();
				proUserVo.setMem_id(memVo.getMem_id());
				proUserVo.setPro_no(pro_no);
				proUserVo.setPro_user_man_chk("n");
				
				ProjectUserVO isProUserVo = proUserService.getProUserDetail(proUserVo);
				
				if (isProUserVo == null) {
					
					// 프로젝트 초대
					proUserService.insertProUser(proUserVo);
					
					// paramMap
					Map<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.put("alim_cont", apply_nick+"님이 프로젝트에 초대했습니다.");
					paramMap.put("alim_col", "pro_no");
					paramMap.put("alim_col_no", pro_no);
					paramMap.put("mem_id", memVo.getMem_id());
					paramMap.put("apply", apply);
					
					// 알람 등록
					alimService.insertAlim(paramMap);
				}				
			}			
			return 1;			
		}		
		return 0;
	}
	
	/**
	* Method : kakaoLogin
	* 최초작성일 : 2018. 10. 11.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @param mem_nick
	* @param mem_pic
	* @param session
	* @return
	 * @throws IOException 
	*/
	@RequestMapping("/kakao")
	@ResponseBody
	public int kakaoLogin(@RequestParam("mem_id")String mem_id 
						, @RequestParam("mem_nick")String mem_nick
						, @RequestParam("mem_pic")String mem_pic
						, @RequestParam(value="pro_no", defaultValue="0") int pro_no
						, @RequestParam(value="apply", required=false) String apply
						, @RequestParam(value="apply_nick", required=false) String apply_nick
						, HttpSession session) throws IOException{
		
		MemberVO memVo = memService.getMemDetail(mem_id);
		
		// 회원 유무 체크
		if(memVo == null){
			
			String pic_path = "C:\\Flowolf\\profile";
			String pic_upload = UUID.randomUUID().toString();
			String pic_name = pic_upload+".jpg";
			
			URL url = new URL(mem_pic);
			URLConnection uc = url.openConnection();			
			
			InputStream is = uc.getInputStream();
			byte[] b = new byte[512];
			int len;		
			
			FileOutputStream fos =  new FileOutputStream(new File(pic_path+File.separator+pic_upload));
			
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			
			is.close();
			fos.close();
			
			// 회원가입 후 로그인
			memVo = new MemberVO();
			memVo.setMem_id(mem_id);				// ID
			memVo.setMem_name(mem_nick);			// name
			memVo.setMem_nick(mem_nick);			// nick
			memVo.setMem_pw(KISA_SHA256.encrypt("kakao"));		// pw
			memVo.setMem_pic_name(pic_name);	// profile_name
			memVo.setMem_pic_upload(pic_upload);	// profile_upload
			memVo.setMem_pic_path(pic_path);	// profile_path
			memVo.setMem_phone("-");		// phone
			memVo.setMem_howjoin("k");				// howjoin
			int cnt = memService.insertMem(memVo);
			if(cnt > 0){
				
				// 회원정보
				session.setAttribute("memVo", memVo);
				session.setAttribute("ip", InetAddress.getLocalHost().getHostAddress());
				
				return 1;				
			}			
		}else if(memVo != null && memVo.getMem_howjoin().equals("k")){
			// 로그인
			session.setAttribute("memVo", memVo);
			session.setAttribute("ip", InetAddress.getLocalHost().getHostAddress());
			
			// 프로젝트 초대 받았을 때
			if (pro_no != 0) {
				
				// 프로젝트 유저 Vo
				ProjectUserVO proUserVo = new ProjectUserVO();
				proUserVo.setMem_id(memVo.getMem_id());
				proUserVo.setPro_no(pro_no);
				proUserVo.setPro_user_man_chk("n");
				
				ProjectUserVO isProUserVo = proUserService.getProUserDetail(proUserVo);
				
				if (isProUserVo == null) {
					
					// 프로젝트 초대
					proUserService.insertProUser(proUserVo);
					
					// paramMap
					Map<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.put("alim_cont", apply_nick+"님이 프로젝트에 초대했습니다.");
					paramMap.put("alim_col", "pro_no");
					paramMap.put("alim_col_no", pro_no);
					paramMap.put("mem_id", memVo.getMem_id());
					paramMap.put("apply", apply);
					
					// 알람 등록
					alimService.insertAlim(paramMap);
				}				
			}			
			return 1;
		}
		
		return 0;
		
	}
	
	/**
	* Method : logout
	* 최초작성일 : 2018. 10. 11.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param session
	* @return
	* Method 설명 : 로그아웃
	*/
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login/login";
	}

}