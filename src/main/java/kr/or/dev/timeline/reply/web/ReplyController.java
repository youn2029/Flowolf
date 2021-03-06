package kr.or.dev.timeline.reply.web;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.files.service.FilesServiceInf;
import kr.or.dev.group.project.model.ProjectVO;
import kr.or.dev.timeline.reply.model.ReplyVO;
import kr.or.dev.timeline.reply.service.ReplyServiceInf;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller("repController")
@RequestMapping("/rep")
public class ReplyController {

	// repService
	@Resource(name="repService")
	private ReplyServiceInf repService;
	
	// filesService
	@Resource(name="filesService")
	private FilesServiceInf filesService;
	
	/**
	* Method : repInsert
	* 최초작성일 : 2018. 9. 28.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param session
	* @param rep_cont
	* @param timeline_col
	* @param timeline_no
	* @return
	* Method 설명 : 댓글 등록
	 * @throws IOException 
	 * @throws IllegalStateException 
	*/
	@RequestMapping("/insert")
	public String repInsert(HttpSession session
						  , @RequestParam("rep_cont")String rep_cont
						  , @RequestParam("timeline_col")String timeline_col
						  , @RequestParam("timeline_no")int timeline_no
						  , @RequestParam(value="articleFile", required=false) List<MultipartFile> fileList
						  , @RequestParam(value="imageFile", required=false) List<MultipartFile> imgList) throws IllegalStateException, IOException{
		
		// 프로젝트 정보
		ProjectVO proVo = (ProjectVO) session.getAttribute("proVo");
		
		// 회원 정보
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		
		// 댓글 시퀀스 조회
		int rep_no = repService.getRepSeq();
		
		// 댓글 등록
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rep_no", rep_no);
		paramMap.put("rep_cont", rep_cont);
		paramMap.put("timeline_col", timeline_col);
		paramMap.put("timeline_no", timeline_no);
		paramMap.put("mem_id", memVo.getMem_id());
		
		int resultCnt = repService.insertRep(paramMap);
		
		if (resultCnt == 1) {
			
			String files_path = "C:\\Flowolf\\files";	// 파일 경로
			String files_name = "";
			String files_upload = UUID.randomUUID().toString();	// 파일 업로드명
			String files_size = "";
			Map<String, Object> paraMap;
			
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
						
						// paraMap setting
						paraMap = new HashMap<String, Object>();
						paraMap.put("files_name", files_name);
						paraMap.put("files_path", files_path);
						paraMap.put("files_upload", files_upload);
						paraMap.put("files_size", files_size);
						paraMap.put("timeline_col", "rep_no");
						paraMap.put("timeline_no", rep_no);
						paraMap.put("files_kind", "fil");
						
						int cnt = filesService.insertFiles(paraMap);
						
						if (cnt == 1) {					
							// 경로에 파일 저장
							File uploadFile = new File(files_path+File.separator+files_upload);				
							artFile.transferTo(uploadFile);					
						}
					}
				}
			}
			
			// ImageFile List
			if(imgList != null) {
				for (MultipartFile imgFile : imgList) {
					
					if (!imgFile.isEmpty()) {
					
						files_name = imgFile.getOriginalFilename();		// 파일 이름
						
						// 파일 크기
						double fileSize = imgFile.getSize()/1024.0;
						files_size = Math.round(fileSize*10)/10.0 + " KB";
						if (fileSize >= 1000) {
							files_size = Math.round(fileSize/1024.0*10)/10.0 + " MB";
						}		
						
						// paraMap setting
						paraMap = new HashMap<String, Object>();
						paraMap.put("files_name", files_name);
						paraMap.put("files_path", files_path);
						paraMap.put("files_upload", files_upload);
						paraMap.put("files_size", files_size);
						paraMap.put("timeline_col", "rep_no");
						paraMap.put("timeline_no", rep_no);
						paraMap.put("files_kind", "img");
						
						int cnt = filesService.insertFiles(paraMap);
						
						if (cnt == 1) {					
							// 경로에 파일 저장
							File uploadFile = new File(files_path+File.separator+files_upload);				
							imgFile.transferTo(uploadFile);					
						}
					}
				}
			}
			
			session.setAttribute("msg", "댓글이 등록되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		return "redirect:/pro/detail?pro_no="+proVo.getPro_no();
	}
	
	/**
	* Method : repUpdate
	* 최초작성일 : 2018. 9. 28.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param repVo
	* @param session
	* @return
	* Method 설명 : 댓글 수정
	 * @throws IOException 
	 * @throws IllegalStateException 
	*/
	@RequestMapping("/update")
	public String repUpdate(ReplyVO repVo
						  , @RequestParam(value="articleFile", required=false) List<MultipartFile> fileList
						  , @RequestParam(value="imageFile", required=false) List<MultipartFile> imgList
						  , @RequestParam(value="del_files_no", required=false) List<Integer> delFileList
						  , HttpSession session) throws IllegalStateException, IOException{
		
		// 파일 삭제
		if (delFileList != null) {
			for (Integer files_no : delFileList) {
				filesService.deleteFilesR(files_no);
			}			
		}
		
		// 프로젝트 정보
		ProjectVO proVo = (ProjectVO) session.getAttribute("proVo");
		
		int resultCnt = repService.updateRep(repVo);
		
		if (resultCnt == 1) {
			
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
						paramMap.put("timeline_col", "rep_no");
						paramMap.put("timeline_no", repVo.getRep_no());
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
			
			// ImageFile List
			if(imgList != null) {
				for (MultipartFile imgFile : imgList) {
					
					if (!imgFile.isEmpty()) {
					
						files_name = imgFile.getOriginalFilename();		// 파일 이름
						
						// 파일 크기
						double fileSize = imgFile.getSize()/1024.0;
						files_size = Math.round(fileSize*10)/10.0 + " KB";
						if (fileSize >= 1000) {
							files_size = Math.round(fileSize/1024.0*10)/10.0 + " MB";
						}		
						
						// paramMap setting
						paramMap = new HashMap<String, Object>();
						paramMap.put("files_name", files_name);
						paramMap.put("files_path", files_path);
						paramMap.put("files_upload", files_upload);
						paramMap.put("files_size", files_size);
						paramMap.put("timeline_col", "rep_no");
						paramMap.put("timeline_no", repVo.getRep_no());
						paramMap.put("files_kind", "img");
						
						int cnt = filesService.insertFiles(paramMap);
						
						if (cnt == 1) {					
							// 경로에 파일 저장
							File uploadFile = new File(files_path+File.separator+files_upload);				
							imgFile.transferTo(uploadFile);					
						}
					}
				}
			}
			
			session.setAttribute("msg", "댓글이 수정되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		return "redirect:/pro/detail?pro_no="+proVo.getPro_no();
	}
	
	/**
	* Method : repDelete
	* 최초작성일 : 2018. 10. 9.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param rep_no
	* @param session
	* @return
	* Method 설명 : 댓글 삭제
	*/
	@RequestMapping("/delete")
	public String repDelete(@RequestParam("timeline_no")int rep_no
						  , HttpSession session){
		
		// 프로젝트 정보
		ProjectVO proVo = (ProjectVO) session.getAttribute("proVo");
		
		// 댓글 삭제
		int resultCnt = repService.deleteRep(rep_no);
		
		if (resultCnt == 1) {
			
			session.setAttribute("msg", "댓글이 삭제되었습니다.");
			session.setAttribute("className", "alert-warning");
		}
		
		return "redirect:/pro/detail?pro_no="+proVo.getPro_no();
	}
}
