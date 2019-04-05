package kr.or.dev.files.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.files.model.FilesVO;

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
public class FilesDaoTest {
	
	@Resource(name="filesDao")
	private FilesDaoInf filesDao;
	
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
	* Method : filesDaoTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : filesDaoTest
	*/
	@Test
	public void filesDaoTest() {
		assertNotNull(filesDao);
	}
	
	/**
	* Method : insertFilesTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 첨부파일 등록 Test
	*/
	@Test
	public void insertFilesTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("files_name", "insert files test");
		paramMap.put("files_path", "insert files test");
		paramMap.put("files_upload", "insert files test");
		paramMap.put("timeline_col", "task_no");
		paramMap.put("timeline_no", 10001);
		paramMap.put("files_kind", "img");
		paramMap.put("files_size", "1 KB");

		/***When***/
		int resultCnt = filesDao.insertFiles(paramMap);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteFilesRTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 첨부파일 삭제 Test
	*/
	@Test
	public void deleteFilesRTest(){
		/***Given***/
		
		/***When***/
		int resultCnt = filesDao.deleteFilesR(10001);
		
		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : getFilesDetailTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 첨부파일 상세 조회 Test
	*/
	@Test
	public void getFilesDetailTest(){
		/***Given***/		

		/***When***/
		FilesVO filesVo = filesDao.getFilesDetail(10001);

		/***Then***/
		assertEquals("init files name", filesVo.getFiles_name());
	}
	
	/**
	* Method : getFilesListTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 해당 글의 첨부파일 조회 Test
	*/
	@Test
	public void getFilesListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeline_col", "basic_no");
		paramMap.put("timeline_no", 10001);

		/***When***/
		List<FilesVO> filesList = filesDao.getFilesList(paramMap);

		/***Then***/
		assertEquals(1, filesList.size());
	}
	
	/**
	* Method : getFilesSearchListTest
	* 최초작성일 : 2018. 09. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 파일 검색 Test
	*/
	@Test
	public void getFilesSearchListTest(){
		/***Given***/
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchField", "files_name");
		searchMap.put("searchData", "fil");

		/***When***/
		List<FilesVO> filesSearchList = filesDao.getFilesSearchList(searchMap);

		/***Then***/
		assertEquals(1, filesSearchList.size());
	}
	
	/**
	* Method : getFilesBaTaAllListTest
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원이 참여중인 프로젝트의 (일반,업무)글의 파일 조회 Test
	*/
	@Test
	public void getFilesBaTaAllListTest(){
		/***Given***/
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("timeline", "basic");
		paramMap.put("mem_id", "test");

		/***When***/
		List<FilesVO> basicFilesList = filesDao.getFilesBaTaAllList(paramMap);

		/***Then***/
		assertEquals(1, basicFilesList.size());
	}
	
	/**
	* Method : getFilesRepAllListTest
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원이 참여중인 프로젝트의 해당 타임라인의 댓글 파일 조회 Test
	*/
	@Test
	public void getFilesRepAllListTest(){
		/***Given***/
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("timeline", "basic");
		paramMap.put("timeline_col", "basic_no");
		paramMap.put("mem_id", "test");

		/***When***/
		List<FilesVO> repFilesList = filesDao.getFilesRepAllList(paramMap);

		/***Then***/
		assertEquals(0, repFilesList.size());
	}	
	
	/**
	* Method : getProFilesBaTaAllListTest
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트의 (일반, 업무)글의 파일 조회
	*/
	@Test
	public void getProFilesBaTaAllListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeline", "basic");
		paramMap.put("pro_no", 10000);

		/***When***/
		List<FilesVO> proBasicFilesList = filesDao.getProFilesBaTaAllList(paramMap);

		/***Then***/
		assertEquals(0, proBasicFilesList.size());

	}
	
	/**
	* Method : getProFilesRepAllListTest
	* 최초작성일 : 2018. 10. 12.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트의 해당 타임라인의 댓글 파일 조회 
	*/
	@Test
	public void getProFilesRepAllListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeline", "basic");
		paramMap.put("timeline_col", "basic_no");
		paramMap.put("pro_no", 10000);

		/***When***/
		List<FilesVO> proRepFilesList = filesDao.getProFilesRepAllList(paramMap);

		/***Then***/
		assertEquals(0, proRepFilesList.size());
	}
}
