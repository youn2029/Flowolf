package kr.or.dev.talk.chat.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.talk.chat.model.ChatVO;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/dev/config/spring/root-context.xml",
								 "classpath:kr/or/dev/config/spring/datasource_test.xml",
								 "classpath:kr/or/dev/config/spring/transaction.xml"})
public class ChatDaoTest {

	@Resource(name="chatDao")
	private ChatDaoInf chatDao;
	
	@Before
	public void setUp(){
		// populator : 스프링에서 제공
		// datasource(db 연결정보), 초기화 스크립트
		
		// datasource
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@112.220.114.130:1521:xe");
		dataSource.setUsername("flowolftest");
		dataSource.setPassword("flowolftest");
		
		// 초기화 스크립트(init.sql)
		
		// poplucator 생성
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("kr/or/dev/config/db/init.sql"));
		
		DatabasePopulatorUtils.execute(populator, dataSource);
	}
	
	/**
	* Method : chatDaoTest
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* Method 설명 : chatDaoTest
	*/
	@Test
	public void chatDaoTest() {
		assertNotNull(chatDao);
	}
	
	/**
	* Method : getChatList
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* Method 설명 : 채팅 리스트 반환 test
	*/
	@Test
	public void getChatList(){
		/***Given***/
		

		/***When***/
		List<ChatVO> chatList = chatDao.getChatList("test");
		/***Then***/
		assertEquals(2, chatList.size());

	}
	
	/**
	* Method : getChatDetail
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* Method 설명 : 채팅 상세 조회 test
	*/
	@Test
	public void getChatDetail(){
		/***Given***/
		

		/***When***/
		ChatVO chatVo = chatDao.getChatDetail(10000);
		/***Then***/
		assertEquals("채팅방 init테스트1", chatVo.getChat_title());
	}
	
	/**
	* Method : insertChat
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* Method 설명 : 채팅 생성 test
	*/
	@Test
	public void insertChat(){
		/***Given***/
		ChatVO chatVo = new ChatVO();
		chatVo.setChat_no(10002);
		chatVo.setChat_title("채팅방 init테스트3");
		chatVo.setMem_id("test");
		chatVo.setChat_ip("192.168.207.234");
		chatVo.setChat_port(8180);

		/***When***/
		int cnt = chatDao.insertChat(chatVo);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : updateChat
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* Method 설명 : 채팅 수정 test
	*/
	@Test
	public void updateChat(){
		/***Given***/
		ChatVO chatVo = new ChatVO();
		chatVo.setChat_no(10001);
		chatVo.setChat_title("채팅방 init테스트4");

		/***When***/
		int cnt = chatDao.updateChat(chatVo);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : deleteChat
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* Method 설명 : 채팅방 삭제 test
	*/
	@Test
	public void deleteChat(){
		/***Given***/
		int chat_no = 10000;

		/***When***/
		int cnt = chatDao.deleteChat(chat_no);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : getChatSeq
	* 최초작성일 : 2018. 10. 10.
	* 작성자 : 김요섭
	* 변경이력 :
	* Method 설명 : 채팅방 시퀀스 조회 test
	*/
	@Test
	public void getChatSeq(){
		/***Given***/
		

		/***When***/
		int cnt = chatDao.getChatSeq();
		
		/***Then***/
		assertEquals(1, cnt);
		
	}
	
}
