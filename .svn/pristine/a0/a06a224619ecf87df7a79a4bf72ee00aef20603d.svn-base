package kr.or.dev.user.admin.web;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.dev.board.post.model.PostVO;
import kr.or.dev.board.post.service.PostServiceInf;
import kr.or.dev.board.post_reply.model.PostReplyVO;
import kr.or.dev.board.post_reply.service.PostReplyServiceInf;
import kr.or.dev.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.dev.files.model.FilesVO;
import kr.or.dev.files.service.FilesServiceInf;
import kr.or.dev.group.kind.model.KindVO;
import kr.or.dev.group.kind.service.KindServiceInf;
import kr.or.dev.group.project.model.ProjectVO;
import kr.or.dev.group.project.service.ProjectServiceInf;
import kr.or.dev.user.member.model.MemberVO;
import kr.or.dev.user.member.service.MemberServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/adm")
@Controller
public class AdminController {

	// 회원
	@Resource(name="memService")
	private MemberServiceInf memService;
	
	// 프로젝트
	@Resource(name="proService")
	private ProjectServiceInf proService;
	
	// 분류
	@Resource(name="kindService")
	private KindServiceInf kindService;
	
	// 게시판
	@Resource(name="postService")
	private PostServiceInf postService;
	
	// 게시판 댓글
	@Resource(name="postReplyService")
	private PostReplyServiceInf postReplyService;
	
	// 첨부 파일
	@Resource(name="filesService")
	private FilesServiceInf filesService;
	
	/**
	* Method : admMain
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param session
	* @param page
	* @param pageSize
	* @param model
	* @return
	* Method 설명 : 모든 회원 정보를 나타내는 목록 반환
	*/
	@RequestMapping("/memList")
	public String admMain(HttpSession session
						, @RequestParam(value="page", defaultValue="1")int page
						, @RequestParam(value="pageSize", defaultValue="20")int pageSize
						, Model model){
		
		// 회원 정보
		MemberVO memVo = (MemberVO)session.getAttribute("memVo");
		
		// paramMap
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		// 전체 회원 페이지 조회
		List<MemberVO> memAllList = memService.getMemPageAllList(paramMap);
		session.setAttribute("memAllList", memAllList);
		
		int totCnt = memService.getMemAllCnt()-1;
		// 페이지네이션
		String pageNavi = makePageNavi(page, pageSize, totCnt, "/adm/memList");
		model.addAttribute("pageNavi", pageNavi);
		
		return "adminMemberlist";
	}
	
	/**
	* Method : proEdit
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param session
	* @param page
	* @param pageSize
	* @param model
	* @return
	* Method 설명 : 모든 프로젝트 정보를 나타내는 목록 반환
	*/
	@RequestMapping("/proEdit")
	public String proEdit(HttpSession session
						, @RequestParam(value="page", defaultValue="1")int page
						, @RequestParam(value="pageSize", defaultValue="10")int pageSize
						, Model model){
		
		// paramMap
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		List<ProjectVO> proPageAllList = proService.getProPageAllList(paramMap);
		session.setAttribute("proPageAllList", proPageAllList);
		
		int totCnt = proPageAllList.size();
		
		// 페이지네이션
		String pageNavi = makePageNavi(page, pageSize, totCnt, "/adm/proEdit");
		model.addAttribute("pageNavi", pageNavi);
		
		List<KindVO> kindAllList = kindService.getKindAllList();
		session.setAttribute("kindAllList", kindAllList);
		return "adminProjectEdit";
	}
	
	/**
	* Method : memUpdate
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param memvo
	* @param session
	* @param file
	* @param mem_pass
	* @return
	* @throws IllegalStateException
	* @throws IOException
	* @throws ServletException
	* Method 설명 : 관리자가 회원의 정보를 수정하는 기능
	*/
	@RequestMapping("/memUpdate")
	public String memUpdate(MemberVO memvo, HttpSession session
							,@RequestParam("mem_pic") MultipartFile file
							,@RequestParam("mem_pass") String mem_pass) throws IllegalStateException, IOException, ServletException{
		
		MemberVO memVo = memService.getMemDetail(memvo.getMem_id());
		memVo.setMem_name(memvo.getMem_name());
		memVo.setMem_nick(memvo.getMem_nick());
		memVo.setMem_phone(memvo.getMem_phone());
		
		
		if(mem_pass != null && !(mem_pass.equals("12345678"))){
			memVo.setMem_pw(KISA_SHA256.encrypt(mem_pass));
		}
		
		
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
		
		return "redirect:/adm/memList";
	}
	
	
	
	
	/**
	* Method : postList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param post_kind
	* @param session
	* @param model
	* @return
	* Method 설명 : 게시판으로 이동하는 기능
	*/
	@RequestMapping("/postList")
	public String postList(@RequestParam(value="page", defaultValue="1") int page,
					 	   @RequestParam(value="pageSize", defaultValue="10") int pageSize,
					 	   @RequestParam(value="post_kind") String post_kind,
					 	   HttpSession session,
					 	   Model model){
	
		// page, pageSize parameter 확인
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("post_kind", post_kind);
		
		// 게시판 분류저장(insert시 필요)
		session.setAttribute("post_kind", post_kind);
		
		// Map형으로 service에서 가져옴 
		Map<String, Object> resultMap = postService.getPostPageList(paramMap);
		
		List<PostVO> postList = (List<PostVO>) resultMap.get("postList");
		model.addAttribute("postList", postList);
		
		// 페이지 네이게이션 문자열
		String pageNavi = makePageNavi(page, pageSize, (int)resultMap.get("totCnt"), post_kind);
		model.addAttribute("pageNavi", pageNavi);
		
		return "adminPostList";

	}
	
	/**
	* Method : postDetail
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param post_no
	* @param model
	* @return
	* Method 설명 : 게시판의 상세 게시글 반환
	*/
	@RequestMapping("/postDetail")
	public String postDetail(@RequestParam("post_no") int post_no,
							Model model){
		PostVO postVo = postService.getPostDetail(post_no);
		model.addAttribute("postVo", postVo);
		
		// 댓글 조회
		List<PostReplyVO> postReplyList = postReplyService.getPostRepList(post_no);
		model.addAttribute("postReplyList", postReplyList);
		
		// 첨부파일 조회 
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeline_col", "post_no");
		paramMap.put("timeline_no", post_no);
		
		List<FilesVO> filesList = filesService.getFilesList(paramMap);
		model.addAttribute("filesList", filesList);
		
		return "adminPostDetail";
	}
	
	/**
	* Method : insertPostView
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 등록 화면 반환
	*/
	@RequestMapping("/insertView")
	public String insertPostView(){
		return "adminPostInsert";
	}
	
	/**
	* Method : insertPost
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param postVo
	* @param session
	* @param model
	* @param fileList
	* @return
	* @throws IllegalStateException
	* @throws IOException
	* Method 설명 : 게시글 등록하는 기능
	*/
	@RequestMapping("/insert")
	public String insertPost(PostVO postVo,
							 HttpSession session,
							 Model model,
							 @RequestParam(value="articleFile", required=false) List<MultipartFile> fileList) throws IllegalStateException, IOException {
		// post_no 가져오기
		int post_no = postService.getPostSeq();
		postVo.setPost_no(post_no);
		
		// 회원정보 가져오기
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		postVo.setMem_id(memVo.getMem_id());
		postVo.setMem_nick(memVo.getMem_nick());
		
		// 게시판 분류 저장
		String post_kind = (String) session.getAttribute("post_kind");
		postVo.setPost_kind(post_kind);
		
		// model 저장
		model.addAttribute("postVo", postVo);
		
		// insert
		int insertCnt = postService.insertPost(postVo);
		
		if(insertCnt > 0){
			
			String files_path = "C:\\Flowolf\\files";	// 파일 경로
			String files_name = "";
			String files_upload = UUID.randomUUID().toString();	// 파일 업로드명
			String files_size = "";
			Map<String, Object> paramMap;
			
			DecimalFormat df = new DecimalFormat("#,###.0");
			DecimalFormat df1 = new DecimalFormat("#,###");
			
			// 첨부파일 List
			if(fileList != null) {
				for (MultipartFile artFile : fileList) {
					
					if (!artFile.isEmpty()) {				
					
						files_name = artFile.getOriginalFilename();		// 파일 이름
						
						// 파일 크기
						double fileSize = artFile.getSize();
						files_size = df1.format(fileSize) + " byte";				
						
						if (Math.round(fileSize*10)/10 >= 1024) {
							fileSize = fileSize/1024;
							files_size = df.format(fileSize) + " KB";
						}
						if (Math.round(fileSize*10)/10 >= 1024) {			
							files_size = df.format(fileSize/1024) + " MB";
						}
						
						// paramMap setting
						paramMap = new HashMap<String, Object>();
						paramMap.put("files_name", files_name);
						paramMap.put("files_path", files_path);
						paramMap.put("files_upload", files_upload);
						paramMap.put("files_size", files_size);
						paramMap.put("timeline_col", "post_no");
						paramMap.put("timeline_no", post_no);
						paramMap.put("files_kind", "fil");
						
						int cnt = filesService.insertFiles(paramMap);
						if (cnt == 1) {					
							// 경로에 파일 저장
							File uploadFile = new File(files_path+File.separator+files_upload);				
							artFile.transferTo(uploadFile);					
						}
					}
				}
			}
		}
		
		return "redirect:/adm/postDetail?post_no=" + post_no;
		
	}
	
	/**
	* Method : updatePostView
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param post_no
	* @param model
	* @return
	* Method 설명 : 게시글을 수정하는 화면 반환
	*/
	@RequestMapping("/updateView")
	public String updatePostView(@RequestParam("post_no") int post_no, Model model){
		PostVO postVo = postService.getPostDetail(post_no);
		model.addAttribute("postVo", postVo);
		
		// 댓글 조회
		List<PostReplyVO> postReplyList = postReplyService.getPostRepList(post_no);
		model.addAttribute("postReplyList", postReplyList);
		
		// 첨부파일 조회 
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeline_col", "post_no");
		paramMap.put("timeline_no", post_no);
		
		List<FilesVO> filesList = filesService.getFilesList(paramMap);
		model.addAttribute("filesList", filesList);
		
		return "adminPostUpdate";
	}
	
	/**
	* Method : updatePost
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param postVo
	* @param model
	* @param fileList
	* @param delFileList
	* @return
	* @throws IllegalStateException
	* @throws IOException
	* Method 설명 : 게시글을 수정하는 기능
	*/
	@RequestMapping("/update")
	public String updatePost(PostVO postVo, Model model,
							@RequestParam(value="articleFile", required=false) List<MultipartFile> fileList,
							@RequestParam(value="del_files_no", required=false) List<Integer> delFileList) throws IllegalStateException, IOException{
		
		// 파일 삭제
		if (delFileList != null) {
			for (Integer files_no : delFileList) {
				filesService.deleteFilesR(files_no);
			}			
		}
		
		// update
		int cnt = postService.updatePost(postVo);
		
		if(cnt > 0){
			String files_path = "C:\\Flowolf\\files";	// 파일 경로
			String files_name = "";
			String files_upload = UUID.randomUUID().toString();	// 파일 업로드명
			String files_size = "";
			Map<String, Object> paramMap;
			
			DecimalFormat df = new DecimalFormat("#,###.0");
			DecimalFormat df1 = new DecimalFormat("#,###");
			
			// 첨부파일 List
			if(fileList != null) {
				for (MultipartFile artFile : fileList) {
					
					if (!artFile.isEmpty()) {				
					
						files_name = artFile.getOriginalFilename();		// 파일 이름
						
						// 파일 크기
						double fileSize = artFile.getSize();
						files_size = df1.format(fileSize) + " byte";				
						
						if (Math.round(fileSize*10)/10 >= 1024) {
							fileSize = fileSize/1024;
							files_size = df.format(fileSize) + " KB";
						}
						if (Math.round(fileSize*10)/10 >= 1024) {			
							files_size = df.format(fileSize/1024) + " MB";
						}
						
						// paramMap setting
						paramMap = new HashMap<String, Object>();
						paramMap.put("files_name", files_name);
						paramMap.put("files_path", files_path);
						paramMap.put("files_upload", files_upload);
						paramMap.put("files_size", files_size);
						paramMap.put("timeline_col", "post_no");
						paramMap.put("timeline_no", postVo.getPost_no());
						paramMap.put("files_kind", "fil");
						
						int cnt2 = filesService.insertFiles(paramMap);
						if (cnt2 == 1) {					
							// 경로에 파일 저장
							File uploadFile = new File(files_path+File.separator+files_upload);				
							artFile.transferTo(uploadFile);					
						}
					}
				}
			}
		}
		
		return "redirect:/adm/postDetail?post_no=" + postVo.getPost_no();
	}
	
	/**
	* Method : postDelete
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param post_no
	* @param session
	* @return
	* Method 설명 : 게시글을 삭제처리 하는 기능
	*/
	@RequestMapping("/delete")
	public String postDelete(@RequestParam("timeline_no") int post_no, HttpSession session){
		
		// delete
		int resultCnt = postService.deletePost(post_no);
		
		if (resultCnt == 1) {			
			
			session.setAttribute("msg", "글이 삭제되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		// 게시판 분류 불러오기
		String post_kind = (String) session.getAttribute("post_kind");
		
		return "redirect:/adm/postList?post_kind=" + post_kind;
	}
	
	/**
	* Method : search
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param searchField
	* @param searchData
	* @param page
	* @param pageSize
	* @param post_kind
	* @param model
	* @param session
	* @return
	* Method 설명 : 게시글 검색
	*/
	@RequestMapping("/search")
	public String search(@RequestParam("searchField") String searchField, 
						 @RequestParam("searchData") String searchData,
						 @RequestParam(value="page", defaultValue="1") int page,
					 	 @RequestParam(value="pageSize", defaultValue="10") int pageSize,
					 	 @RequestParam(value="post_kind") String post_kind,
					 	 Model model, HttpSession session){
		
		// page, pageSize parameter 확인
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("post_kind", post_kind);
		paramMap.put("searchField", searchField);
		paramMap.put("searchData", searchData);
		
		// 게시판 분류저장(insert시 필요)
		session.setAttribute("post_kind", post_kind);
		
		// Map형으로 service에서 가져옴 
		Map<String, Object> resultMap = postService.getPostSearchList(paramMap);
		
		List<PostVO> postList = (List<PostVO>) resultMap.get("postList");
		model.addAttribute("postList", postList);
		
		// 페이지 네이게이션 문자열
		String pageNavi = makePageNavi(page, pageSize, (int)resultMap.get("totCnt"), post_kind);
		model.addAttribute("pageNavi", pageNavi);
		
		return "adminPostList";
	}
	
	/**
	* Method : adminMemberChart
	* 최초작성일 : 2018. 10. 9.
	* 작성자 : 김지수
	* 변경이력 :
	* @return
	* Method 설명 : 회원 통계 페이지
	*/
	@RequestMapping("/memChart")
	public String adminMemberChart(HttpSession session){
		MemberVO memVo = (MemberVO)session.getAttribute("memVo");
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMM");
		
		List<MemberVO> memAllList = memService.getMemAllList(memVo.getMem_id());
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int janb = 0;
		int febb = 0;
		int marb = 0;
		int aplb = 0;
		int mayb = 0;
		int junb = 0;
		int julb = 0;
		int augb = 0;
		int sepb = 0;
		int octb = 0;
		int novb = 0;
		int decb = 0;
		
		int jank = 0;
		int febk = 0;
		int mark = 0;
		int aplk = 0;
		int mayk = 0;
		int junk = 0;
		int julk = 0;
		int augk = 0;
		int sepk = 0;
		int octk = 0;
		int novk = 0;
		int deck = 0;
		
		int jang = 0;
		int febg = 0;
		int marg = 0;
		int aplg = 0;
		int mayg = 0;
		int jung = 0;
		int julg = 0;
		int augg = 0;
		int sepg = 0;
		int octg = 0;
		int novg = 0;
		int decg = 0;
		
		// 총 회원 가입자 수
		int asum = memService.getMemAllCnt()-1;
		
		// 일반 회원 가입자 수
		int bsum = memService.getMemHowjoinCnt("b")-1;
		
		// 카카오 회원 가입자 수
		int ksum = memService.getMemHowjoinCnt("k");
		
		// 구글 회원 가입자 수
		int gsum = memService.getMemHowjoinCnt("g");
		
		for(MemberVO mem : memAllList){
			if(sdf.format(mem.getMem_date()).equals("201801") && mem.getMem_howjoin().equals("b")){
				janb++;
			}else if(sdf.format(mem.getMem_date()).equals("201802") && mem.getMem_howjoin().equals("b")){
				febb++;
			}else if(sdf.format(mem.getMem_date()).equals("201803") && mem.getMem_howjoin().equals("b")){
				marb++;
			}else if(sdf.format(mem.getMem_date()).equals("201804") && mem.getMem_howjoin().equals("b")){
				aplb++;
			}else if(sdf.format(mem.getMem_date()).equals("201805") && mem.getMem_howjoin().equals("b")){
				mayb++;
			}else if(sdf.format(mem.getMem_date()).equals("201806") && mem.getMem_howjoin().equals("b")){
				junb++;
			}else if(sdf.format(mem.getMem_date()).equals("201807") && mem.getMem_howjoin().equals("b")){
				julb++;
			}else if(sdf.format(mem.getMem_date()).equals("201808") && mem.getMem_howjoin().equals("b")){
				augb++;
			}else if(sdf.format(mem.getMem_date()).equals("201809") && mem.getMem_howjoin().equals("b")){
				sepb++;
			}else if(sdf.format(mem.getMem_date()).equals("201810") && mem.getMem_howjoin().equals("b")){
				octb++;
			}else if(sdf.format(mem.getMem_date()).equals("201811") && mem.getMem_howjoin().equals("b")){
				novb++;
			}else if(sdf.format(mem.getMem_date()).equals("201812") && mem.getMem_howjoin().equals("b")){
				decb++;
			}else if(sdf.format(mem.getMem_date()).equals("201801") && mem.getMem_howjoin().equals("k")){
				jank++;
			}else if(sdf.format(mem.getMem_date()).equals("201802") && mem.getMem_howjoin().equals("k")){
				febk++;
			}else if(sdf.format(mem.getMem_date()).equals("201803") && mem.getMem_howjoin().equals("k")){
				mark++;
			}else if(sdf.format(mem.getMem_date()).equals("201804") && mem.getMem_howjoin().equals("k")){
				aplk++;
			}else if(sdf.format(mem.getMem_date()).equals("201805") && mem.getMem_howjoin().equals("k")){
				mayk++;
			}else if(sdf.format(mem.getMem_date()).equals("201806") && mem.getMem_howjoin().equals("k")){
				junk++;
			}else if(sdf.format(mem.getMem_date()).equals("201807") && mem.getMem_howjoin().equals("k")){
				julk++;
			}else if(sdf.format(mem.getMem_date()).equals("201808") && mem.getMem_howjoin().equals("k")){
				augk++;
			}else if(sdf.format(mem.getMem_date()).equals("201809") && mem.getMem_howjoin().equals("k")){
				sepk++;
			}else if(sdf.format(mem.getMem_date()).equals("201810") && mem.getMem_howjoin().equals("k")){
				octk++;
			}else if(sdf.format(mem.getMem_date()).equals("201811") && mem.getMem_howjoin().equals("k")){
				novk++;
			}else if(sdf.format(mem.getMem_date()).equals("201812") && mem.getMem_howjoin().equals("k")){
				deck++;
			}else if(sdf.format(mem.getMem_date()).equals("201801") && mem.getMem_howjoin().equals("g")){
				jang++;
			}else if(sdf.format(mem.getMem_date()).equals("201802") && mem.getMem_howjoin().equals("g")){
				febg++;
			}else if(sdf.format(mem.getMem_date()).equals("201803") && mem.getMem_howjoin().equals("g")){
				marg++;
			}else if(sdf.format(mem.getMem_date()).equals("201804") && mem.getMem_howjoin().equals("g")){
				aplg++;
			}else if(sdf.format(mem.getMem_date()).equals("201805") && mem.getMem_howjoin().equals("g")){
				mayg++;
			}else if(sdf.format(mem.getMem_date()).equals("201806") && mem.getMem_howjoin().equals("g")){
				jung++;
			}else if(sdf.format(mem.getMem_date()).equals("201807") && mem.getMem_howjoin().equals("g")){
				julg++;
			}else if(sdf.format(mem.getMem_date()).equals("201808") && mem.getMem_howjoin().equals("g")){
				augg++;
			}else if(sdf.format(mem.getMem_date()).equals("201809") && mem.getMem_howjoin().equals("g")){
				sepg++;
			}else if(sdf.format(mem.getMem_date()).equals("201810") && mem.getMem_howjoin().equals("g")){
				octg++;
			}else if(sdf.format(mem.getMem_date()).equals("201811") && mem.getMem_howjoin().equals("g")){
				novg++;
			}else if(sdf.format(mem.getMem_date()).equals("201812") && mem.getMem_howjoin().equals("g")){
				decg++;
			}
		}
		
		map.put("asum", asum);
		map.put("bsum", bsum);
		map.put("ksum", ksum);
		map.put("gsum", gsum);
		
		map.put("janb", janb);
		map.put("febb", febb);
		map.put("marb", marb);
		map.put("aplb", aplb);
		map.put("mayb", mayb);
		map.put("junb", junb);
		map.put("julb", julb);
		map.put("augb", augb);
		map.put("sepb", sepb);
		map.put("octb", octb);
		map.put("novb", novb);
		map.put("decb", decb);
		
		map.put("jank", jank);
		map.put("febk", febk);
		map.put("mark", mark);
		map.put("aplk", aplk);
		map.put("mayk", mayk);
		map.put("junk", junk);
		map.put("julk", julk);
		map.put("augk", augk);
		map.put("sepk", sepk);
		map.put("octk", octk);
		map.put("novk", novk);
		map.put("deck", deck);
		
		map.put("jang", jang);
		map.put("febg", febg);
		map.put("marg", marg);
		map.put("aplg", aplg);
		map.put("mayg", mayg);
		map.put("jung", jung);
		map.put("julg", julg);
		map.put("augg", augg);
		map.put("sepg", sepg);
		map.put("octg", octg);
		map.put("novg", novg);
		map.put("decg", decg);
		
		session.setAttribute("map", map);
		
		return "adminMemberChart";
	}
	
	/**
	* Method : prochart
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 프로젝트 통계
	*/
	@RequestMapping("/proChart")
	public String prochart(HttpServletRequest request, HttpSession session, Model model){
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMM");
		
		// 프로젝트 분류 리스트
		List<KindVO> kindAllList = kindService.getKindAllList();
		session.setAttribute("kindAllList", kindAllList);
		
		// count map
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 전체 프로젝트 갯수
		List<ProjectVO> proAllList = proService.getProAllList();
		int asum = proAllList.size();
		
		map.put("asum", asum);
		
		
		// 월별 프로젝트 개수 조회
		int proMonthCnt = 0;
		List<Integer> proMonthCntList = new ArrayList<Integer>();
		for (int i = 0; i <= 12; i++) {
			if(i < 10) {
				proMonthCnt = proService.getProMonthCnt("180"+i);
				proMonthCntList.add(proMonthCnt);
			} else if(i >= 10) {
				proMonthCnt = proService.getProMonthCnt("18"+i);
				proMonthCntList.add(proMonthCnt);
			}
		}
		session.setAttribute("proMonthCntList", proMonthCntList);
		
		
		// 분류별 프로젝트 개수 조회
		int proKindCnt = 0;
		List<Integer> proKindCntList = new ArrayList<>();
		for (int i = 1; i <= kindAllList.size(); i++) {
			
			proKindCnt = proService.getProKindCnt(i);
			proKindCntList.add(proKindCnt);
		}
		session.setAttribute("proKindCntList", proKindCntList);
		
		
		int jane = 0;
		int febe = 0;
		int mare = 0;
		int aple = 0;
		int maye = 0;
		int june = 0;
		int jule = 0;
		int auge = 0;
		int sepe = 0;
		int octe = 0;
		int nove = 0;
		int dece = 0;
		
		int jand = 0;
		int febd = 0;
		int mard = 0;
		int apld = 0;
		int mayd = 0;
		int jund = 0;
		int juld = 0;
		int augd = 0;
		int sepd = 0;
		int octd = 0;
		int novd = 0;
		int decd = 0;
		
		int janm = 0;
		int febm = 0;
		int marm = 0;
		int aplm = 0;
		int maym = 0;
		int junm = 0;
		int julm = 0;
		int augm = 0;
		int sepm = 0;
		int octm = 0;
		int novm = 0;
		int decm = 0;
		
		
		for(ProjectVO pro : proAllList){
			if(sdf.format(pro.getPro_date()).equals("201801") && pro.getKind_no() == 1){
				jane++;
			}else if(sdf.format(pro.getPro_date()).equals("201802") && pro.getKind_no() == 1){
				febe++;
			}else if(sdf.format(pro.getPro_date()).equals("201803") && pro.getKind_no() == 1){
				mare++;
			}else if(sdf.format(pro.getPro_date()).equals("201804") && pro.getKind_no() == 1){
				aple++;
			}else if(sdf.format(pro.getPro_date()).equals("201805") && pro.getKind_no() == 1){
				maye++;
			}else if(sdf.format(pro.getPro_date()).equals("201806") && pro.getKind_no() == 1){
				june++;
			}else if(sdf.format(pro.getPro_date()).equals("201807") && pro.getKind_no() == 1){
				jule++;
			}else if(sdf.format(pro.getPro_date()).equals("201808") && pro.getKind_no() == 1){
				auge++;
			}else if(sdf.format(pro.getPro_date()).equals("201809") && pro.getKind_no() == 1){
				sepe++;
			}else if(sdf.format(pro.getPro_date()).equals("201810") && pro.getKind_no() == 1){
				octe++;
			}else if(sdf.format(pro.getPro_date()).equals("201811") && pro.getKind_no() == 1){
				nove++;
			}else if(sdf.format(pro.getPro_date()).equals("201812") && pro.getKind_no() == 1){
				dece++;
			}else if(sdf.format(pro.getPro_date()).equals("201801") && pro.getKind_no() == 2){
				jand++;
			}else if(sdf.format(pro.getPro_date()).equals("201802") && pro.getKind_no() == 2){
				febd++;
			}else if(sdf.format(pro.getPro_date()).equals("201803") && pro.getKind_no() == 2){
				mard++;
			}else if(sdf.format(pro.getPro_date()).equals("201804") && pro.getKind_no() == 2){
				apld++;
			}else if(sdf.format(pro.getPro_date()).equals("201805") && pro.getKind_no() == 2){
				mayd++;
			}else if(sdf.format(pro.getPro_date()).equals("201806") && pro.getKind_no() == 2){
				jund++;
			}else if(sdf.format(pro.getPro_date()).equals("201807") && pro.getKind_no() == 2){
				juld++;
			}else if(sdf.format(pro.getPro_date()).equals("201808") && pro.getKind_no() == 2){
				augd++;
			}else if(sdf.format(pro.getPro_date()).equals("201809") && pro.getKind_no() == 2){
				sepd++;
			}else if(sdf.format(pro.getPro_date()).equals("201810") && pro.getKind_no() == 2){
				octd++;
			}else if(sdf.format(pro.getPro_date()).equals("201811") && pro.getKind_no() == 2){
				novd++;
			}else if(sdf.format(pro.getPro_date()).equals("201812") && pro.getKind_no() == 2){
				decd++;
			}else if(sdf.format(pro.getPro_date()).equals("201801") && pro.getKind_no() == 3){
				janm++;
			}else if(sdf.format(pro.getPro_date()).equals("201802") && pro.getKind_no() == 3){
				febm++;
			}else if(sdf.format(pro.getPro_date()).equals("201803") && pro.getKind_no() == 3){
				marm++;
			}else if(sdf.format(pro.getPro_date()).equals("201804") && pro.getKind_no() == 3){
				aplm++;
			}else if(sdf.format(pro.getPro_date()).equals("201805") && pro.getKind_no() == 3){
				maym++;
			}else if(sdf.format(pro.getPro_date()).equals("201806") && pro.getKind_no() == 3){
				junm++;
			}else if(sdf.format(pro.getPro_date()).equals("201807") && pro.getKind_no() == 3){
				julm++;
			}else if(sdf.format(pro.getPro_date()).equals("201808") && pro.getKind_no() == 3){
				augm++;
			}else if(sdf.format(pro.getPro_date()).equals("201809") && pro.getKind_no() == 3){
				sepm++;
			}else if(sdf.format(pro.getPro_date()).equals("201810") && pro.getKind_no() == 3){
				octm++;
			}else if(sdf.format(pro.getPro_date()).equals("201811") && pro.getKind_no() == 3){
				novm++;
			}else if(sdf.format(pro.getPro_date()).equals("201812") && pro.getKind_no() == 3){
				decm++;
			}
		}
		
		map.put("jane", jane);
		map.put("febe", febe);
		map.put("mare", mare);
		map.put("aple", aple);
		map.put("maye", maye);
		map.put("june", june);
		map.put("jule", jule);
		map.put("auge", auge);
		map.put("sepe", sepe);
		map.put("octe", octe);
		map.put("nove", nove);
		map.put("dece", dece);
		
		map.put("jand", jand);
		map.put("febd", febd);
		map.put("mard", mard);
		map.put("apld", apld);
		map.put("mayd", mayd);
		map.put("jund", jund);
		map.put("juld", juld);
		map.put("augd", augd);
		map.put("sepd", sepd);
		map.put("octd", octd);
		map.put("novd", novd);
		map.put("decd", decd);
		
		map.put("janm", janm);
		map.put("febm", febm);
		map.put("marm", marm);
		map.put("aplm", aplm);
		map.put("maym", maym);
		map.put("junm", junm);
		map.put("julm", julm);
		map.put("augm", augm);
		map.put("sepm", sepm);
		map.put("octm", octm);
		map.put("novm", novm);
		map.put("decm", decm);
		
		session.setAttribute("map", map);
		
		return "adminProjectChart";
	}
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @param post_kind
	* @return
	* Method 설명 : 게시글 페이지네이션 기능
	*/
	private String makePageNavi(int page, int pageSize, int totCnt, Object post_kind){
		
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if (mod > 0) {
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		// 페이지 전/후 넘기기
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		
		// pagination previous arrow
		String prevDisabledClass = "";
		if (page==1) {
			prevDisabledClass = "class=\"disabled\"";
		}
		pageNaviStr.append("<li " + prevDisabledClass + ">"
				+ "<a href=\"/adm/postList?post_kind=" + post_kind + "&page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"
						+ "<span aria-hidden=\"true\">&laquo;</span>"
				+ "</a>"
			+ "</li>");
		
		// pagination 숫자
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";
			if (i == page) {
				activeClass = "class=\"active\"";
			}
			pageNaviStr.append("<li " + activeClass + "><a href=\"/adm/postList?post_kind=" + post_kind + "&page=" + i + "&pageSize="+ pageSize + "\">" + i + "</a></li>");
		}
		
		// pagination next arrow
		String nextDisabledClass = "";
		if (page==1) {
			prevDisabledClass = "class=\"disabled\"";
		}
		pageNaviStr.append("<li " + nextDisabledClass + ">"
				+ "<a href=\"/adm/postList?post_kind=" + post_kind + "&page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"
						+ "<span aria-hidden=\"true\">&raquo;</span>"
				+ "</a>"
			+ "</li>");
		
		return pageNaviStr.toString();
	}
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @param url
	* @return
	* Method 설명 : 회원과 프로젝트 페이지네이션
	*/
	private String makePageNavi(int page, int pageSize, int totCnt, String url){
		
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if (mod > 0) {
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		// 페이지 전/후 넘기기
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		
		// pagination previous arrow
		String prevDisabledClass = "";
		if (page==1) {
			prevDisabledClass = "class=\"disabled\"";
		}
		pageNaviStr.append("<li " + prevDisabledClass + ">"
				+ "<a href=\""+url+"?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"
						+ "<span aria-hidden=\"true\">&laquo;</span>"
				+ "</a>"
			+ "</li>");
		
		// pagination 숫자
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";
			if (i == page) {
				activeClass = "class=\"active\"";
			}
			pageNaviStr.append("<li " + activeClass + "><a href=\""+url+"?page=" + i + "&pageSize="+ pageSize + "\">" + i + "</a></li>");
		}
		
		// pagination next arrow
		String nextDisabledClass = "";
		if (page==1) {
			prevDisabledClass = "class=\"disabled\"";
		}
		pageNaviStr.append("<li " + nextDisabledClass + ">"
				+ "<a href=\""+url+"?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"
						+ "<span aria-hidden=\"true\">&raquo;</span>"
				+ "</a>"
			+ "</li>");
		
		return pageNaviStr.toString();
	}
	
}
