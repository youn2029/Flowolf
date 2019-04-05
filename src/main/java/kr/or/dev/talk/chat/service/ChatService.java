package kr.or.dev.talk.chat.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.dev.common.Format;
import kr.or.dev.talk.chat.dao.ChatDaoInf;
import kr.or.dev.talk.chat.model.ChatVO;
import kr.or.dev.talk.chat_con.model.ChatConFileVO;
import kr.or.dev.talk.chat_con.model.ChatConVO;
import kr.or.dev.talk.chat_con.service.ChatConServiceInf;
import kr.or.dev.talk.chat_file.model.ChatFileVO;
import kr.or.dev.talk.chat_file.service.ChatFileServiceInf;

@Service("chatService")
public class ChatService implements ChatServiceInf {
	
	// 채팅
	@Resource(name="chatDao")
	private ChatDaoInf chatDao;

	// 채팅 내용
	@Resource(name="chatConService")
	private ChatConServiceInf chatConService;
	
	// 채팅 첨부 파일
	@Resource(name="chatFileService")
	private ChatFileServiceInf chatFileService;
	
	/**
	* Method : getChatList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 채팅방 목록 반환
	*/
	@Override
	public List<ChatVO> getChatList(String mem_id) {
		
		List<ChatVO> cList = chatDao.getChatList(mem_id); //내용이 없는 채팅 리스트 
		
		for (int i = 0; i < cList.size(); i++) {
			
			ChatVO chat = cList.get(i); 
			
			List<ChatConFileVO> chatConFileList = new ArrayList<ChatConFileVO>();
			
			// 채팅 내용 List 
			List<ChatConVO> chatConList = chatConService.getChatConList(chat.getChat_no());
			for (ChatConVO ccVo : chatConList) {
				ChatConFileVO ccfVo = new ChatConFileVO();
				ccfVo.setChatConVo(ccVo);
				ccfVo.setTime(ccVo.getChat_con_time());
				chatConFileList.add(ccfVo);
			}			
			
			// 채팅 파일 List
			List<ChatFileVO> chatFileList = chatFileService.getChatFileList(chat.getChat_no());
			for (ChatFileVO cfVo : chatFileList) {
				ChatConFileVO ccfVo = new ChatConFileVO();
				ccfVo.setChatFileVo(cfVo);
				ccfVo.setTime(cfVo.getChat_file_time());
				chatConFileList.add(ccfVo);
			}
			
			// sort
			Collections.sort(chatConFileList);
			
			if (chatConFileList.size() == 0) {		// 채팅방 내용이 없을 때
				
				Date last_chat_con_time = chat.getChat_time();
				chat.setChat_cont("내용 없음");
				chat.setChat_con_time(Format.timeFormat(last_chat_con_time));				
				
			}else{									// 채팅방 내용이 있을 때			
			
				// sort한 List의 마지막 인덱스 값을 ChatVo에 입력
				int lastIndex = chatConFileList.size()-1;
				ChatConFileVO ccfVo = chatConFileList.get(lastIndex);
				
				if (ccfVo.getChatConVo() != null) {
					Date last_chat_con_time = ccfVo.getChatConVo().getChat_con_time();				
					chat.setChat_cont(ccfVo.getChatConVo().getChat_cont());
					chat.setChat_con_time(Format.timeFormat(last_chat_con_time));
				}else{
					Date last_chat_file_time = ccfVo.getChatFileVo().getChat_file_time();	
					chat.setChat_cont("(첨부파일)");
					chat.setChat_con_time(Format.timeFormat(last_chat_file_time));
				}
			}
		}
		
		return cList;
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
		return chatDao.getChatDetail(chat_no);
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
		return chatDao.insertChat(chatVo);
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
		return chatDao.updateChat(chatVo);
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
		return chatDao.deleteChat(chat_no);
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
		return chatDao.getChatSeq();
	}

}
