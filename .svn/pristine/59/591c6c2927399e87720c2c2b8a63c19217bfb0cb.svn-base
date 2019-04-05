package kr.or.dev.timeline.todo.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.timeline.todo.model.TodoVO;

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
public class TodoDaoTest {
	
	@Resource(name="todoDao")
	private TodoDaoInf todoDao;
	
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
	* Method : todoDaoTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : todoDao TEST
	*/
	@Test
	public void todoDaoTest() {
		assertNotNull(todoDao);
	}
	
	/**
	* Method : insertTodoTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일 등록 TEST
	*/
	@Test
	public void insertTodoTest(){
		/***Given***/
		TodoVO todoVo = new TodoVO();
		todoVo.setTodo_title("todo insert test");
		todoVo.setTodo_rate(20);
		todoVo.setPro_no(10001);
		todoVo.setMem_id("test");

		/***When***/
		int insertCnt = todoDao.insertTodo(todoVo);

		/***Then***/
		assertEquals(1, insertCnt);

	}
	
	/**
	* Method : updateTodoTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일 수정 TEST
	*/
	@Test
	public void updateTodoTest(){
		/***Given***/
		TodoVO todoVo = new TodoVO();
		todoVo.setTodo_title("todo update test");
		todoVo.setTodo_rate(40);
		todoVo.setTodo_fix_chk("n");
		todoVo.setTodo_no(10001);

		/***When***/
		int updateCnt = todoDao.updateTodo(todoVo);

		/***Then***/
		assertEquals(1, updateCnt);

	}
	
	/**
	* Method : deleteTodoTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일 삭제 처리 TEST
	*/
	@Test
	public void deleteTodoTest(){
		/***Given***/
		int todo_no = 10001;

		/***When***/
		int deleteCnt = todoDao.deleteTodo(todo_no);

		/***Then***/
		assertEquals(1, deleteCnt);

	}
	
	/**
	* Method : getTodoDetailTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일 상세조회 TEST
	*/
	@Test
	public void getTodoDetailTest(){
		/***Given***/
		int todo_no = 10001;

		/***When***/
		TodoVO todoVo = todoDao.getTodoDetail(todo_no);

		/***Then***/
		assertEquals("todo test title", todoVo.getTodo_title());
		assertEquals(20, todoVo.getTodo_rate());

	}
	
	/**
	* Method : getTodoProListTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 프로젝트의 할일 조회 TEST
	*/
	@Test
	public void getTodoProListTest(){
		/***Given***/
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pro_no", 10001);
		paramMap.put("mem_id", "test");

		/***When***/
		List<TodoVO> todoProList = todoDao.getTodoProList(paramMap);

		/***Then***/
		assertEquals(1, todoProList.size());

	}
	
	/**
	* Method : getTodoSearchListTest
	* 최초작성일 : 2018. 9. 21.
	* 작성자 : 김지수
	* 변경이력 :
	* Method 설명 : 할일 검색 조회 TEST
	*/
	@Test
	public void getTodoSearchListTest(){
		/***Given***/
		Map<String, String> todoSearchMap = new HashMap<String, String>();
		todoSearchMap.put("searchField", "todo_title");
		todoSearchMap.put("searchData", "todo");

		/***When***/
		List<TodoVO> searchList = todoDao.getTodoSearchList(todoSearchMap);

		/***Then***/
		assertEquals(1, searchList.size());
	}
	
	/**
	* Method : getTodoCollListTest
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원의 담아둔 할일글 리스트 조회 Test
	*/
	@Test
	public void getTodoCollListTest(){
		/***Given***/		

		/***When***/
		List<TodoVO> todoCollList = todoDao.getTodoCollList("test");

		/***Then***/
		assertEquals(1, todoCollList.size());
	}
	
	/**
	* Method : getMyTodoListTest
	* 최초작성일 : 2018. 10. 14.
	* 작성자 : 윤성호
	* 변경이력 :
	* Method 설명 : 회원이 작성한 할일글 리스트 조회 Test
	*/
	@Test
	public void getMyTodoListTest(){
		/***Given***/		

		/***When***/
		List<TodoVO> myTodoList = todoDao.getMyTodoList("test");

		/***Then***/
		assertEquals(1, myTodoList.size());
	}
}
