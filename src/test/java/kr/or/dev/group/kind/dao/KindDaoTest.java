package kr.or.dev.group.kind.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.group.kind.model.KindVO;

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
public class KindDaoTest {
	
	@Resource(name="kindDao")
	private KindDaoInf kindDao;

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
	* Method : kindDaoTest
	* 최초작성일 : 2018. 9. 3.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : kindDao Test
	*/
	@Test
	public void kindDaoTest() {
		assertNotNull(kindDao);
	}
	
	/**
	* Method : insertKindTest
	* 최초작성일 : 2018. 9. 3.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 분류 등록 Test
	*/
	@Test
	public void insertKindTest(){
		/***Given***/
		KindVO kindVo = new KindVO();
		kindVo.setKind_name("test");		

		/***When***/
		int resultCnt = kindDao.insertKind(kindVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : updateKindTest
	* 최초작성일 : 2018. 9. 3.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 분류 수정 Test
	*/
	@Test
	public void updateKindTest(){
		/***Given***/
		KindVO kindVo = new KindVO();
		kindVo.setKind_no(10000);
		kindVo.setKind_name("test수정");

		/***When***/
		int resultCnt = kindDao.updateKind(kindVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteKindTest
	* 최초작성일 : 2018. 9. 3.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 분류 삭제처리 Test
	*/
	@Test
	public void deleteKindTest(){
		/***Given***/
		KindVO kindVo = new KindVO();
		kindVo.setKind_no(10000);
		kindVo.setKind_del_chk("y");

		/***When***/
		int resultCnt = kindDao.deleteKind(kindVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}	
	
	/**
	* Method : getKindAllListTest
	* 최초작성일 : 2018. 9. 3.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 분류 전체 조회 Test
	*/
	@Test
	public void getKindAllListTest(){
		/***Given***/		

		/***When***/
		List<KindVO> allKindList = kindDao.getKindAllList();

		/***Then***/
		assertEquals(1, allKindList.size());
	}
}
