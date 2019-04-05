package kr.or.dev.group.project.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.project.model.ProjectVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("proDao")
public class ProjectDao implements ProjectDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int getProSeq() {
		return template.selectOne("pro.getProSeq");
	}

	@Override
	public int insertPro(ProjectVO proVo) {
		return template.insert("pro.insertPro", proVo);
	}

	@Override
	public int updatePro(ProjectVO proVo) {
		return template.update("pro.updatePro", proVo);
	}

	@Override
	public int deletePro(int pro_no) {
		return template.update("pro.deletePro", pro_no);
	}

	@Override
	public ProjectVO getProDetail(Map<String, Object> paramMap) {
		return template.selectOne("pro.getProDetail", paramMap);
	}

	@Override
	public List<ProjectVO> getProPageAllList(Map<String, Object> paramMap) {
		return template.selectList("pro.getProPageAllList", paramMap);
	}

	@Override
	public int getProKindCnt(int kind_no) {
		return template.selectOne("pro.getProKindCnt", kind_no);
	}

	@Override
	public List<ProjectVO> getProSearchList(Map<String, String> searchMap) {
		return template.selectList("pro.getProSearchList", searchMap);
	}

	@Override
	public List<ProjectVO> getProAllList() {
		return template.selectList("pro.getProAllList");
	}

	@Override
	public int getProMonthCnt(String pro_date) {
		return template.selectOne("pro.getProMonthCnt", pro_date);
	}

}
