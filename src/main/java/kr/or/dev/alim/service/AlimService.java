package kr.or.dev.alim.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.dev.alim.dao.AlimDaoInf;
import kr.or.dev.alim.model.AlimVO;

import org.springframework.stereotype.Service;

@Service("alimService")
public class AlimService implements AlimServiceInf{
	
	@Resource(name="alimDao")
	private AlimDaoInf alimDao;

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
		return alimDao.getAlimList(mem_id);
	}

	/**
	* Method : getAlimDetail
	* 최초작성일 : 2018. 10. 5.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param alim_no
	* @return
	* Method 설명 : 알림 번호를 매개변수로 받아 알림 상세보기
	*/
	@Override
	public AlimVO getAlimDetail(int alim_no) {
		return alimDao.getAlimDetail(alim_no);
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
		return alimDao.insertAlim(map);
	}

	/**
	* Method : updateAlim
	* 최초작성일 : 2018. 10. 5.
	* 작성자 : OWNER
	* 변경이력 :
	* @param alim_no
	* @return
	* Method 설명 : 알림번호를 매개변수로 받아 알림 수정
	*/
	@Override
	public int updateAlim(int alim_no) {
		return alimDao.updateAlim(alim_no);
	}

	/**
	* Method : deleteAlim
	* 최초작성일 : 2018. 10. 11.
	* 작성자 : 김요섭
	* 변경이력 :
	* @param alim_no
	* @return
	* Method 설명 : 알림번호를 매개변수로 받아 알림 삭제
	*/
	@Override
	public int deleteAlim(int alim_no) {
		return alimDao.deleteAlim(alim_no);
	}

}
