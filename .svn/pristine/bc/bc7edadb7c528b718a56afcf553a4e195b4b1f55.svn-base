package kr.or.dev.timeline.todo_item.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.dev.timeline.todo_item.model.TodoItemVO;

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
public class TodoItemDaoTest {
	
	@Resource(name="todoItemDao")
	private TodoItemDaoInf todoItemDao;
	
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
	* Method : todoItemDaoTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : todoItemDao TEST
	*/
	@Test
	public void todoItemDaoTest() {
		assertNotNull(todoItemDao);
	}
	
	/**
	* Method : inserTiTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일 항목 등록 TEST
	*/
	@Test
	public void inserTiTest(){
		/***Given***/
		TodoItemVO tiVo = new TodoItemVO();
		tiVo.setTi_cont("todo item insert test");
		tiVo.setTodo_no(10001);
		tiVo.setTi_date("18/09/21");
		tiVo.setTi_mem_id("test");

		/***When***/
		int insertCnt = todoItemDao.insertTi(tiVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	/**
	* Method : updateTiTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일 항목 수정 TEST
	*/
	@Test
	public void updateTiTest(){
		/***Given***/
		TodoItemVO tiVo = new TodoItemVO();
		tiVo.setTi_cont("todo item update test");
		tiVo.setTi_chk("y");
		tiVo.setTi_no(10001);

		/***When***/
		int updateCnt = todoItemDao.updateTi(tiVo);

		/***Then***/
		assertEquals(1, updateCnt);

	}
	
	/**
	* Method : deleteTiRTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일 항목 삭제 TEST
	*/
	@Test
	public void deleteTiRTest(){
		/***Given***/
		int ti_no = 10001;

		/***When***/
		int deleteCnt = todoItemDao.deleteTiR(ti_no);

		/***Then***/
		assertEquals(1, deleteCnt);

	}
	
	/**
	* Method : getTiListTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일의 항목 조회 TEST
	*/
	@Test
	public void getTiListTest(){
		/***Given***/
		int todo_no = 10001;

		/***When***/
		List<TodoItemVO> tiList = todoItemDao.getTiList(todo_no);

		/***Then***/
		assertEquals(1, tiList.size());
	}

}







