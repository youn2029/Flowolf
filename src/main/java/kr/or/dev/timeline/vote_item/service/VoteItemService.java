package kr.or.dev.timeline.vote_item.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.timeline.vote_item.dao.VoteItemDaoInf;
import kr.or.dev.timeline.vote_item.model.VoteItemVO;
import kr.or.dev.timeline.vote_item_user.dao.VoteItemUserDaoInf;

import org.springframework.stereotype.Service;

@Service("viService")
public class VoteItemService implements VoteItemServiceInf {
	
	@Resource(name="viDao")
	private VoteItemDaoInf viDao;
	
	@Resource(name="viuDao")
	private VoteItemUserDaoInf viuDao;

	@Override
	public int insertVi(VoteItemVO viVo) {
		return viDao.insertVi(viVo);
	}

	@Override
	public int updateVi(VoteItemVO viVo) {
		return viDao.updateVi(viVo);
	}

	@Override
	public int deleteVi(int vi_no) {
		return viDao.deleteVi(vi_no);
	}

	@Override
	public List<VoteItemVO> getViList(Map<String, Object> paramMap) {		
		return viDao.getViList(paramMap);
	}

}
