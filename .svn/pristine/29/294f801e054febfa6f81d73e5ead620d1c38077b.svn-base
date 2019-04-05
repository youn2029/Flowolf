package kr.or.dev.user.member.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.group.project.dao.ProjectDaoInf;
import kr.or.dev.user.member.model.MemberVO;

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
public class MemberDaoTest {

	@Resource(name="memDao")
	private MemberDaoInf memDao;

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
	* Method : memDaoTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : memDao Test
	*/
	@Test
	public void memDaoTest() {
		assertNotNull(memDao);
	}

	/**
	* Method : insertMemTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원 등록 Test
	*/
	@Test
	public void insertMemTest(){
		/***Given***/
		MemberVO memVo = new MemberVO();
		memVo.setMem_id("memDaoTest");
		memVo.setMem_name("dao테스트");
		memVo.setMem_nick("daoTest");
		memVo.setMem_pw("1234");
		memVo.setMem_pic_name("daoTest");
		memVo.setMem_pic_path("daoTest");
		memVo.setMem_pic_upload("daoTest");
		memVo.setMem_phone("01099999999");
		memVo.setMem_howjoin("b");

		/***When***/
		int resultCnt = memDao.insertMem(memVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : updateMemTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원 정보 수정 Test
	*/
	@Test
	public void updateMemTest(){
		/***Given***/
		MemberVO memVo = new MemberVO();
		memVo.setMem_id("test1");
		memVo.setMem_name("dao테스트");
		memVo.setMem_nick("daoTest");
		memVo.setMem_pw("1234");
		memVo.setMem_alim_kind("p");
		memVo.setMem_pic_name("dao수정Test");
		memVo.setMem_pic_path("dao수정Test");
		memVo.setMem_pic_upload("dao수정Test");

		/***When***/
		int resultCnt = memDao.updateMem(memVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteMemTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원 비활성화 Test
	*/
	@Test
	public void deleteMemTest(){
		/***Given***/
		
		/***When***/
		int resultCnt = memDao.deleteMem("test1");

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : getMemDetailTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원 상세 조회 Test
	*/
	@Test
	public void getMemDetailTest(){
		/***Given***/		

		/***When***/
		MemberVO memVo = memDao.getMemDetail("test");

		/***Then***/
		assertEquals("테스트닉", memVo.getMem_nick());
	}
	
	/**
	* Method : chkMemIdTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : ID 중복 체크 Test
	*/
	@Test
	public void chkMemIdTest(){
		
		/***Given***/

		/***When***/
		int chk1 = memDao.chkMemId("test");
		int chk2 = memDao.chkMemId("없는test");

		/***Then***/
		assertEquals(1, chk1);
		assertEquals(0, chk2);
	}
	
	/**
	* Method : chkMemNickTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 닉네임 중복 체크 Test
	*/
	@Test
	public void chkMemNickTest(){
		/***Given***/		

		/***When***/
		int chk1 = memDao.chkMemNick("테스트닉1");
		int chk2 = memDao.chkMemNick("없는테스트닉");

		/***Then***/
		assertEquals(1, chk1);
		assertEquals(0, chk2);

	}
	
	/**
	* Method : getMemAllListTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 총 회원 정보 조회 Test
	*/
	@Test
	public void getMemAllListTest(){
		/***Given***/		
		
		/***When***/
		List<MemberVO> allMemList = memDao.getMemAllList("test");

		/***Then***/
		assertEquals(4, allMemList.size());

	}
	
	/**
	* Method : getMemSearchList
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원 검색 Test
	*/
	@Test
	public void getMemSearchList(){
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchField", "mem_nick");
		map.put("searchData", "테스트");
		
		/***When***/
		List<MemberVO> resultList = memDao.getMemSearchList(map);

		/***Then***/
		assertEquals(4, resultList.size());

	}
	
	/**
	* Method : findIdTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : mem_id 찾기 Test
	*/
	@Test
	public void findIdTest(){		
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_name", "테스트1");
		map.put("mem_phone", "01000000000");				

		/***When***/
		String mem_id = memDao.findId(map);

		/***Then***/
		assertEquals("test1", mem_id);
	}
	
	/**
	* Method : getMemChkTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 비밀번호 찾을때 회원 조회 Test
	*/
	@Test
	public void getMemChkTest(){
		/***Given***/
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_name", "테스트1");
		map.put("mem_id", "test1");	
		map.put("mem_phone", "01000000000");
		
		/***When***/
		String mem_id = memDao.getMemChk(map);

		/***Then***/
		assertEquals("test1", mem_id);
	}
	
	/**
	* Method : getMemAllCntTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 총 회원 수 조회 Test
	*/
	@Test
	public void getMemAllCntTest(){
		/***Given***/		

		/***When***/
		int cnt = memDao.getMemAllCnt();

		/***Then***/
		assertEquals(3, cnt);
	}
	
	/**
	* Method : getMemHowjoinCntTest
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 가입방법별 회원수 조회 Test
	*/
	@Test
	public void getMemHowjoinCntTest(){
		/***Given***/		

		/***When***/
		int cnt = memDao.getMemHowjoinCnt("b");

		/***Then***/
		assertEquals(3, cnt);
	}
}
