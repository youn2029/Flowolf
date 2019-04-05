package kr.or.dev.group.box_project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.box_project.dao.BoxProjectDaoInf;
import kr.or.dev.group.box_project.model.BoxProjectVO;
import kr.or.dev.group.project.model.ProjectVO;
import kr.or.dev.group.project_user.dao.ProjectUserDaoInf;
import kr.or.dev.group.project_user.model.ProjectUserVO;

import org.springframework.stereotype.Service;

@Service("boxProService")
public class BoxProjectService implements BoxProjectServiceInf {
	
	// boxProjectDao
	@Resource(name="boxProDao")
	private BoxProjectDaoInf boxProDao;
	
	// ProjectUserDao
	@Resource(name="proUserDao")
	private ProjectUserDaoInf proUserDao;

	@Override
	public int insertBoxPro(BoxProjectVO boxProVo) {
		return boxProDao.insertBoxPro(boxProVo);
	}

	@Override
	public int deleteBoxProR(BoxProjectVO boxProVo) {
		return boxProDao.deleteBoxProR(boxProVo);
	}

	@Override
	public List<Map<String, Object>> getBoxProList(Map<String, Object> paramMap) {
				
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		
		List<ProjectVO> myImpProList = boxProDao.getBoxProList(paramMap);
		
		for (ProjectVO proVo : myImpProList) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			// 프로젝트 vo
			map.put("proVo", proVo);
			
			// 프로젝트 참여자 List
			List<ProjectUserVO> proUserList = proUserDao.getProUserList(proVo.getPro_no());
			map.put("proUserList", proUserList);
			
			resultList.add(map);			
		}
		
		return resultList;		
	}

}
