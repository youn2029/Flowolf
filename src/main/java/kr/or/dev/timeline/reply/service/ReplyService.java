package kr.or.dev.timeline.reply.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.files.model.FilesVO;
import kr.or.dev.files.service.FilesServiceInf;
import kr.or.dev.timeline.reply.dao.ReplyDaoInf;
import kr.or.dev.timeline.reply.model.ReplyVO;

import org.springframework.stereotype.Service;

@Service("repService")
public class ReplyService implements ReplyServiceInf {
	
	// 댓글
	@Resource(name="repDao")
	private ReplyDaoInf repDao;
	
	// 첨부파일
	@Resource(name="filesService")
	private FilesServiceInf filesService;

	@Override
	public int insertRep(Map<String, Object> paramMap) {
		return repDao.insertRep(paramMap);
	}

	@Override
	public int updateRep(ReplyVO repVo) {
		return repDao.updateRep(repVo);
	}

	@Override
	public int deleteRep(int rep_no) {
		return repDao.deleteRep(rep_no);
	}

	@Override
	public List<Map<String, Object>> getRepList(Map<String, Object> paramMap) {
		
		List<Map<String, Object>> repList = new ArrayList<Map<String,Object>>();
		
		// 해당 글의 댓글 List
		List<ReplyVO> replist = repDao.getRepList(paramMap);
		
		for (ReplyVO repVo : replist) {
			
			// repMap (댓글과 댓글에 해당하는 첨부파일)
			Map<String, Object> repMap = new HashMap<String, Object>();
			
			// 해당 댓글의 조회를 위한 파라미터Map
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("timeline_col", "rep_no");
			paraMap.put("timeline_no", repVo.getRep_no());			
			
			// 첨부파일 List
			List<FilesVO> filesList = filesService.getFilesList(paraMap);
			
			repMap.put("repVo", repVo);
			repMap.put("filesList", filesList);
			
			repList.add(repMap);
		}
		
		return repList;
	}

	@Override
	public int getRepSeq() {
		return repDao.getRepSeq();
	}

}
