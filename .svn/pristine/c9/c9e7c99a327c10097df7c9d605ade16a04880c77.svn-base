package kr.or.dev.timeline.emoticon.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.emoticon.model.EmoticonVO;

@Repository("emoDao")
public class EmoticonDao implements EmoticonDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<EmoticonVO> getEmoAllList() {
		return template.selectList("emo.getEmoAllList");
	}

	@Override
	public EmoticonVO getEmoDetail(int emo_no) {
		return template.selectOne("emo.getEmoDetail", emo_no);
	}

}
