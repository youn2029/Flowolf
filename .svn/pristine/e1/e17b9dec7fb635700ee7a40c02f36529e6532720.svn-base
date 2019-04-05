package kr.or.dev.group.box_project.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.box_project.dao.BoxProjectDaoInf;
import kr.or.dev.group.box_project.model.BoxProjectVO;
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
public class BoxProjectServiceTest {

	@Resource(name="boxProService")
	private BoxProjectServiceInf boxProService;
	
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
	* Method : boxProDaoTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : boxProService Test
	*/
	@Test
	public void boxProServiceTest() {
		assertNotNull(boxProService);
	}
	
	/**
	* Method : insertBoxPro
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 보관함에 프로젝트 등록 Test
	*/
	@Test
	public void insertBoxPro(){
		/***Given***/
		BoxProjectVO boxProVo = new BoxProjectVO();
		boxProVo.setBox_no(10000);
		boxProVo.setPro_no(10001);

		/***When***/
		int resultCnt = boxProService.insertBoxPro(boxProVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteBoxProTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 보관함에 프로젝트 삭제
	*/
	@Test
	public void deleteBoxProRTest(){
		/***Given***/
		BoxProjectVO boxProVo = new BoxProjectVO();
		boxProVo.setBox_no(10000);
		boxProVo.setPro_no(10000);
		
		/***When***/
		int resultCnt = boxProService.deleteBoxProR(boxProVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : getBoxProListTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 보관함에 있는 모든 프로젝트 조회
	*/
	@Test
	public void getBoxProListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("box_no", 10000);
		paramMap.put("mem_id", "test");

		/***When***/
//		List<ProjectVO> boxProList = boxProService.getBoxProList(paramMap);

		/***Then***/
//		assertEquals(1, boxProList.size());
	}

}
