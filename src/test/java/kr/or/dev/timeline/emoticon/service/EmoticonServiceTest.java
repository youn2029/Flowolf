package kr.or.dev.timeline.emoticon.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.timeline.emoticon.dao.EmoticonDaoInf;
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
public class EmoticonServiceTest {

	@Resource(name="emoService")
	private EmoticonServiceInf emoService;
	
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
	* Method : emoServicetest
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : emoServiceTest
	*/
	@Test
	public void emoServiceTest() {
		assertNotNull(emoService);
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
		List<EmoticonVO> emoList = emoService.getEmoAllList();

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
		EmoticonVO emoVo = emoService.getEmoDetail(10001);

		/***Then***/
		assertEquals("emo init test", emoVo.getEmo_name());
	}
}
