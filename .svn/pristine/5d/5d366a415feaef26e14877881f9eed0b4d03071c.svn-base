package kr.or.dev.talk.chat_user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.or.dev.talk.chat_user.dao.ChatUserDaoInf;
import kr.or.dev.talk.chat_user.model.ChatUserVO;

@Service
@Repository("chatUserService")
public class ChatUserService implements ChatUserServiceInf {
	
	@Resource(name="chatUserDao")
	private ChatUserDaoInf chatUserDao;
	
	/**
	* Method : getChatUserList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅 유저 목록 반환
	*/
	@Override
	public List<ChatUserVO> getChatUserList(int chat_no) {
		return chatUserDao.getChatUserList(chat_no);
	}

	/**
	* Method : insertChatUser
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatUserVo
	* @return
	* Method 설명 : 채팅 유저 등록
	*/
	@Override
	public int insertChatUser(ChatUserVO chatUserVo) {
		return chatUserDao.insertChatUser(chatUserVo);
	}

	/**
	* Method : deleteChatUserR
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatUserVo
	* @return
	* Method 설명 : 채팅 유저 삭제
	*/
	@Override
	public int deleteChatUserR(ChatUserVO chatUserVo) {
		return chatUserDao.deleteChatUserR(chatUserVo);
	}

}
