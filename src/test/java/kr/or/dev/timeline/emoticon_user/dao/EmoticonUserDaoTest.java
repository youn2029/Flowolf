package kr.or.dev.timeline.emoticon_user.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.timeline.emoticon.dao.EmoticonDaoInf;
import kr.or.dev.timeline.emoticon_user.model.EmoticonUserVO;

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
public class EmoticonUserDaoTest {

	@Resource(name="emoUserDao")
	private EmoticonUserDaoInf emoUserDao;
	
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
	* Method : emoUserDaoTest
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : emoUserDaoTest
	*/
	@Test
	public void emoUserDaoTest() {
		assertNotNull(emoUserDao);
	}
	
	/**
	* Method : getEmoUserSeqTest
	* 최초작성일 : 2018. 9. 27.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 이모티콘 사용자 시퀀스 조회
	*/
	@Test
	public void getEmoUserSeqTest(){
		/***Given***/

		/***When***/
		int resultCnt = emoUserDao.getEmoUserSeq();

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : insertEmoUserTest
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 이모티콘 사용자 등록
	*/
	@Test
	public void insertEmoUserTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("emo_user_no", emoUserDao.getEmoUserSeq());
		paramMap.put("emo_no", 10001);
		paramMap.put("timeline_col", "basic_no");
		paramMap.put("timeline_no", 10001);		
		paramMap.put("mem_id", "test2");

		/***When***/
		int resultCnt = emoUserDao.insertEmoUser(paramMap);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteEmoUserRTest
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 이모티콘 사용자 삭제 Test
	*/
	@Test
	public void deleteEmoUserRTest(){
		/***Given***/
		
		/***When***/
		int resultCnt = emoUserDao.deleteEmoUserR(10001);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : getEmoUserListTest
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 해당 글의 이모티콘 사용자 List 조회 Test
	*/
	@Test
	public void getEmoUserListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeline_col", "basic_no");
		paramMap.put("timeline_no", 10001);			

		/***When***/
		List<EmoticonUserVO> emoUserList = emoUserDao.getEmoUserList(paramMap);

		/***Then***/
		assertEquals(1, emoUserList.size());
	}

}
