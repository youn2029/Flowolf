package kr.or.dev.group.important.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.important.dao.ImportantDaoInf;
import kr.or.dev.group.important.model.ImportantVO;
import kr.or.dev.group.project.model.ProjectVO;
import kr.or.dev.group.project_user.dao.ProjectUserDaoInf;
import kr.or.dev.group.project_user.model.ProjectUserVO;

import org.springframework.stereotype.Service;

@Service("impService")
public class ImportantService implements ImportantServiceInf {
	
	// importantDao
	@Resource(name="impDao")
	private ImportantDaoInf impDao;
	
	// projectUserDao
	@Resource(name="proUserDao")
	private ProjectUserDaoInf proUserDao;

	@Override
	public List<Map<String, Object>> getImpProList(String mem_id) {
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		
		List<ProjectVO> myImpProList = impDao.getImpProList(mem_id);
		
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

	@Override
	public int insertImp(ImportantVO impVo) {
		return impDao.insertImp(impVo);
	}

	@Override
	public int deleteImpR(ImportantVO impVo) {
		return impDao.deleteImpR(impVo);
	}

}
