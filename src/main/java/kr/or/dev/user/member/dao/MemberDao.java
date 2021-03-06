package kr.or.dev.user.member.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.user.member.model.MemberVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("memDao")
public class MemberDao implements MemberDaoInf {
	
	// SqlSessionTemplate => dao에 쓰던 new~를 줄여서 보여준다.
	// <<coding을 줄여준다.>>
	// (jsp사용법)
	// 1.open session 으로 열고 
	// 2.session.commit 해준다.
	// 3.session.close 닫고
	
	// template=> opensession
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	 * Method : insertMem
	 * 최초작성일 : 2018. 8. 28.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param memVo
	 * @return
	 * Method 설명 : 회원객체를 매개변수로 받아서 회원의 정보를 생성한다.
	 */
	@Override
	public int insertMem(MemberVO memVo) {
		int cnt = template.insert("mem.insertMem", memVo);
		return cnt;
	}
	
	/**
	 * Method : updateMem
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param memVo
	 * @return
	 * Method 설명 : 회원객체를 매개변수로 받아서 회원의 정보를 수정한다. 
	 */
	@Override
	public int updateMem(MemberVO memVo) {
		int cnt = template.update("mem.updateMem", memVo);
		return cnt;
	}
	
	/**
	 * Method : deleteMem
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 회원ID를 매개변수로 받아서 회원을 활성화유무를 수정한다.
	 */
	@Override
	public int deleteMem(String mem_id) {
		int cnt = template.update("mem.deleteMem", mem_id);
		return cnt;
	}
	
	/**
	 * Method : getMemDetail
	 * 최초작성일 : 2018. 8. 28.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 이메일로 로그인한 회원의 이메일을 매개변수로 받아 사용자의 정보 반환한다.
	 */
	@Override
	public MemberVO getMemDetail(String mem_id) {
		
		//방법1
		MemberVO getMemDetail = template.selectOne("mem.getMemDetail", mem_id);// member.xml에서 namespace.id를 가져 온것.
		return getMemDetail;
		
		//방법2
	    //return template.selectOne("member.selectMember", mem_id);
	  
	}
	
	/**
	 * Method : chkMemId
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 이메일(ID)를 매개변수로 받아서 int값을 반환하여 중복검사를 한다.  
	 */
	@Override
	public int chkMemId(String mem_id) {
		int cnt = template.selectOne("mem.chkMemId",mem_id);
		return cnt;
	}

	/**
	 * Method : chkMemNick
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_nick
	 * @return
	 * Method 설명 : 닉네임을 매개변수로 받아서 int값을 반환하여 중복검사를 한다.
	 */
	@Override
	public int chkMemNick(String mem_nick) {
		int cnt = template.selectOne("mem.chkMemNick",mem_nick);
		return cnt;
	}	
	
	/**
	 * Method : getMemAllList
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 전체회원 리스트를 반환한다.(관리자 본인 제외) 
	 */
	@Override
	public List<MemberVO> getMemAllList(String mem_id) {
		List<MemberVO> getMemAllList = template.selectList("mem.getMemAllList", mem_id);
		return getMemAllList;
	}	
	
	/**
	 * Method : getMemSearchList
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : Email(ID),이름,닉네임을 받아서 검색 후 회원의 정보를 반환한다.(관리자)
	 */
	@Override
	public List<MemberVO> getMemSearchList(Map<String, String> map) {
		List<MemberVO> getMemSearchList = template.selectList("mem.getMemSearchList", map);
		return getMemSearchList;
	}

	@Override
	public String findId(Map<String, String> map) {
		return template.selectOne("mem.findId", map);
	}

	@Override 
	public String getMemChk(Map<String, String> map) {
		return template.selectOne("mem.getMemChk", map);
	}

//	----------------  관리자  --------------------	
	
	@Override
	public int getMemAllCnt() {
		return template.selectOne("mem.getMemAllCnt");
	}

	@Override
	public int getMemHowjoinCnt(String mem_howjoin) {
		return template.selectOne("mem.getMemHowjoinCnt", mem_howjoin);
	}

	@Override
	public List<MemberVO> getMemPageAllList(Map<String, Object> paramMap) {
		return template.selectList("mem.getMemPageAllList", paramMap);
	}
}
