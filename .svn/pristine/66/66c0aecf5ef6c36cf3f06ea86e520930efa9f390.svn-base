package kr.or.dev.timeline.emoticon.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.timeline.basic.dao.BasicDaoInf;
import kr.or.dev.timeline.emoticon.model.EmoticonVO;

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
public class EmoticonDaoTest {

	@Resource(name="emoDao")
	private EmoticonDaoInf emoDao;
	
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
	* Method : emoDaoTest
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : emoDaoTest
	*/
	@Test
	public void emoDaoTest() {
		assertNotNull(emoDao);
	}
	
	/**
	* Method : getEmoAllListTest
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 이모티콘 전체 조회 Test
	*/
	@Test
	public void getEmoAllListTest(){
		/***Given***/		

		/***When***/
		List<EmoticonVO> emoList = emoDao.getEmoAllList();

		/***Then***/
		assertEquals(1, emoList.size());
	}
	
	/**
	* Method : getEmoDetailTest
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 이모티콘 상세 조회 Test
	*/
	@Test
	public void getEmoDetailTest(){
		/***Given***/		

		/***When***/
		EmoticonVO emoVo = emoDao.getEmoDetail(10001);

		/***Then***/
		assertEquals("emo init test", emoVo.getEmo_name());
	}

}
