package kr.or.dev.timeline.vote.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.vote.model.VoteVO;

@Repository("voteDao")
public class VoteDao implements VoteDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int getVoteSeq() {
		return template.selectOne("vote.getVoteSeq");
	}
	
	@Override
	public int insertVote(VoteVO voteVo) {
		return template.insert("vote.insertVote", voteVo);
	}

	@Override
	public int updateVote(VoteVO voteVo) {
		return template.update("vote.updateVote", voteVo);
	}

	@Override
	public int deleteVote(int vote_no) {
		return template.update("vote.deleteVote", vote_no);
	}

	@Override
	public VoteVO getVoteDetail(int vote_no) {
		return template.selectOne("vote.getVoteDetail", vote_no);
	}

	@Override
	public List<VoteVO> getVoteProList(Map<String, Object> paramMap) {
		return template.selectList("vote.getVoteProList", paramMap);
	}

	@Override
	public List<VoteVO> getVoteSearchList(Map<String, String> searchMap) {
		return template.selectList("vote.getVoteSearchList", searchMap);
	}

	@Override
	public List<VoteVO> getVoteCollList(String mem_id) {
		return template.selectList("vote.getVoteCollList", mem_id);
	}

	@Override
	public List<VoteVO> getMyVoteList(String mem_id) {
		return template.selectList("vote.getMyVoteList", mem_id);
	}
}
