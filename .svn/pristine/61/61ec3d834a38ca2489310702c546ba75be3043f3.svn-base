package kr.or.dev.timeline.vote_item_user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.vote_item_user.model.VoteItemUserVO;

@Repository("viuDao")
public class VoteItemUserDao implements VoteItemUserDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int insertViu(VoteItemUserVO viuVo) {
		return template.insert("voteItemUser.insertViu", viuVo);
	}

	@Override
	public int deleteViu(VoteItemUserVO viuVo) {
		return template.delete("voteItemUser.deleteViu", viuVo);
	}

	@Override
	public List<VoteItemUserVO> getViuList(int vi_no) {
		return template.selectList("voteItemUser.getViuList", vi_no);
	}

}
