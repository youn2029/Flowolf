package kr.or.dev.timeline.schedule.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.timeline.schedule.model.ScheduleVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("schdDao")
public class ScheduleDao implements ScheduleDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;	
	
	@Override
	public int insertSchd(ScheduleVO schdVo) {
		return template.insert("schd.insertSchd", schdVo);
	}

	@Override
	public int updateSchd(ScheduleVO schdVo) {
		return template.update("schd.updateSchd", schdVo);
	}

	@Override
	public int deleteSchd(int schd_no) {
		return template.update("schd.deleteSchd", schd_no);
	}

	@Override
	public ScheduleVO getSchdDetail(int schd_no) {
		return template.selectOne("schd.getSchdDetail", schd_no);
	}

	@Override
	public List<ScheduleVO> getSchdSearchList(Map<String, String> searchMap) {
		return template.selectList("schd.getSchdSearchList", searchMap);
	}

	@Override
	public List<ScheduleVO> getSchdProList(Map<String, Object> map) {
		return template.selectList("schd.getSchdProList", map);
	}

	@Override
	public List<ScheduleVO> getSchdMyList(String mem_id) {
		return template.selectList("schd.getSchdMyList", mem_id);
	}

	@Override
	public int updateFix(ScheduleVO schdVo) {
		return template.update("schd.updateFix", schdVo);
	}

	@Override
	public List<ScheduleVO> getAlarmList(Map<String, String> map) {
		return template.selectList("schd.getAlarmList", map);
	}

	@Override
	public List<ScheduleVO> getSchd_Id_Pro_no(Map<String, Object> map) {
		
		return template.selectList("schd.getSchd_Id_Pro_no", map);
	}

	@Override
	public List<ScheduleVO> getInvited_Schd(String mem_id) {
		return template.selectList("schd.getInvited_Schd", mem_id);
	}

	@Override
	public List<ScheduleVO> getInviteSchdInProeject(Map<String, Object> map) {
		return template.selectList("schd.getInviteSchdInProeject", map);
	}

	@Override
	public int getSchd_seq() {
		return template.selectOne("schd.getSchd_seq");
	}

	@Override
	public List<ScheduleVO> getSchdCollList(String mem_id) {
		return template.selectList("schd.getSchdCollList", mem_id);
	}	
	
	
}
