package kr.or.dev.timeline.schedule.service;

import java.util.List;
import java.util.Map;

import kr.or.dev.timeline.TimeLine;
import kr.or.dev.timeline.schedule.model.ScheduleVO;

public interface ScheduleServiceInf {
	
	/**
	* Method : insertSchd
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param schdVo
	* @return
	* Method 설명 : 일정 등록
	*/
	int insertSchd(ScheduleVO schdVo);	
	
	/**
	* Method : updateSchd
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param schdVO
	* @return
	* Method 설명 : 일정 수정
	*/
	int updateSchd(ScheduleVO schdVo);	
	
	/**
	* Method : updateFix
	* 최초작성일 : 2018. 9. 7.
	* 작성자 : PC10
	* 변경이력 :
	* @param schd_no
	* @return
	* Method 설명 : schd_no로 해당 schedule의 고정여부 수정
	*/
	int updateFix(ScheduleVO schdVo);	
	
	/**
	* Method : deleteSchd
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param schd_no
	* @return
	* Method 설명 : 일정 삭제처리
	*/
	int deleteSchd(int schd_no);
	
	/**
	* Method : getSchdDetail
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param schd_no
	* @return
	* Method 설명 : 일정 상세 조회
	*/
	ScheduleVO getSchdDetail(int schd_no);
	
	/**
	* Method : getSchdSearchList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 일정 검색 조회
	*/
	List<ScheduleVO> getSchdSearchList(Map<String, String> searchMap);
	
	/**
	 * Method : getSchdProList
	 * 최초작성일 : 2018. 8. 30.
	 * 작성자 : 윤성호
	 * 변경이력 :
	 * @param pro_no
	 * @return
	 * Method 설명 : 프로젝트의 일정 조회
	 */
	List<TimeLine> getSchdProList(Map<String, Object> map);
	
	/**
	* Method : getSchdMyList
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원이 등록한 일정 조회
	*/
	List<ScheduleVO> getSchdMyList(String mem_id);	

	/**
	* Method : getAlarmList
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김진영
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 해당 회원이 등록한 알람을 찾아 ScheduleVO 리스트로 반환하는 메서드
	*/
	List<ScheduleVO> getAlarmList(Map<String, String> map);	
	
	/**
	* Method : getSchd_Id_Pro_no
	* 최초작성일 : 2018. 9. 27.
	* 작성자 : 김진영
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 회원id, pro_no를 통해 일정 가져오기
	*/
	List<ScheduleVO> getSchd_Id_Pro_no(Map<String, Object> map);	
	
	/**
	* Method : getInvited_Schd
	* 최초작성일 : 2018. 9. 28.
	* 작성자 : 김진영
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 해당회원이 초대받은 모든 schedule 가져오기
	*/
	List<ScheduleVO> getInvited_Schd(String mem_id);	
	
	/**
	* Method : groupCalendarList
	* 최초작성일 : 2018. 9. 28.
	* 작성자 : 김진영
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 모든 일정을 가져와 Map에 저장하기(Service단에서)
	*/
	public Map<String, Object> groupCalendarList(String mem_id);

	/**
	* Method : projectCalendarList
	* 최초작성일 : 2018. 9. 29.
	* 작성자 : 
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 해당 프로젝트의 모든 일정을 가져와 Map에 저장하기(Service단에서)
	*/
	Map<String, Object> projectCalendarList(String mem_id, int pro_no);	
	
	int getSchd_seq();
	
	/**
	* Method : getSchdCollList
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원의 담아둔 일정글 리스트 조회
	*/
	List<TimeLine> getSchdCollList(String mem_id);
	
	/**
	* Method : getMyVoteList
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원이 작성한 투표글 리스트 조회
	*/
	List<TimeLine> getMySchdList(String mem_id);
}

