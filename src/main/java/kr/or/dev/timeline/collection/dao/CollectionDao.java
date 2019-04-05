package kr.or.dev.timeline.collection.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.collection.model.CollectionVO;

@Repository("collDao")
public class CollectionDao implements CollectionDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int getCollSeq() {
		return template.selectOne("coll.getCollSeq");
	}
	
	@Override
	public int insertColl(Map<String, Object> paramMap) {
		return template.insert("coll.insertColl", paramMap);
	}

	@Override
	public int deleteCollR(int coll_no) {
		return template.delete("coll.deleteCollR", coll_no);
	}

	@Override
	public List<CollectionVO> getCollMyList(String mem_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
