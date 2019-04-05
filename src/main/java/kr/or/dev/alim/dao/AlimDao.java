package kr.or.dev.alim.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.alim.model.AlimVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("alimDao")
public class AlimDao implements AlimDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : getAlimList
	* 최초작성일 : 2018. 10. 5.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param mem_id
	* @return
	* Method 설명 : 회원id를 매개변수로 받아 알림 리스트 반환
	*/
	@Override
	public List<AlimVO> getAlimList(String mem_id) {
		return template.selectList("alim.getAlimList", mem_id);
	}

	/**
	* Method : getAlimDetail
	* 최초작성일 : 2018. 10. 5.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param alim_no
	* @return
	* Method 설명 : 알림 번호를 매개변수로 받아 해당 알림 상세보기 
	*/
	@Override
	public AlimVO getAlimDetail(int alim_no) {
		return template.selectOne("alim.getAlimDetail", alim_no);
	}

	/**
	* Method : insertAlim
	* 최초작성일 : 2018. 10. 5.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : map객체를 매개변수로 받아 알림 등록
	*/
	@Override
	public int insertAlim(Map<String, Object> map) {
		return template.insert("alim.insertAlim", map);
	}

	/**
	* Method : updateAlim
	* 최초작성일 : 2018. 10. 5.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param alim_no
	* @return
	* Method 설명 : 알림 번호를 매개변수로 받아 알림 수정
	*/
	@Override
	public int updateAlim(int alim_no) {
		return template.update("alim.updateAlim", alim_no);
	}

	/**
	* Method : deleteAlim
	* 최초작성일 : 2018. 10. 11.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param alim_no
	* @return
	* Method 설명 : 알림 번호를 매개변수로 받아 알림 삭제
	*/
	@Override
	public int deleteAlim(int alim_no) {
		return template.delete("alim.deleteAlim", alim_no);
	}

}
