package kr.or.dev.files.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dev.files.model.FilesVO;
import kr.or.dev.files.service.FilesServiceInf;
import kr.or.dev.group.project.model.ProjectVO;
import kr.or.dev.timeline.TimeLine;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("filesController")
@RequestMapping("/files")
public class FilesController {

	// filesService
	@Resource(name="filesService")
	private FilesServiceInf filesService;
	
	/**
	* Method : filesBox
	* 최초작성일 : 2018. 10. 11.
	* 작성자 : 김지수, 윤성호
	* 변경이력 :
	* @param mem_id
	* @param model
	* @return
	* Method 설명 :
	*/
	@RequestMapping("/fileBox")
	public String filesBox(@RequestParam("mem_id") String mem_id, Model model){
		
		// 반환값
		List<FilesVO> filesList = new ArrayList<FilesVO>();
		
		// paramMap
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mem_id", mem_id);
		
		// 일반글 파일 List
		paramMap.put("timeline", "basic");
		List<FilesVO> basicFilesList = filesService.getFilesBaTaAllList(paramMap);
		
		// 업무글 파일 List
		paramMap.put("timeline", "task");
		List<FilesVO> taskFilesList = filesService.getFilesBaTaAllList(paramMap);
		
		// 일반글의 댓글 List
		paramMap.put("timeline", "basic");
		paramMap.put("timeline_col", "basic_no");
		List<FilesVO> basicRepFilesList = filesService.getFilesRepAllList(paramMap);

		// 업무의 댓글 List
		paramMap.put("timeline", "task");
		paramMap.put("timeline_col", "task_no");
		List<FilesVO> taskRepFilesList = filesService.getFilesRepAllList(paramMap);
		
		// 일정의 댓글 List
		paramMap.put("timeline", "schedule");
		paramMap.put("timeline_col", "schd_no");
		List<FilesVO> schdRepFilesList = filesService.getFilesRepAllList(paramMap);
		
		// 할일글의 댓글 List
		paramMap.put("timeline", "todo");
		paramMap.put("timeline_col", "todo_no");
		List<FilesVO> todoRepFilesList = filesService.getFilesRepAllList(paramMap);
		
		// 투표글의 댓글 List
		paramMap.put("timeline", "vote");
		paramMap.put("timeline_col", "vote_no");
		List<FilesVO> voteRepFilesList = filesService.getFilesRepAllList(paramMap);
		
		filesList.addAll(basicFilesList);
		filesList.addAll(taskFilesList);
		filesList.addAll(basicRepFilesList);
		filesList.addAll(taskRepFilesList);
		filesList.addAll(schdRepFilesList);
		filesList.addAll(todoRepFilesList);
		filesList.addAll(voteRepFilesList);
		
		Collections.sort(filesList);		
		
		model.addAttribute("filesList", filesList);
		
		return "fileBox";
	}
	
	@RequestMapping("/proFilesBox")
	public String proFilesBox(@RequestParam("pro_no")int pro_no
							, Model model){

		// 반환값
		List<FilesVO> filesList = new ArrayList<FilesVO>();
		
		// paramMap
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pro_no", pro_no);
		
		// 일반글 파일 List
		paramMap.put("timeline", "basic");
		List<FilesVO> basicFilesList = filesService.getProFilesBaTaAllList(paramMap);
		
		// 업무글 파일 List
		paramMap.put("timeline", "task");
		List<FilesVO> taskFilesList = filesService.getProFilesBaTaAllList(paramMap);
		
		// 일반글의 댓글 List
		paramMap.put("timeline", "basic");
		paramMap.put("timeline_col", "basic_no");
		List<FilesVO> basicRepFilesList = filesService.getProFilesRepAllList(paramMap);

		// 업무의 댓글 List
		paramMap.put("timeline", "task");
		paramMap.put("timeline_col", "task_no");
		List<FilesVO> taskRepFilesList = filesService.getProFilesRepAllList(paramMap);
		
		// 일정의 댓글 List
		paramMap.put("timeline", "schedule");
		paramMap.put("timeline_col", "schd_no");
		List<FilesVO> schdRepFilesList = filesService.getProFilesRepAllList(paramMap);
		
		// 할일글의 댓글 List
		paramMap.put("timeline", "todo");
		paramMap.put("timeline_col", "todo_no");
		List<FilesVO> todoRepFilesList = filesService.getProFilesRepAllList(paramMap);
		
		// 투표글의 댓글 List
		paramMap.put("timeline", "vote");
		paramMap.put("timeline_col", "vote_no");
		List<FilesVO> voteRepFilesList = filesService.getProFilesRepAllList(paramMap);
		
		filesList.addAll(basicFilesList);
		filesList.addAll(taskFilesList);
		filesList.addAll(basicRepFilesList);
		filesList.addAll(taskRepFilesList);
		filesList.addAll(schdRepFilesList);
		filesList.addAll(todoRepFilesList);
		filesList.addAll(voteRepFilesList);
		
		Collections.sort(filesList);	// 정렬
		
		model.addAttribute("filesKind", "pro");
		model.addAttribute("filesList", filesList);
		
		return "fileBox";
	}
	
	/**
	* Method : filesView
	* 최초작성일 : 2018. 10. 5.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param files_no
	* @param response
	* @throws IOException
	* Method 설명 : 파일 보여주기
	*/
	@RequestMapping("/view")
	public void filesView(@RequestParam("files_no")int files_no, HttpServletResponse response) throws IOException{
		
		// 파일 정보
		FilesVO filesVo = filesService.getFilesDetail(files_no);
		
		String file = filesVo.getFiles_path()+File.separator+filesVo.getFiles_upload();
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+ filesVo.getFiles_name() +"\"");
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
	* Method : fileDwonload
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param files_no
	* @param model
	* @return
	* Method 설명 : 파일 다운로드
	*/
	@RequestMapping("/download")
	public String fileDwonload(@RequestParam("files_no")int files_no
							 , Model model){
		
		FilesVO filesVo = filesService.getFilesDetail(files_no);
		model.addAttribute("filesVo", filesVo);
		
		return "fileDownloadView";
	}
}
