package kr.or.dev.timeline.schedule.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.common.Format;
import kr.or.dev.files.model.FilesVO;
import kr.or.dev.files.service.FilesServiceInf;
import kr.or.dev.timeline.TimeLine;
import kr.or.dev.timeline.emoticon_user.model.EmoticonUserVO;
import kr.or.dev.timeline.emoticon_user.service.EmoticonUserServiceInf;
import kr.or.dev.timeline.reply.service.ReplyServiceInf;
import kr.or.dev.timeline.schedule.dao.ScheduleDaoInf;
import kr.or.dev.timeline.schedule.model.ScheduleVO;

import org.springframework.stereotype.Service;

@Service("scheduleService")
public class ScheduleService implements ScheduleServiceInf{

	@Resource(name="schdDao")
	private ScheduleDaoInf schdDao;
	
	// 파일
	@Resource(name="filesService")
	private FilesServiceInf filesService;
	
	// 댓글
	@Resource(name="repService")
	private ReplyServiceInf repService;
	
	// 이모티콘 사용자
	@Resource(name="emoUserService")
	private EmoticonUserServiceInf emoUserService;

	@Override
	public List<TimeLine> getSchdProList(Map<String, Object> paramMap) {
		
		// timeLime List
		List<TimeLine> tlSchdList = new ArrayList<TimeLine>();
		
		// 일반글 List
		List<ScheduleVO> schdList = schdDao.getSchdProList(paramMap);
		
		for(ScheduleVO schdVo : schdList){
			
			String minute = "";
			try {
				minute = Format.dateCal(schdVo.getSchd_start_time(), schdVo.getSchd_alarm());
			} catch (ParseException e) {
			}
			schdVo.setMinute(minute);
			
			TimeLine tl = new TimeLine();
			
			// map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("timeline_col", "schd_no");
			map.put("timeline_no", schdVo.getSchd_no());
			
			// 해당 글의 댓글 List
			List<Map<String, Object>> repList = repService.getRepList(map);
			
			// 해당 글의 이모티콘 유저 List
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(map);
			
			tl.setSchdVo(schdVo);						// 일정 Vo
			tl.setMem_id(schdVo.getMem_id());			// 작성자ID
			tl.setMem_nick(schdVo.getMem_nick());		// 작성자Nick
			tl.setTime(schdVo.getSchd_time());			// 작성일
			tl.setFix_chk(schdVo.getSchd_fix_chk());	// 고정유무
			tl.setColl_chk(schdVo.getColl_chk());		// 담아두기 유무
			tl.setRepList(repList);						// 댓글 List
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlSchdList.add(tl);			
		}		
		
		return tlSchdList;
	}
	
	public static String formatter(String stringFormatMinute) {
		String date = "";
		if(stringFormatMinute=="0"){
			date = null;
		}else if(stringFormatMinute=="10"){
			date = "10 분";
		}else if(stringFormatMinute=="30"){
			date = "30분";
		}else if(stringFormatMinute=="60"){
			date = "1시간";
		}else if(stringFormatMinute=="120"){
			date = "2시간";
		}else if(stringFormatMinute=="180"){
			date = "3시간";
		}else if(stringFormatMinute=="1440"){
			date = "1일";
		}else if(stringFormatMinute=="2880"){
			date = "2일";
		}else if(stringFormatMinute=="10080"){
			date = "3일";
		}
	
		return date;
	}

	@Override
	public int insertSchd(ScheduleVO schdVo) {
		return schdDao.insertSchd(schdVo);
	}

	@Override
	public int updateSchd(ScheduleVO schdVo) {
		return schdDao.updateSchd(schdVo);
	}

	@Override
	public int deleteSchd(int schd_no) {
		return schdDao.deleteSchd(schd_no);
	}

	@Override
	public ScheduleVO getSchdDetail(int schd_no) {
		return schdDao.getSchdDetail(schd_no);
	}

	@Override
	public int updateFix(ScheduleVO schdVo) {
		return schdDao.updateFix(schdVo);
	}

	@Override
	public List<ScheduleVO> getSchdSearchList(Map<String, String> searchMap) {
		return schdDao.getSchdSearchList(searchMap);
	}

	@Override
	public List<ScheduleVO> getSchdMyList(String mem_id) {
		return schdDao.getSchdMyList(mem_id);
	}
	
	@Override
	public List<ScheduleVO> getAlarmList(Map<String, String> map) {
		return schdDao.getAlarmList(map);
	}

	@Override
	public List<ScheduleVO> getSchd_Id_Pro_no(Map<String, Object> map) {
		return schdDao.getSchd_Id_Pro_no(map);
	}

	@Override
	public List<ScheduleVO> getInvited_Schd(String mem_id) {
		return schdDao.getInvited_Schd(mem_id);
	}
	
	
	//나의 일정과, 나를 초대한 일정을 반환하는 메서드
	@Override
	public Map<String, Object> groupCalendarList(String mem_id){
		List<ScheduleVO> mySchedule = schdDao.getSchdMyList(mem_id);
		List<ScheduleVO> invitedSchd = schdDao.getInvited_Schd(mem_id);
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("mySchedule", mySchedule);
		returnMap.put("invitedSchd", invitedSchd);
		
		return returnMap;
	}

	@Override
	public Map<String, Object> projectCalendarList(String mem_id, int pro_no) {
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("mem_id", mem_id);
			map.put("pro_no", pro_no);
			List<ScheduleVO> mySchedule = schdDao.getSchd_Id_Pro_no(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("mem_id", mem_id);
			map2.put("pro_no", pro_no);
		List<ScheduleVO> invitedSchd = schdDao.getInviteSchdInProeject(map2); 
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("mySchedule", mySchedule);
		returnMap.put("invitedSchd", invitedSchd);
		return returnMap;
	}

	@Override
	public int getSchd_seq() {
		return schdDao.getSchd_seq();
	}

	@Override
	public List<TimeLine> getSchdCollList(String mem_id) {
		
		// timeLime List
		List<TimeLine> tlSchdList = new ArrayList<TimeLine>();
		
		// 일반글 List
		List<ScheduleVO> schdCollList = schdDao.getSchdCollList(mem_id);
		
		for(ScheduleVO schdVo : schdCollList){
			
			String minute = "";
			try {
				minute = Format.dateCal(schdVo.getSchd_start_time(), schdVo.getSchd_alarm());
			} catch (ParseException e) {
			}
			schdVo.setMinute(minute);
			
			TimeLine tl = new TimeLine();
			
			// map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("timeline_col", "schd_no");
			map.put("timeline_no", schdVo.getSchd_no());
			
			// 해당 글의 이모티콘 유저 List
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(map);
			
			tl.setSchdVo(schdVo);						// 일정 Vo
			tl.setMem_id(schdVo.getMem_id());			// 작성자ID
			tl.setMem_nick(schdVo.getMem_nick());		// 작성자Nick
			tl.setTime(schdVo.getSchd_time());			// 작성일
			tl.setFix_chk(schdVo.getSchd_fix_chk());	// 고정유무
			tl.setColl_chk(schdVo.getColl_chk());		// 담아두기 유무
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlSchdList.add(tl);			
		}	
		
		return tlSchdList;
	}

	@Override
	public List<TimeLine> getMySchdList(String mem_id) {
		
		// timeLime List
		List<TimeLine> tlSchdList = new ArrayList<TimeLine>();
		
		// 일반글 List
		List<ScheduleVO> mySchdList = schdDao.getSchdMyList(mem_id);
		
		for(ScheduleVO schdVo : mySchdList){
			
			String minute = "";
			try {
				minute = Format.dateCal(schdVo.getSchd_start_time(), schdVo.getSchd_alarm());
			} catch (ParseException e) {
			}
			schdVo.setMinute(minute);
			
			TimeLine tl = new TimeLine();
			
			// map
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("timeline_col", "schd_no");
			map.put("timeline_no", schdVo.getSchd_no());
			
			// 해당 글의 이모티콘 유저 List
			List<EmoticonUserVO> emoUserList = emoUserService.getEmoUserList(map);
			
			tl.setSchdVo(schdVo);						// 일정 Vo
			tl.setMem_id(schdVo.getMem_id());			// 작성자ID
			tl.setMem_nick(schdVo.getMem_nick());		// 작성자Nick
			tl.setTime(schdVo.getSchd_time());			// 작성일
			tl.setFix_chk(schdVo.getSchd_fix_chk());	// 고정유무
			tl.setColl_chk(schdVo.getColl_chk());		// 담아두기 유무
			tl.setEmoUserList(emoUserList);				// 이모티콘 유저 List
			
			tlSchdList.add(tl);			
		}
		
		return tlSchdList;
	}

}
