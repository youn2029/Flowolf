package kr.or.dev.talk.chat_file.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.talk.chat_file.model.ChatFileVO;

@Repository("chatFileDao")
public class ChatFileDao implements ChatFileDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	

	/**
	* Method : getChatFileList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_no
	* @return
	* Method 설명 : 채팅 파일 목록 반환
	*/
	@Override
	public List<ChatFileVO> getChatFileList(int chat_no) {
		return template.selectList("chatFile.getChatFileList", chat_no);
	}

	/**
	* Method : insertChatFile
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chatFileVo
	* @return
	* Method 설명 : 채팅 파일 등록
	*/
	@Override
	public int insertChatFile(ChatFileVO chatFileVo) {
		return template.insert("chatFile.insertChatFile", chatFileVo);
	}

	/**
	* Method : getChatFileDetail
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param chat_file_no
	* @return
	* Method 설명 : 채팅 파일 상세 조회
	*/
	@Override
	public ChatFileVO getChatFileDetail(int chat_file_no) {
		return template.selectOne("chatFile.getChatFileDetail", chat_file_no);
	}

	/**
	* Method : getChatFileSeq
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @return
	* Method 설명 : 채팅 파일 시퀀스 조회
	*/
	@Override
	public int getChatFileSeq() {
		return template.selectOne("chatFile.getChatFileSeq");
	}

}
