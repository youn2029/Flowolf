package kr.or.dev.talk.chat_file.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.talk.chat_file.dao.ChatFileDaoInf;
import kr.or.dev.talk.chat_file.model.ChatFileVO;

@Service("chatFileService")
public class ChatFileService implements ChatFileServiceInf{
	
	@Resource(name="chatFileDao")
	private ChatFileDaoInf chatFileDao;

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
		return chatFileDao.getChatFileList(chat_no);
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
		return chatFileDao.insertChatFile(chatFileVo);
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
		return chatFileDao.getChatFileDetail(chat_file_no);
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
		return chatFileDao.getChatFileSeq();
	}

}
