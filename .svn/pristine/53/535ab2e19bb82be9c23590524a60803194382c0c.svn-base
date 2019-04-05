package kr.or.dev.talk.chat_user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.talk.chat_user.model.ChatUserVO;

@Repository("chatUserDao")
public class ChatUserDao implements ChatUserDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	
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
		return template.selectList("chatUser.getChatUserList", chat_no);
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
		return template.insert("chatUser.insertChatUser", chatUserVo);
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
		return template.delete("chatUser.deleteChatUserR", chatUserVo);
	}

}
