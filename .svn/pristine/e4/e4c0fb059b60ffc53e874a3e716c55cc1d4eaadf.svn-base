package kr.or.dev.timeline.vote_item.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.vote_item.model.VoteItemVO;

@Repository("viDao")
public class VoteItemDao implements VoteItemDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int insertVi(VoteItemVO viVo) {
		return template.insert("voteItem.insertVi", viVo);
	}

	@Override
	public int updateVi(VoteItemVO viVo) {
		return template.update("voteItem.updateVi", viVo);
	}

	@Override
	public int deleteVi(int vi_no) {
		return template.update("voteItem.deleteVi", vi_no);
	}

	@Override
	public List<VoteItemVO> getViList(Map<String, Object> paramMap) {
		return template.selectList("voteItem.getViList", paramMap);
	}

}
