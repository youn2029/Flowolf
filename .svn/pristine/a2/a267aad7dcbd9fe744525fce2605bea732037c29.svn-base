package kr.or.dev.group.box.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.group.box.model.BoxVO;

@Repository("boxDao")
public class BoxDao implements BoxDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<BoxVO> getBoxMyList(String mem_id) {
		return template.selectList("box.getBoxMyList", mem_id);
	}

	@Override
	public int insertBox(BoxVO boxVo) {
		return template.insert("box.insertBox", boxVo);
	}

	@Override
	public int updateBox(BoxVO boxVo) {
		return template.update("box.updateBox", boxVo);
	}

	@Override
	public int deleteBox(int box_no) {
		return template.update("box.deleteBox", box_no);
	}

	@Override
	public BoxVO getBoxDetail(int box_no) {
		return template.selectOne("box.getBoxDetail", box_no);
	}

	@Override
	public int getBoxMaxIndex(String mem_id) {
		return template.selectOne("box.getBoxMaxIndex", mem_id);
	}

	@Override
	public List<BoxVO> getProBoxList(Map<String, Object> paramMap) {
		return template.selectList("box.getProBoxList", paramMap);
	}

}
