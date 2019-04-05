package kr.or.dev.timeline.basic.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.dev.timeline.basic.model.BasicVO;

@Repository("basicDao")
public class BasicDao implements BasicDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;	

	/**
	* Method : getBasicSeq
	* 최초작성일 : 2018. 10. 4.
	* 작성자 : 윤성호
	* 변경이력 :
	* @return
	* Method 설명 : 일반글 시퀀스 조회
	*/
	@Override
	public int getBasicSeq() {
		return template.selectOne("basic.getBasicSeq");
	}

	/**
	* Method : insertBasic
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param basicVo
	* @return
	* Method 설명 : 일반글 등록
	*/
	@Override
	public int insertBasic(BasicVO basicVo) {
		return template.insert("basic.insertBasic", basicVo);
	}

	/**
	* Method : updateBasic
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param basicVo
	* @return
	* Method 설명 : 일반글 수정
	*/
	@Override
	public int updateBasic(BasicVO basicVo) {
		return template.update("basic.updateBasic", basicVo);
	}

	/**
	* Method : deleteBasic
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param basic_no
	* @return
	* Method 설명 : 일반글 삭제처리
	*/
	@Override
	public int deleteBasic(int basic_no) {
		return template.update("basic.deleteBasic", basic_no);
	}

	/**
	* Method : getBasicDetail
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param basic_no
	* @return
	* Method 설명 : 일반글 상세조회
	*/
	@Override
	public BasicVO getBasicDetail(int basic_no) {
		return template.selectOne("basic.getBasicDetail", basic_no);
	}

	/**
	* Method : getBasicProList
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param paramMap
	* @return
	* Method 설명 : 프로젝트 일반글 조회
	*/
	@Override
	public List<BasicVO> getBasicProList(Map<String, Object> paramMap) {
		return template.selectList("basic.getBasicProList", paramMap);
	}

	/**
	* Method : getBasicSearchList
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 김지수
	* 변경이력 :
	* @param searchMap
	* @return
	* Method 설명 : 일반글 검색 조회
	*/
	@Override
	public List<BasicVO> getBasicSearchList(Map<String, String> searchMap) {
		return template.selectList("basic.getBasicSearchList", searchMap);
	}

	@Override
	public List<BasicVO> getBasicCollList(String mem_id) {
		return template.selectList("basic.getBasicCollList", mem_id);
	}

	@Override
	public List<BasicVO> getMyBasicList(String mem_id) {
		return template.selectList("basic.getMyBasicList", mem_id);
	}
}
