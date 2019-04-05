package kr.or.dev.board.post.web;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.board.post.model.PostVO;
import kr.or.dev.board.post.service.PostServiceInf;
import kr.or.dev.board.post_reply.model.PostReplyVO;
import kr.or.dev.board.post_reply.service.PostReplyServiceInf;
import kr.or.dev.files.model.FilesVO;
import kr.or.dev.files.service.FilesServiceInf;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//@RequestMapping 요청에 대해 어떤 Controller, 어떤 메소드가 처리할지를 맵핑하기 위한 어노테이션
@RequestMapping("/post")
@Controller("postController")
public class PostController {
	
	//파일 경로
	private final String file_path = "C:\\Flowolf\\files\\"; 
	
	// 게시판
	@Resource(name="postService")
	private PostServiceInf postService;
	
	// 게시글 댓글
	@Resource(name="postReplyService")
	private PostReplyServiceInf postReplyService;
	
	// 첨부 파일
	@Resource(name="filesService")
	private FilesServiceInf filesService;
	
	/**
	* Method : postList
	* 최초작성일 : 2018. 10. 4.
	* 작성자 : 노미소, 김지수
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param post_kind
	* @param model
	* @return
	* Method 설명 : 게시글 리스트 조회
	* note : @RequestParam 간단하게 파라미터값을 가져올수 있음
	* 		 value : 파라미터 이름
	* 		 defaultValue : 해당 파라미터의 기본값
	* 		 Model : 인터페이스
	*/
	@RequestMapping("/list")
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
		String pageNavi = (String) resultMap.get("pageNavi");
		model.addAttribute("pageNavi", pageNavi);
		
		return "postList";

	}
	
	/**
	* Method : postDetail
	* 최초작성일 : 2018. 10. 4.
	* 작성자 : 노미소, 김지수
	* 변경이력 :
	* @param post_no
	* @param pw
	* @param post_kind
	* @param model
	* @return
	* Method 설명 : 게시글 상세보기
	*/
	@RequestMapping("/detail")
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
		
		return "postDetail";
	}
	
	/**
	* Method : postPassCheck
	* 최초작성일 : 2018. 10. 4.
	* 작성자 : 김지수
	* 변경이력 :
	* @param post_no
	* @param post_pw
	* @return
	* Method 설명 : 게시글 비밀번호 확인
	*/
	@RequestMapping("/passCheck")
	@ResponseBody
	public int postPassCheck(@RequestParam("post_no") int post_no,
							 @RequestParam("post_pw") String post_pw){
		
		PostVO postVo = postService.getPostDetail(post_no);
		
		if(postVo.getPost_pw().equals(post_pw)) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	* Method : postInsertView
	* 최초작성일 : 2018. 10. 4.
	* 작성자 : 김지수
	* 변경이력 :
	* @param post_kind
	* @param request
	* @param model
	* @return
	* Method 설명 : 게시글 등록 페이지 view
	*/
	@RequestMapping("/insertView")
	public String insertPostView(){
		return "postInsert";
	}
	
	/**
	* Method : InsertPost
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 김지수
	* 변경이력 :
	* @param postVo
	* @param session
	* @param model
	* @return
	* Method 설명 : 게시글 등록
	 * @throws IOException 
	 * @throws IllegalStateException 
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
		
		return "redirect:/post/detail?post_no=" + post_no;
		
	}
	
	/**
	* Method : postUpdateView
	* 최초작성일 : 2018. 10. 6.
	* 작성자 : 김지수
	* 변경이력 :
	* @return
	* Method 설명 : 게시글 수정 페이지 view
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
		
		return "postUpdate";
	}
	
	/**
	* Method : updatePost
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김지수
	* 변경이력 :
	* @param postVo
	* @param model
	* @return
	* Method 설명 : 게시글 수정
	 * @throws IOException 
	 * @throws IllegalStateException 
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
		
		
		return "redirect:/post/detail?post_no=" + postVo.getPost_no();
	}
	
	/**
	* Method : postDelete
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김지수
	* 변경이력 :
	* @param post_no
	* @param session
	* @return
	* Method 설명 : 게시글 삭제
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
		
		return "redirect:/post/list?post_kind=" + post_kind;
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
		String pageNavi = (String) resultMap.get("pageNavi");
		model.addAttribute("pageNavi", pageNavi);
		
		return "postList";
	}
	
	
}
