package kr.or.dev.timeline.vote.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.timeline.TimeLine;
import kr.or.dev.timeline.vote.model.VoteVO;

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
public class VoteServiceTest {
	
	@Resource(name="voteService")
	private VoteServiceInf voteService;
	
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
	* Method : voteServiceTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : voteServiceTest
	*/
	@Test
	public void voteServiceTest() {
		assertNotNull(voteService);
	}
	
	/**
	* Method : getVoteSeqTest
	* 최초작성일 : 2018. 10. 7.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 투표 시퀀스 조회 Test
	*/
	@Test
	public void getVoteSeqTest(){
		/***Given***/		

		/***When***/
		int resultCnt = voteService.getVoteSeq();

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : insertVoteTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 투표글 등록 Test
	*/
	@Test
	public void insertVoteTest(){
		/***Given***/
		VoteVO voteVo = new VoteVO();
		voteVo.setVote_no(999);
		voteVo.setVote_title("insert test");
		voteVo.setPro_no(10001);
		voteVo.setMem_id("test2");
		voteVo.setVote_end_time("2018-09-20");

		/***When***/
		int resultCnt = voteService.insertVote(voteVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : updateVoteTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 투표글 수정 Test
	*/
	@Test
	public void updateVoteTest(){
		/***Given***/
		VoteVO voteVo = new VoteVO();
		voteVo.setVote_no(10000);
		voteVo.setVote_title("update test");
		voteVo.setVote_fix_chk("y");
		voteVo.setVote_end_time("2018-09-21");

		/***When***/
		int resultCnt = voteService.updateVote(voteVo);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : deleteVoteTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 투표글 삭제처리 Test
	*/
	@Test
	public void deleteVoteTest(){
		/***Given***/
		
		/***When***/
		int resultCnt = voteService.deleteVote(10000);

		/***Then***/
		assertEquals(1, resultCnt);
	}
	
	/**
	* Method : getVoteDetailTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 투표글 상세조회
	*/
	@Test
	public void getVoteDetailTest(){
		/***Given***/
		
		/***When***/
		VoteVO voteVo = voteService.getVoteDetail(10000);

		/***Then***/
		assertEquals("init vote test", voteVo.getVote_title());
	}
	
	/**
	* Method : getVoteProListTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 프로젝트의 투표글 조회
	*/
	@Test
	public void getVoteProListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pro_no", 10000);
		paramMap.put("mem_id", "test");

		/***When***/
		List<TimeLine> proVoteList = voteService.getVoteProList(paramMap);

		/***Then***/
		assertEquals(1, proVoteList.size());
	}
	
	/**
	* Method : getVoteSearchListTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 :
	*/
	@Test
	public void getVoteSearchListTest(){
		/***Given***/
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchField", "vote_title");
		searchMap.put("searchData", "te");		

		/***When***/
		List<VoteVO> voteSearchList = voteService.getVoteSearchList(searchMap);

		/***Then***/
		assertEquals(1, voteSearchList.size());
	}
	
	/**
	* Method : getVoteCollListTest
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원의 담아둔 투표글 리스트 조회
	*/
	@Test
	public void getVoteCollListTest(){
		/***Given***/
		
		/***When***/
		List<TimeLine> voteCollList = voteService.getVoteCollList("test");

		/***Then***/
		assertEquals(0, voteCollList.size());
	}
	
	/**
	* Method : getMyVoteListTest
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원이 작성한 투표글 리스트 조회
	*/
	@Test
	public void getMyVoteListTest(){
		/***Given***/
		
		/***When***/
		List<TimeLine> myVoteList = voteService.getMyVoteList("test");

		/***Then***/
		assertEquals(1, myVoteList.size());
	}
}
