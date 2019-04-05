package kr.or.dev.user.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.user.member.dao.MemberDaoInf;
import kr.or.dev.user.member.model.MemberVO;

@Service("memService")
public class MemberService implements MemberServiceInf {

	@Resource(name="memDao")
	private MemberDaoInf memDao;

	@Override
	public int insertMem(MemberVO memVo) {
		return memDao.insertMem(memVo);
	}

	@Override
	public int updateMem(MemberVO memVo) {
		return memDao.updateMem(memVo);
	}

	@Override
	public int deleteMem(String mem_id) {
		return memDao.deleteMem(mem_id);
	}

	@Override
	public MemberVO getMemDetail(String mem_id) {
		return memDao.getMemDetail(mem_id);
	}

	@Override
	public int chkMemId(String mem_id) {
		return memDao.chkMemId(mem_id);
	}

	@Override
	public int chkMemNick(String mem_nick) {
		return memDao.chkMemNick(mem_nick);
	}

	@Override
	public List<MemberVO> getMemAllList(String mem_id) {
		return memDao.getMemAllList(mem_id);
	}

	@Override
	public List<MemberVO> getMemSearchList(Map<String, String> map) {
		return memDao.getMemSearchList(map);
	}

	@Override
	public String findId(Map<String, String> map) {
		return memDao.findId(map);
	}

	@Override
	public String getMemChk(Map<String, String> map) {
		return memDao.getMemChk(map);
	}
	
//	----------------  관리자  --------------------
	
	@Override
	public int getMemAllCnt() {
		return memDao.getMemAllCnt();
	}

	@Override
	public int getMemHowjoinCnt(String mem_howjoin) {
		return memDao.getMemHowjoinCnt(mem_howjoin);
	}

	@Override
	public List<MemberVO> getMemPageAllList(Map<String, Object> paramMap) {
		return memDao.getMemPageAllList(paramMap);
	}	

}
