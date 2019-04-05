package kr.or.dev.talk.chat_con.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.talk.chat_con.dao.ChatConDaoInf;
import kr.or.dev.talk.chat_con.model.ChatConVO;

@Service(value="chatConService")
public class ChatConService implements ChatConServiceInf{
	
	@Resource(name="chatConDao")
	private ChatConDaoInf chatConDao;

	/**
	* Method : getChatConList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅 내용 반환
	*/
	@Override
	public List<ChatConVO> getChatConList(int chat_no) {
		return chatConDao.getChatConList(chat_no);
	}

	/**
	* Method : insertChatCon
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatConVo
	* @return
	* Method 설명 : 채팅 내용 등록
	*/
	@Override
	public int insertChatCon(ChatConVO chatConVo) {
		return chatConDao.insertChatCon(chatConVo);
	}

	/**
	* Method : getChatConSeq
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 채팅 내용 시퀀스 조회
	*/
	@Override
	public int getChatConSeq() {
		return chatConDao.getChatConSeq();
	}

	/**
	* Method : getChatCon
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_con_no
	* @return
	* Method 설명 : 채팅 내용 상세 조회
	*/
	@Override
	public ChatConVO getChatCon(int chat_con_no) {
		return chatConDao.getChatCon(chat_con_no);
	}

}
