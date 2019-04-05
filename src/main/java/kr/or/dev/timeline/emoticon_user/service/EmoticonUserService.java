package kr.or.dev.timeline.emoticon_user.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.timeline.emoticon_user.dao.EmoticonUserDaoInf;
import kr.or.dev.timeline.emoticon_user.model.EmoticonUserVO;

@Service("emoUserService")
public class EmoticonUserService implements EmoticonUserServiceInf {

	@Resource(name="emoUserDao")
	private EmoticonUserDaoInf emoUserDao;
	
	@Override
	public int insertEmoUser(Map<String, Object> paramMap) {
		return emoUserDao.insertEmoUser(paramMap);
	}

	@Override
	public int deleteEmoUserR(int emo_user_no) {
		return emoUserDao.deleteEmoUserR(emo_user_no);
	}

	@Override
	public List<EmoticonUserVO> getEmoUserList(Map<String, Object> paramMap) {
		return emoUserDao.getEmoUserList(paramMap);
	}

	@Override
	public int getEmoUserSeq() {
		return emoUserDao.getEmoUserSeq();
	}

}
