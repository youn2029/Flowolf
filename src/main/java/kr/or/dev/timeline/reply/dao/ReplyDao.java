package kr.or.dev.timeline.reply.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.reply.model.ReplyVO;

@Repository("repDao")
public class ReplyDao implements ReplyDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int insertRep(Map<String, Object> paramMap) {
		return template.insert("rep.insertRep", paramMap);
	}

	@Override
	public int updateRep(ReplyVO repVo) {
		return template.update("rep.updateRep", repVo);
	}

	@Override
	public int deleteRep(int rep_no) {
		return template.update("rep.deleteRep", rep_no);
	}

	@Override
	public List<ReplyVO> getRepList(Map<String, Object> paramMap) {
		return template.selectList("rep.getRepList", paramMap);
	}

	@Override
	public int getRepSeq() {
		return template.selectOne("rep.getRepSeq");
	}

}
