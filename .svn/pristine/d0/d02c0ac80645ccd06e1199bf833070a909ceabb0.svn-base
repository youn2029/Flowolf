package kr.or.dev.group.project_user.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.project.model.ProjectVO;
import kr.or.dev.group.project_user.dao.ProjectUserDaoInf;
import kr.or.dev.group.project_user.model.ProjectUserVO;

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
public class ProjectUserServiceTest {

	@Resource(name="proUserService")
	private ProjectUserServiceInf proUserService;
	
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
	* Method : proUserDaotest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : proUserService Test
	*/
	@Test
	public void proUserServicetest() {
		assertNotNull(proUserService);
	}
	
	/**
	* Method : getProUserListTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트 참여자 조회 Test
	*/
	@Test
	public void getProUserListTest(){
		/***Given***/		

		/***When***/
		List<ProjectUserVO> proUserList = proUserService.getProUserList(10000);

		/***Then***/
		assertEquals(2, proUserList.size());
	}
	
	/**
	* Method : getMyProList
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원의 프로젝트 조회 
	*/
	@Test
	public void getMyProList(){
		/***Given***/		

		/***When***/
		List<Map<String, Object>> myProList = proUserService.getMyProList("test");
		
		/***Then***/
		// 전체크기
		assertEquals(2, myProList.size());
		
		Map<String, Object> map = myProList.get(0);
		
		// 프로젝트 vo
		ProjectVO proVo = (ProjectVO) map.get("proVo");
		assertEquals("initTest", proVo.getPro_name());
		
		// 프로젝트 참여자 List
		List<ProjectUserVO> proUserList = (List<ProjectUserVO>) map.get("proUserList");
		assertEquals(2, proUserList.size());
	}
	
	/**
	* Method : insertProUserTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트 참여자 등록 Test
	*/
	@Test
	public void insertProUserTest(){
		/***Given***/
		ProjectUserVO proUserVo = new ProjectUserVO();
		proUserVo.setPro_no(10001);
		proUserVo.setMem_id("test1");
		proUserVo.setPro_user_man_chk("n");

		/***When***/
		int resultCnt = proUserService.insertProUser(proUserVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : updateProUserTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트 참여자 수정 Test
	*/
	@Test
	public void updateProUserTest(){
		/***Given***/
		ProjectUserVO proUserVo = new ProjectUserVO();
		proUserVo.setPro_no(10000);
		proUserVo.setMem_id("test");
		proUserVo.setPro_user_color("back-color-black");

		/***When***/
		int resultCnt = proUserService.updateProUser(proUserVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteProUserR
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트 참여자 삭제 Test
	*/
	@Test
	public void deleteProUserR(){
		/***Given***/
		ProjectUserVO proUserVo = new ProjectUserVO();
		proUserVo.setPro_no(10000);
		proUserVo.setMem_id("test");

		/***When***/
		int resultCnt = proUserService.deleteProUserR(proUserVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : getProUserSearchListTest
	* 최초작성일 : 2018. 9. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트 참여자 검색 조회 Test
	*/
	@Test
	public void getProUserSearchListTest(){
		/***Given***/
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchField", "mem_id");
		searchMap.put("searchData", "te");

		/***When***/
		List<ProjectUserVO> searchList = proUserService.getProUserSearchList(searchMap);

		/***Then***/
		assertEquals(4, searchList.size());
	}
	
	/**
	* Method : getProUserDetailTest
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트 참여자 상세조회
	*/
	@Test
	public void getProUserDetailTest(){
		/***Given***/
		ProjectUserVO proUserVo = new ProjectUserVO();
		proUserVo.setPro_no(10000);
		proUserVo.setMem_id("test");

		/***When***/
		ProjectUserVO resultVo = proUserService.getProUserDetail(proUserVo);	

		/***Then***/
		assertEquals("n", resultVo.getPro_user_man_chk());
	}

}
