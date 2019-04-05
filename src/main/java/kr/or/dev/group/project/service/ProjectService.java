package kr.or.dev.group.project.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.project.dao.ProjectDaoInf;
import kr.or.dev.group.project.model.ProjectVO;

import org.springframework.stereotype.Service;

@Service("proService")
public class ProjectService implements ProjectServiceInf {
	
	@Resource(name="proDao")
	private ProjectDaoInf proDao;

	@Override
	public int getProSeq() {
		return proDao.getProSeq();
	}

	@Override
	public int insertPro(ProjectVO proVo) {		
		return proDao.insertPro(proVo);
	}

	@Override
	public int updatePro(ProjectVO proVo) {
		return proDao.updatePro(proVo);
	}

	@Override
	public int deletePro(int pro_no) {
		return proDao.deletePro(pro_no);
	}

	@Override
	public ProjectVO getProDetail(Map<String, Object> paramMap) {
		return proDao.getProDetail(paramMap);
	}
	
	@Override
	public List<ProjectVO> getProPageAllList(Map<String, Object> paramMap) {
		return proDao.getProPageAllList(paramMap);
	}

	@Override
	public int getProKindCnt(int kind_no) {
		return proDao.getProKindCnt(kind_no);
	}

	@Override
	public List<ProjectVO> getProSearchList(Map<String, String> searchMap) {
		return proDao.getProSearchList(searchMap);
	}

	@Override
	public List<ProjectVO> getProAllList() {
		return proDao.getProAllList();
	}

	@Override
	public int getProMonthCnt(String pro_date) {
		return proDao.getProMonthCnt(pro_date);
	}

}
