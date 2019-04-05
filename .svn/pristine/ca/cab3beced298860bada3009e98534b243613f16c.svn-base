package kr.or.dev.timeline.basic.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.files.model.FilesVO;
import kr.or.dev.files.service.FilesServiceInf;
import kr.or.dev.timeline.TimeLine;
import kr.or.dev.timeline.basic.dao.BasicDaoInf;
import kr.or.dev.timeline.basic.model.BasicVO;
import kr.or.dev.timeline.emoticon_user.model.EmoticonUserVO;
import kr.or.dev.timeline.emoticon_user.service.EmoticonUserServiceInf;
import kr.or.dev.timeline.reply.service.ReplyServiceInf;

import org.springframework.stereotype.Repository;

@Repository("basicService")
public class BasicService implements BasicServiceInf {
	
	// 일반글
	@Resource(name="basicDao")
	private BasicDaoInf basicDao;
	
	// 파일
	@Resource(name="filesService")
	private FilesServiceInf filesService;
	
	// 댓글
	@Resource(name="repService")
	private ReplyServiceInf repService;
	
	// 이모티콘 사용자
	@Resource(name="emoUserService")
	private EmoticonUserServiceInf emoUserService;
	
	/**
	* Method : getBasicSeq
	* 최초작성일 : 2018. 10. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 일반글 시퀀스 조회
	*/
	@Override
	public int getBasicSeq() {
		return basicDao.getBasicSeq();
	}

	/**
	* Method : insertBasic
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param basicVo
	* @return
	* Method 설명 : 일반글 등록
	*/
	@Override
	public int insertBasic(BasicVO basicVo) {
		return basicDao.insertBasic(basicVo);
	}

	/**
	* Method : updateBasic
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param basicVo
	* @return
	* Method 설명 : 일반글 수정
	*/
	@Override
	public int updateBasic(BasicVO basicVo) {
		return basicDao.updateBasic(basicVo);
	}

	/**
	* Method : deleteBasic
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param basic_no
	* @return
	* Method 설명 : 일반글 삭제처리
	*/
	@Override
	public int deleteBasic(int basic_no) {
		return basicDao.deleteBasic(basic_no);
	}

	/**
	* Method : getBasicDetail
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param basic_no
	* @return
	* Method 설명 : 일반글 상세조회
	*/
	@Override
	public BasicVO getBasicDetail(int basic_no) {
		return basicDao.getBasicDetail(basic_no);
	}

	/**
	* Method : getBasicProList
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트 일반글 조회
	*/
	@Override
	public List<TimeLine> getBasicProList(Map<String, Object> paramMap) {
		
		// timeLine List
		List<TimeLine> tlBasicList = new ArrayList<TimeLine>();
		
		// 일반글 List
		List<BasicVO> basicList = basicDao.getBasicProList(paramMap);
		
		for (BasicVO basicVo : basicList) {
			
			TimeLine tl = new TimeLine();			
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "basic_no");
			paraMap.put("timeline_no", basicVo.getBasic_no());
			
			// 해당 글의 파일 List
			List<FilesVO> filesList = filesService.getFilesList(paraMap);			
			
			// 해당 글의 댓글 List
			List<Map<String, Object>> repList = repService.getRepList(paraMap);
			
			// 해당 글의 이모티콘 유저 List				
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
			
			tl.setBasicVo(basicVo);						// 일반글 Vo
			tl.setMem_id(basicVo.getMem_id());			// 작성자ID
			tl.setMem_nick(basicVo.getMem_nick());		// 작성자Nick
			tl.setTime(basicVo.getBasic_time());		// 작성일
			tl.setFix_chk(basicVo.getBasic_fix_chk()); 	// 상단고정 유무
			tl.setColl_chk(basicVo.getColl_chk());		// 담아두기 유무
			tl.setFilesList(filesList);					// 첨부파일 List
			tl.setRepList(repList);						// 댓글 List
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlBasicList.add(tl);
		}
		
		return tlBasicList;
	}

	/**
	* Method : getBasicSearchList
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 일반글 검색 조회
	*/
	@Override
	public List<BasicVO> getBasicSearchList(Map<String, String> searchMap) {
		return basicDao.getBasicSearchList(searchMap);
	}

	@Override
	public List<TimeLine> getBasicCollList(String mem_id) {
		
		// timeLine List
		List<TimeLine> tlBasicList = new ArrayList<TimeLine>();
		
		// 일반글 List
		List<BasicVO> basicCollList = basicDao.getBasicCollList(mem_id);
		
		for (BasicVO basicVo : basicCollList) {
			
			TimeLine tl = new TimeLine();			
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "basic_no");
			paraMap.put("timeline_no", basicVo.getBasic_no());
			
			// 해당 글의 파일 List
			List<FilesVO> filesList = filesService.getFilesList(paraMap);
			
			// 해당 글의 이모티콘 유저 List				
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
			
			tl.setBasicVo(basicVo);						// 일반글 Vo
			tl.setMem_id(basicVo.getMem_id());			// 작성자ID
			tl.setMem_nick(basicVo.getMem_nick());		// 작성자Nick
			tl.setTime(basicVo.getBasic_time());		// 작성일
			tl.setColl_chk(basicVo.getColl_chk());		// 담아두기 유무
			tl.setFilesList(filesList);					// 첨부파일 List
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlBasicList.add(tl);
		}
		
		return tlBasicList;
	}

	@Override
	public List<TimeLine> getMyBasicList(String mem_id) {
		
		// timeLine List
		List<TimeLine> tlBasicList = new ArrayList<TimeLine>();
		
		// 일반글 List
		List<BasicVO> myBasicList = basicDao.getMyBasicList(mem_id);
		
		for (BasicVO basicVo : myBasicList) {
			
			TimeLine tl = new TimeLine();			
			
			// paramMap
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "basic_no");
			paraMap.put("timeline_no", basicVo.getBasic_no());
			
			// 해당 글의 파일 List
			List<FilesVO> filesList = filesService.getFilesList(paraMap);
			
			// 해당 글의 이모티콘 유저 List				
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(paraMap);
			
			tl.setBasicVo(basicVo);						// 일반글 Vo
			tl.setMem_id(basicVo.getMem_id());			// 작성자ID
			tl.setMem_nick(basicVo.getMem_nick());		// 작성자Nick
			tl.setTime(basicVo.getBasic_time());		// 작성일
			tl.setColl_chk(basicVo.getColl_chk());		// 담아두기 유무
			tl.setFilesList(filesList);					// 첨부파일 List
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlBasicList.add(tl);
		}
				
		return tlBasicList;
	}
}
