package kr.or.dev.talk.chat.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.talk.chat.model.ChatVO;

@Repository("chatDao")
public class ChatDao implements ChatDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : getChatList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 채팅방 리스트 반환
	*/
	@Override
	public List<ChatVO> getChatList(String mem_id) {
		return template.selectList("chat.getChatList", mem_id);
	}

	/**
	* Method : getChatDetail
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅방 상세보기
	*/
	@Override
	public ChatVO getChatDetail(int chat_no) {
		return template.selectOne("chat.getChatDetail", chat_no);
	}

	/**
	* Method : insertChat
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatVo
	* @return
	* Method 설명 : 채팅방 등록
	*/
	@Override
	public int insertChat(ChatVO chatVo) {
		return template.insert("chat.insertChat", chatVo);
	}

	/**
	* Method : updateChat
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatVo
	* @return
	* Method 설명 : 채팅방 수정
	*/
	@Override
	public int updateChat(ChatVO chatVo) {
		return template.update("chat.updateChat", chatVo);
	}

	/**
	* Method : deleteChat
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅방 삭제처리
	*/
	@Override
	public int deleteChat(int chat_no) {
		return template.update("chat.deleteChat", chat_no);
	}

	/**
	* Method : getChatSeq
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 채팅 시퀀스 조회
	*/
	@Override
	public int getChatSeq() {
		return template.selectOne("chat.getChatSeq");
	}

}
