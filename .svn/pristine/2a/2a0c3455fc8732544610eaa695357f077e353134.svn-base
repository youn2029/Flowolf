package kr.or.dev.timeline.vote_item_user.service;

import javax.annotation.Resource;

import kr.or.dev.timeline.vote_item_user.dao.VoteItemUserDaoInf;
import kr.or.dev.timeline.vote_item_user.model.VoteItemUserVO;

import org.springframework.stereotype.Service;

@Service("viuService")
public class VoteItemUserService implements VoteItemUserServiceInf {
	
	@Resource(name="viuDao")
	private VoteItemUserDaoInf viuDao;

	@Override
	public int insertViu(VoteItemUserVO viuVo) {
		return viuDao.insertViu(viuVo);
	}

	@Override
	public int deleteViu(VoteItemUserVO viuVo) {
		return viuDao.deleteViu(viuVo);
	}
}
