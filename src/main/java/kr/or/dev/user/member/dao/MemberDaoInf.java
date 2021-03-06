package kr.or.dev.user.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.dev.user.member.model.MemberVO;

public interface MemberDaoInf {
	
	/**
	 * Method : insertMem
	 * 최초작성일 : 2018. 8. 28.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param memVo
	 * @return
	 * Method 설명 : 회원객체를 매개변수로 받아서 회원의 정보를 생성한다.
	 */
	int insertMem(MemberVO memVo);
	
	/**
	 * Method : updateMem
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param memVo
	 * @return
	 * Method 설명 : 회원객체를 매개변수로 받아서 회원의 정보를 수정한다. 
	 */
	int updateMem(MemberVO memVo);
	
	/**
	 * Method : deleteMem
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 회원ID를 매개변수로 받아서 회원의 활성화유무를 수정한다.
	 */
	int deleteMem(String mem_id);
	
	/**
	 * Method : getMemDetail
	 * 최초작성일 : 2018. 8. 28.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 이메일로 로그인한 회원의 아이디를 매개변수로 받아 회원의 정보를 반환한다.
	 */
	MemberVO getMemDetail(String mem_id);

	/**
	 * Method : chkMemId
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_id
	 * @return
	 * Method 설명 : 이메일(ID)를 매개변수로 받아서 int값을 반환하여 중복검사를 한다.  
	 */
	int chkMemId(String mem_id);
	
	/**
	 * Method : chkMemNick
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param mem_nick
	 * @return
	 * Method 설명 : 닉네임을 매개변수로 받아서 int값을 반환하여 중복검사를 한다.
	 */
	int chkMemNick(String mem_nick);
	
	/**
	 * Method : getMemAllList
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 : 
	 * @param mem_id
	 * @return
	 * Method 설명 : 전체회원 리스트를 반환한다.(관리자 본인 제외)
	 */
	List<MemberVO> getMemAllList(String mem_id);
	
	/**
	 * Method : getMemSearchList
	 * 최초작성일 : 2018. 8. 29.
	 * 작성자 : 노미소
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : Email(ID),이름,닉네임을 받아서 검색 후 회원의 정보를 반환한다.(관리자)
	 */
	List<MemberVO> getMemSearchList(Map<String, String> map);  
	
	/**
	* Method : findId
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param map (이름, 핸드폰번호)
	* @return
	* Method 설명 : 아이디 조회
	*/
	String findId(Map<String, String> map);
	
	/**
	* Method : getMemChkCnt
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 비밀번호 찾기에서 해당 회원이 있는지 유무 체크
	*/
	String getMemChk(Map<String, String> map);
	
//	----------------  관리자  --------------------
	
	/**
	* Method : getMemPageAllList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 전체 회원 페이지에 따른 조회
	*/
	List<MemberVO> getMemPageAllList(Map<String, Object> paramMap);
	
	/**
	* Method : getMemAllCnt
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 총 회원 수 조회
	*/
	int getMemAllCnt();
	
	/**
	* Method : getMemHowjoinCnt
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_howjoin
	* @return
	* Method 설명 : 가입방법별 회원수 조회
	*/
	int getMemHowjoinCnt(String mem_howjoin);	
	
}
