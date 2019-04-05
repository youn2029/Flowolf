package kr.or.dev.talk.chat_con.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.talk.chat_con.model.ChatConVO;

@Repository(value="chatConDao")
public class ChatConDao implements ChatConDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

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
		return template.selectList("chatCon.getChatConList", chat_no);
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
		return template.insert("chatCon.insertChatCon", chatConVo);
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
		return template.selectOne("chatCon.getChatConSeq");
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
		return template.selectOne("chatCon.getChatCon", chat_con_no);
	}

}
