package kr.or.dev.group.important.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.group.box.dao.BoxDaoInf;
import kr.or.dev.group.important.model.ImportantVO;
import kr.or.dev.group.project.model.ProjectVO;

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
public class ImportantDaoTest {
	
	@Resource(name="impDao")
	private ImportantDaoInf impDao;
	
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
	* Method : impDaoTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : impDao Test
	*/
	@Test
	public void impDaoTest() {
		assertNotNull(impDao);
	}
	
	/**
	* Method : getImpProListTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 중요 프로젝트 정보 조호 Test
	*/
	@Test
	public void getImpProListTest(){
		/***Given***/		

		/***When***/
		List<ProjectVO> proImpList = impDao.getImpProList("test");

		/***Then***/
		assertEquals(1, proImpList.size());

	}
	
	/**
	* Method : insertImpTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 중요 프로젝트 등록 Test
	*/
	@Test
	public void insertImpTest(){
		/***Given***/
		ImportantVO impVo = new ImportantVO();
		impVo.setMem_id("test1");
		impVo.setPro_no(10001);

		/***When***/
		int resultCnt = impDao.insertImp(impVo);

		/***Then***/		
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteImpRTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 중요 프로젝트 삭제 Test
	*/
	@Test
	public void deleteImpRTest(){
		/***Given***/
		ImportantVO impVo = new ImportantVO();
		impVo.setMem_id("test");
		impVo.setPro_no(10000);

		/***When***/
		int resultCnt = impDao.deleteImpR(impVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}

}
