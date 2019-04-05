package kr.or.dev.timeline.reply.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.files.model.FilesVO;
import kr.or.dev.timeline.reply.model.ReplyVO;

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
public class ReplyServiceTest {

	@Resource(name="repService")
	private ReplyServiceInf repService;

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
	* Method : repServiceTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : repServiceTest
	*/
	@Test
	public void repServiceTest() {
		assertNotNull(repService);
	}
	
	/**
	* Method : getRepSeqTest
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 댓글 시퀀스 조회
	*/
	@Test
	public void getRepSeqTest(){
		/***Given***/
		
		/***When***/
		int resultCnt = repService.getRepSeq();

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : insertRepTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 댓글 등록 Test
	*/
	@Test
	public void insertRepTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();		
		paramMap.put("rep_no", 999);
		paramMap.put("rep_cont", "rep insert test");
		paramMap.put("mem_id", "test");
		paramMap.put("timeline_col", "basic_no");
		paramMap.put("timeline_no", 10001);

		/***When***/
		int resultCnt = repService.insertRep(paramMap);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : updateRepTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 댓글 수정 Test
	*/
	@Test
	public void updateRepTest(){
		/***Given***/
		ReplyVO repVo = new ReplyVO();
		repVo.setRep_cont("update test");
		repVo.setRep_no(10001);

		/***When***/
		int resultCnt = repService.updateRep(repVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteRepTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 댓글 삭제 Test
	*/
	@Test
	public void deleteRepTest(){
		/***Given***/

		/***When***/
		int resultCnt = repService.deleteRep(10001);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : getRepListTest
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 해당 글의 댓글 조회
	*/
	@Test
	public void getRepListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("timeline_col", "basic_no");
		paramMap.put("timeline_no", 10001);

		/***When***/
		List<Map<String, Object>> repMap = repService.getRepList(paramMap);

		/***Then***/
		ReplyVO repVo = (ReplyVO) repMap.get(0).get("repVo");
		List<FilesVO> filesList = (List<FilesVO>) repMap.get(0).get("filesList");
		
		assertEquals("init rep cont", repVo.getRep_cont());
		assertEquals(0, filesList.size());
	}
}
