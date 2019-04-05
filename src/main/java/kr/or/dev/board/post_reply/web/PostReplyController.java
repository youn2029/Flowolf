package kr.or.dev.board.post_reply.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.dev.board.post_reply.model.PostReplyVO;
import kr.or.dev.board.post_reply.service.PostReplyServiceInf;
import kr.or.dev.user.member.model.MemberVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/postReply")
@Controller("postReplyController")
public class PostReplyController {
	
	@Resource(name="postReplyService")
	private PostReplyServiceInf postReplyService;
	
	/**
	* Method : postReplyInsert
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김지수
	* 변경이력 :
	* @param post_no
	* @param postRepVo
	* @param session
	* @param model
	* @return
	* Method 설명 : 게시판 댓글 등록
	*/
	@RequestMapping("/insert")
	public String postReplyInsert(@RequestParam("post_no") int post_no, PostReplyVO postRepVo, HttpSession session, Model model){
		
		// 게시판 댓글 번호 가져오기
		int post_rep_no = postReplyService.getPostRepSeq();
		postRepVo.setPost_rep_no(post_rep_no);
		
		// 게시글 번호 저장
		postRepVo.setPost_no(post_no);
		
		// 회원정보 가져오기
		MemberVO memVo = (MemberVO) session.getAttribute("memVo");
		postRepVo.setMem_id(memVo.getMem_id());
		
		// insert
		postReplyService.insertPostRep(postRepVo);
		
		if(memVo.getMem_id().equals("admin")){
			return "redirect:/adm/postDetail?post_no=" + post_no;
		}else{
			return "redirect:/post/detail?post_no=" + post_no;
		}
		
	}
	
	/**
	* Method : postReplyUpdate
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김지수
	* 변경이력 :
	* @param post_rep_no
	* @param postRepVo
	* @return
	* Method 설명 : 게시판 댓글 수정
	*/
	@RequestMapping("/update")
	public String postReplyUpdate(@RequestParam("post_rep_no") int post_rep_no,
								  PostReplyVO postRepVo, HttpSession session){
		
		MemberVO memVo = (MemberVO)session.getAttribute("memVo");
		
		// 게시판 댓글 번호 저장
		postRepVo.setPost_rep_no(post_rep_no);
		
		// update
		postReplyService.updatePostRep(postRepVo);
		
		if(memVo.getMem_id().equals("admin")){
			return "redirect:/adm/postDetail?post_no=" + postRepVo.getPost_no();
		}else{
			return "redirect:/post/detail?post_no=" + postRepVo.getPost_no();
		}
		
	}
	
	/**
	* Method : postReplyDelete
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 김지수
	* 변경이력 :
	* @param post_rep_no
	* @return
	* Method 설명 : 게시판 댓글 삭제처리
	*/
	@RequestMapping("/delete")
	@ResponseBody
	public int postReplyDelete(@RequestParam("post_rep_no") int post_rep_no){
		return postReplyService.deletePostRep(post_rep_no);
	}
	
	

}
