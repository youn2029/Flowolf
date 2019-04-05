package kr.or.dev.group.box_project.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mvel2.ast.WithNode.ParmValuePair;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.group.box_project.model.BoxProjectVO;
import kr.or.dev.group.project.model.ProjectVO;

@Repository("boxProDao")
public class BoxProjectDao implements BoxProjectDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int insertBoxPro(BoxProjectVO boxProVo) {
		return template.insert("boxPro.insertBoxPro", boxProVo);
	}

	@Override
	public int deleteBoxProR(BoxProjectVO boxProVo) {
		return template.delete("boxPro.deleteBoxProR", boxProVo);
	}

	@Override
	public List<ProjectVO> getBoxProList(Map<String, Object> paramMap) {
		return template.selectList("boxPro.getBoxProList", paramMap);
	}

}
