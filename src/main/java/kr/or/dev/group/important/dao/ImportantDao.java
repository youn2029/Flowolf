package kr.or.dev.group.important.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.group.important.model.ImportantVO;
import kr.or.dev.group.project.model.ProjectVO;

@Repository("impDao")
public class ImportantDao implements ImportantDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<ProjectVO> getImpProList(String mem_id) {
		return template.selectList("imp.getImpProList", mem_id);
	}

	@Override
	public int insertImp(ImportantVO impVo) {
		return template.insert("imp.insertImp", impVo);
	}

	@Override
	public int deleteImpR(ImportantVO impVo) {
		return template.delete("imp.deleteImpR", impVo);
	}

}
