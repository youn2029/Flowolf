package kr.or.dev.group.box.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.box.model.BoxVO;

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
public class BoxDaoTest {
	
	@Resource(name="boxDao")
	private BoxDaoInf boxDao;
	
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
	* Method : boxDaotest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : boxDao Test
	*/
	@Test
	public void boxDaotest() {
		assertNotNull(boxDao);
	}
	
	/**
	* Method : getBoxMyListTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원별 보관함 조회 Test
	*/
	@Test
	public void getBoxMyListTest(){
		/***Given***/

		/***When***/
		List<BoxVO> myBoxList = boxDao.getBoxMyList("test");

		/***Then***/
		assertEquals(1, myBoxList.size());
	}
	
	/**
	* Method : insertBoxTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 보관함 등록 Test
	*/
	@Test
	public void insertBoxTest(){
		/***Given***/
		BoxVO boxVo = new BoxVO();
		boxVo.setBox_name("test");
		boxVo.setBox_index(2);
		boxVo.setMem_id("test");
		
		/***When***/
		int resultCnt = boxDao.insertBox(boxVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}

	/**
	* Method : updateBoxTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 보관함 수정 Test
	*/
	@Test
	public void updateBoxTest(){
		/***Given***/
		BoxVO boxVo = new BoxVO();
		boxVo.setBox_no(10000);
		boxVo.setBox_name("test수정");
		boxVo.setBox_index(2);
		boxVo.setMem_id("test");
		
		/***When***/
		int resultCnt = boxDao.updateBox(boxVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteBoxRTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 보관함 삭제
	*/
	@Test
	public void deleteBoxTest(){
		/***Given***/		

		/***When***/
		int resultCnt = boxDao.deleteBox(10000);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : getBoxManIndexTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 보관함 조회순번 최대수 조회 Test
	*/
	@Test
	public void getBoxManIndexTest(){
		/***Given***/		

		/***When***/
		int maxIndexCnt = boxDao.getBoxMaxIndex("test");

		/***Then***/
		assertEquals(1, maxIndexCnt);
	}
	
	/**
	* Method : getBoxDetailTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 보관함 
	*/
	@Test
	public void getBoxDetailTest(){
		/***Given***/

		/***When***/
		BoxVO boxVo = boxDao.getBoxDetail(10000);

		/***Then***/
		assertEquals("initTest", boxVo.getBox_name());
	}
	
	/**
	* Method : getProBoxListTest
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 해당 프로젝트의 보관함 유무를 확인할 수 있는 보관함 리스트
	*/
	@Test
	public void getProBoxListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pro_no", 10000);
		paramMap.put("mem_id", "test");

		/***When***/
		List<BoxVO> proBoxList = boxDao.getProBoxList(paramMap);

		/***Then***/
		assertEquals(1, proBoxList.size());
		assertEquals(1, proBoxList.get(0).getPro_box_chk());
	}
}
