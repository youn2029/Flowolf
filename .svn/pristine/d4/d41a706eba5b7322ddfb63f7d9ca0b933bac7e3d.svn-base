package kr.or.dev.timeline.emoticon.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.timeline.emoticon.dao.EmoticonDaoInf;
import kr.or.dev.timeline.emoticon.model.EmoticonVO;

@Service("emoService")
public class EmoticonService implements EmoticonServiceInf {
	
	@Resource(name="emoDao")
	private EmoticonDaoInf emoDao;

	@Override
	public List<EmoticonVO> getEmoAllList() {
		return emoDao.getEmoAllList();
	}

	@Override
	public EmoticonVO getEmoDetail(int emo_no) {
		return emoDao.getEmoDetail(emo_no);
	}

}
